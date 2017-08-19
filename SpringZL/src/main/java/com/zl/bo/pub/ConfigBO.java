package com.zl.bo.pub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.pub.ConfigMapper;
import com.zl.vo.pub.ConfigVO;

@Service
public class ConfigBO {
//	@Autowired
//	private RedisBO redisBo;
//	
	public void refresh() {
//		List<ConfigVO> list = configDao.findAll();
//		for (ConfigVO configVO : list) {
//			redisBo.setValue(configVO.key, configVO.value);
//		}	
		System.out.println("hello");
	}
	
	
}
