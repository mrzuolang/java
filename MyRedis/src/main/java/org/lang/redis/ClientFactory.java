package org.lang.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class ClientFactory {
	private static JedisPoolConfig initPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 控制一个pool最多有多少个状态为idle的jedis实例
		jedisPoolConfig.setMaxIdle(200);
		// 最大能够保持空闲状态的对象数
		jedisPoolConfig.setMaxIdle(300);
		// 超时时间
		jedisPoolConfig.setMaxWaitMillis(5000);
		// 在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
		jedisPoolConfig.setTestOnBorrow(true);
		// 在还会给pool时，是否提前进行validate操作
		jedisPoolConfig.setTestOnReturn(true);
		return jedisPoolConfig;
	}

	public static Jedis getJedis() {
		JedisPool pool = new JedisPool("127.0.0.1", 6379);
		return pool.getResource();
	}
}
