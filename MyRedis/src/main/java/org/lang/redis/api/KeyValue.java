package org.lang.redis.api;

import org.junit.Test;
import org.lang.redis.ClientFactory;

import redis.clients.jedis.Jedis;

/**
 * @author zuo
 * redis key value set get append clean 
 */
public class KeyValue {
	
	
	@Test
	public void FlushDb() {
		Jedis client = ClientFactory.getJedis();
		client.flushAll();
	}
	@Test
	public void setKey() {
		Jedis client = ClientFactory.getJedis();
		client.set("zuo", "lang");
	}
	@Test
	public void getValue() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.get("zuo"));
		
	}
	@Test
	public void append() {
		Jedis client = ClientFactory.getJedis();
		client.append("zuo", "Hello world");
		System.out.println(client.get("zuo"));
		
	}
}
