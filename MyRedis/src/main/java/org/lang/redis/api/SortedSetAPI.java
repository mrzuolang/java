package org.lang.redis.api;

import org.junit.Test;
import org.lang.redis.ClientFactory;

import redis.clients.jedis.Jedis;

/**
 * @author zuo
 * 与set的主要差别就是每一个成员都有一个分数(score)与之关联,redis正是通过分数来为集合中的成员进行排序。值得注意的是
 * value是必须唯一的，但score却可以重复。
 * 在sorted-set中的添加、删除、更新一个成员都是非常快速的操作，时间复杂度是集合成员数量的对数。
 */
public class SortedSetAPI {
	/**
	 * 清除所有数据
	 */
	@Test
	public void FlushDb() {
		Jedis client = ClientFactory.getJedis();
		client.flushAll();
	}
	/**
	 * zset添加数据
	 */
	@Test
	public void zadd() {
		Jedis client = ClientFactory.getJedis();
		client.zadd("zset", 0, "000");
		client.zadd("zset", 1, "111");
		client.zadd("zset", 2, "222");
		client.zadd("zset", 3, "333");
		client.zadd("zset", 4, "444");
	}
	/**
	 * 按照scorce删除
	 */
	@Test
	public void zremrangeByScore() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.zremrangeByScore("zset",2,3));
		
	}
	/**
	 * 按照range删除
	 */
	@Test
	public void zremrangeByRank() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.zremrangeByRank("zset",2,3));
		
	}
	/**
	 * 根据score截取
	 */
	@Test
	public void zrangeByScore() {
		Jedis client = ClientFactory.getJedis();
		System.out.println(client.zrangeByScore("zset",0,3));
		
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
