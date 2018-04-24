package org.job.vo;

import org.job.bo.RedisBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Service
public class ClientEnv extends CommonVO{
	@Autowired
	private RedisBO redisBo;
	
	public UserVO getCurrentUserVO(String token) {
		String json = redisBo.getValue(token);
		return JSONObject.toJavaObject(JSON.parseObject(json), UserVO.class);
	}
}
