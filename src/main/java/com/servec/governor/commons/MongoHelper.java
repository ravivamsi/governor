/**
 * 
 */
package com.servec.governor.commons;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.servec.governor.models.Project;

/**
 * @author vamsiravi
 *
 */
public class MongoHelper {

	public static List<Project> getAllProjectDocuments(MongoCollection<Document> col)
			throws JsonMappingException, JsonProcessingException {
		List<Project> projectsList = new ArrayList<Project>();
		FindIterable<Document> fi = col.find();
		MongoCursor<Document> cursor = fi.iterator();
		try {
			while (cursor.hasNext()) {
				ObjectMapper mapper = new ObjectMapper();
				Project project = mapper.readValue(cursor.next().toJson(), Project.class);
				projectsList.add(project);
			}
		} finally {
			cursor.close();
		}
		return projectsList;
	}

}
