package com.mongo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.str.StringFactory;

public class InsertThread implements Runnable {
	private MongoClient mc = null;

	Logger log = LogManager.getLogger(InsertThread.class);
	private String db = null;
	private String tab = null;
	private int len;
	private int buf;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss:SSS");
	public static AtomicInteger b = new AtomicInteger(0);

	public InsertThread(MongoClient mc, String db, String tab, int len, int buf) {
		super();
		this.mc = mc;
		this.db = db;
		this.tab = tab;
		this.len = len;
		this.buf = buf;
	}

	public void run() {
		MongoDatabase mdb = mc.getDatabase(db);
		MongoCollection<Document> coll = mdb.getCollection(tab);
		long num = 0;// 数据个数
		long size = 0;// 数据大小
		String post = "数据库：" + db + "|表格：" + tab + "|消息体大小：" + len + "|一次发送数据个数：" + buf;
		int post_len = post.length() - 1;
		StringBuffer msg = new StringBuffer(post);
		int init = 0;
		int append = 0;
		long da = 0;
		while (buf > 0) {
			num++;
			size += len;

			da = System.currentTimeMillis();
			msg.append("|日期：");
			msg.append(sdf.format(new Date(da)));
			msg.append("|毫秒：");
			msg.append(da);
			msg.append("|记录：");
			msg.append(num);
			msg.append("|当前数据大小：");
			msg.append(size);

			init = msg.length();
			append = len - init;

			String key = StringFactory.uniqueStr(append);
			String value = StringFactory.uniqueStr(append);
			String tem = msg.toString();
			Document doc = new Document(tem + key, tem + value);
			try {
				coll.insertOne(doc);
				buf--;
				b.addAndGet(-1);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(tem);
			}finally {
				
			}
			log.info(new String(tem));
			msg.delete(post_len, tem.length());
		}
//		coll=null;
//		mdb=null;
//		mc.close();
//		msg=null;
//		sdf=null;
	}

}
