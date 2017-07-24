import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ValidationOptions;

public class TestMongoCURL {
	String myUserName = "admin";
	String myPassword = "admin";
	ServerAddress address = new ServerAddress("127.0.0.1", 27017);
	MongoClient client = new MongoClient(address);

	/**
	 * 数据库列表
	 */
	public void showdb() {
		List<String> dbs = client.getDatabaseNames();
		System.out.print("DataBases:");
		for (String db : dbs) {
			System.out.print(db + ", ");
		}
		System.out.println("");
		System.out.print("tables:");
		for (String db : dbs)
			showtbs(db);
	}

	public void showtbs(String db) {
		MongoIterable<String> tbNames = client.getDatabase(db).listCollectionNames();
		for (String name : tbNames) {
			System.out.print(name + ", ");
		}
	}

	public void showData(String dbName, String tbName) {
		MongoCollection<Document> docs = client.getDatabase(dbName).getCollection(tbName);
		FindIterable<Document> doc = docs.find();
		Document item = null;
	}

	public void insert(String dbName, String tbName) {
		ServerAddress address = new ServerAddress("127.0.0.1", 27017);
		MongoClient client = new MongoClient(address);
		MongoCollection<Document> coll = client.getDatabase(dbName).getCollection(tbName);

		Document doc = new Document();
		doc.append("id", "8");
		doc.append("name", "tianlang");
		coll.insertOne(doc);
		doc = new Document();
		doc.append("id", "6");
		doc.append("name", "langlang");
		coll.insertOne(doc);
		client.close();
	}
	public void createTable(String dbName) {
		ValidationOptions collOptions = new ValidationOptions().validator(
				Filters.and(Filters.exists("ts"), 
				Filters.exists("user_id"),
				Filters.exists("fun")));
		CreateCollectionOptions options = new CreateCollectionOptions().validationOptions(collOptions);
		client.getDatabase(dbName).createCollection("pub_log",options);
	}
	public static void main(String[] args) {
		new TestMongoCURL().createTable("blog");
		//new TestMongoCURL().insert("blog", "user");
	}
}
