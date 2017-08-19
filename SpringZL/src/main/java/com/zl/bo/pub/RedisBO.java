package com.zl.bo.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
@Repository("redisBO")
public class RedisBO {
	@Autowired
	private StringRedisTemplate redisTemplate;
	
		
	public void setValue(String key,String value) {
		ValueOperations<String, String> val = redisTemplate.opsForValue();
		val.set(key, value);
	}
	public String getValue(String key) {
		ValueOperations<String, String> val = redisTemplate.opsForValue();

		return val.get(key);
	}
}
