package com.mongo.read;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ReadMongo {
	public static void main(String args[]) {
		try {
			// 连接到 mongodb 服务
			MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

			// 连接到数据库
			MongoDatabase mongoDatabase = mongoClient.getDatabase("db1");
			System.out.println("Connect to database successfully");

			MongoCollection<Document> collection = mongoDatabase.getCollection("tb1");
			System.out.println("集合 test 选择成功");

			// 检索所有文档
			/**
			 * 1. 获取迭代器FindIterable<Document> 2. 获取游标MongoCursor<Document> 3.
			 * 通过游标遍历检索出的文档集合
			 * */
			FindIterable<Document> findIterable = collection.find();
			MongoCursor<Document> mongoCursor = findIterable.iterator();
			int re = 1;
			while (mongoCursor.hasNext()) {
				Document doc = mongoCursor.next();
				System.out.println(doc.toJson());
				ProducerRecord<String, String> record = new ProducerRecord<String, String>("test1", doc.toJson(), doc.toJson());
				Producer<String, String> producer = getProducer();
				producer.send(record);
				re++;
				if (re >= 100) {
					System.out.println("flush"+doc.getString("key"));
					producer.flush();
					re=0;
				}
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	private static Producer<String, String> getProducer() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.0.203:9092");
		props.put("acks", "1");
		props.put("retries", 0);
		props.put("batch.size", 1);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 128);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		return producer;
	}
}
