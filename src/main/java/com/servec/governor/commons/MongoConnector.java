/**
 * 
 */
package com.servec.governor.commons;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/**
 * @author vamsiravi
 *
 */
public class MongoConnector {

	private static MongoClient mongoClient;

	public static MongoClientOptions config() {
		MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
		// build the connection options
		builder.maxConnectionIdleTime(60000);// set the max wait time in (ms)
		MongoClientOptions opts = builder.build();

		return opts;
	}

	public static MongoDatabase getDatabase() {

		MongoClientURI uri = new MongoClientURI("mongodb+srv://" + System.getProperty("spring.data.mongodb.username")
				+ ":" + System.getProperty("spring.data.mongodb.password")
				+ "@servecdb-murck.azure.mongodb.net/test?retryWrites=true&w=majority");

		mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase(System.getProperty("spring.data.mongodb.database"));

		return database;

	}

	public static MongoDatabase getDatabaseByName(String databasename) {
		MongoClientURI uri = new MongoClientURI("mongodb+srv://" + System.getProperty("spring.data.mongodb.username")
				+ ":" + System.getProperty("spring.data.mongodb.password")
				+ "@servecdb-murck.azure.mongodb.net/test?retryWrites=true&w=majority");

		mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("databasename");

		return database;
	}

	public static Boolean testConnection() {
		MongoClientURI uri = new MongoClientURI("mongodb+srv://" + System.getProperty("spring.data.mongodb.username")
				+ ":" + System.getProperty("spring.data.mongodb.password")
				+ "@servecdb-murck.azure.mongodb.net/test?retryWrites=true&w=majority");

		mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("Worker");

		if (database.getName().isEmpty()) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}

}
