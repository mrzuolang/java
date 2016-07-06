package com.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC {
	static MongoCollection<Document> tb1 = null;
	static MongoDatabase db = null;
	static MongoClient mc = null;

	public static MongoClient getClient() {

		if (mc == null) {
			mc = new MongoClient("192.168.0.206", 27017);
		}
		return mc;
	}
}