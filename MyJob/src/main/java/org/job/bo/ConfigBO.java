package org.job.bo;


import org.springframework.stereotype.Service;

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
