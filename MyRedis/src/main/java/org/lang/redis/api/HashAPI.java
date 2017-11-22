package org.lang.redis.api;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.lang.redis.ClientFactory;

import redis.clients.jedis.Jedis;

/**
 * @author zuo
 * 相当于存的,<key,Map<String,String>
 */
public class HashAPI {
	
	
	@Test
	public void FlushDb() {
		Jedis client = ClientFactory.getJedis();
		client.flushAll();
	}
	/**
	 * 添加数据
	 */
	@Test
	public void hmset() {
		Jedis client = ClientFactory.getJedis();
		Map<String, String> mapA =new HashMap<String, String>();
		mapA.put("001", "A");
		mapA.put("002", "AA");
		mapA.put("003", "AAAA");
		mapA.put("004", "AAAA");
		mapA.put("005", "AAAAA");
		client.hmset("hash", mapA);
	}
	@Test
	public void hmget() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.hmget("hash","001"));
		
	}
	/**
	 * 按key删除value
	 */
	@Test
	public void hdel() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.hdel("hash","005"));
		
	}
	/**
	 * 取出所有的键
	 */
	@Test
	public void hkeys() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.hkeys("hash"));
		
	}
	/**
	 * 取出所有的值
	 */
	@Test
	public void hvals() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.hvals("hash"));
		
	}
	/**
	 * 判断key是否存在
	 */
	@Test
	public void exists() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.exists("hash","003"));
		
	}
	
}
