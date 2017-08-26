package com.zl.vo.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zl.bo.pub.RedisBO;
import com.zl.vo.common.CommonVO;

@Service
public class ClientEnv extends CommonVO{
	@Autowired
	private RedisBO redisBo;
	
	public UserVO getCurrentUserVO(String token) {
		String json = redisBo.getValue(token);
		return JSONObject.toJavaObject(JSON.parseObject(json), UserVO.class);
	}
}
