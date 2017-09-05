package org.lang.redis.api;

import org.junit.Test;
import org.lang.redis.ClientFactory;

import redis.clients.jedis.Jedis;

/**
 * @author zuo
 * 在Redis中，set就是Redis String的无序集合，不允许有重复元素。
 * 
 * 不能重复的value 添加sadd smembers拿到所有的列表 scard数量
 */
public class SetRedis {
	/**
	 * 清除所有数据
	 */
	@Test
	public void FlushDb() {
		Jedis client = ClientFactory.getJedis();
		client.flushAll();
	}
	/**
	 * set添加数据
	 */
	@Test
	public void sadd() {
		Jedis client = ClientFactory.getJedis();
		client.sadd("001", "zuo");
		client.sadd("001", "lang");
	}
	/**
	 * set查看所有数据
	 */
	@Test
	public void smembers() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.smembers("001"));
		
	}
	/**
	 * 出栈
	 */
	@Test
	public void spop() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.spop("001"));
		
	}
	/**
	 * 删除指定数据
	 */
	@Test
	public void srem() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.srem("001","zuo"));
		
	}
	/**
	 * 数据个数
	 */
	@Test
	public void scard() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.scard("001"));
		
	}
	/**
	 * 判断是否存在
	 */
	@Test
	public void sismember() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.sismember("001","lang"));
		
	}
}
