package com.zl.bo.pub;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;
@Repository("redisBO")
public class RedisBO {
//	@Autowired
//	private StringRedisTemplate redisTemplate;
	
	private Jedis jedis = null;
		
	public RedisBO() {
		super();
		jedis = new Jedis("127.0.0.1", 6379);
	}
	public void setValue(String key,String value) {
		jedis.set(key, value);
	}
	public String getValue(String key) {
		return jedis.get(key);
	}
	
	public static void main(String[] args) {
		RedisBO bo = new RedisBO();
		bo.setValue("test", "hello world");
		System.out.println(bo.getValue("test"));
	}
	
}
