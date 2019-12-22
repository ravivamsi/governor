/**
 * 
 */
package com.servec.governor.commons;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/**
 * @author vamsiravi
 *
 */
public class MongoConnector {

	private static MongoClient mongoClient;

	public static MongoDatabase getDatabase() {

		MongoClientURI uri = new MongoClientURI("mongodb+srv://" + System.getProperty("spring.data.mongodb.username")
				+ ":" + System.getProperty("spring.data.mongodb.password")
				+ "@servecdb-murck.azure.mongodb.net/test?retryWrites=true&w=majority");

		mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase(System.getProperty("spring.data.mongodb.database"));
		
		return database;
		
		
	}
	
	
	public static Boolean testConnection() {
		MongoClientURI uri = new MongoClientURI("mongodb+srv://" + System.getProperty("spring.data.mongodb.username")
		+ ":" + System.getProperty("spring.data.mongodb.password")
		+ "@servecdb-murck.azure.mongodb.net/test?retryWrites=true&w=majority");

		mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("Worker");

		if(database.getName().isEmpty()) {
			return Boolean.FALSE;
		}else {
			return Boolean.TRUE;
		}
	}

}
