package org.lang.redis.api;

import org.junit.Test;
import org.lang.redis.ClientFactory;

import redis.clients.jedis.Jedis;

/**
 * @author zuo
 * lpush,rpush,lpop,rpop,lrange
 * Lists 就是链表，
 */
public class ListRedis {
	
	
	@Test
	public void FlushDb() {
		Jedis client = ClientFactory.getJedis();
		client.flushAll();
	}
	@Test
	public void lpush() {
		Jedis client = ClientFactory.getJedis();
		client.lpush("zip", "java","c++");
	}
	@Test
	public void rpush() {
		Jedis client = ClientFactory.getJedis();
		client.rpush("zip", "java","c++");
		
	}
	@Test
	public void lpop() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.lpop("zip"));
		
	}
	@Test
	public void lrange() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.getrange("zip",0,2));
		
	}
}
