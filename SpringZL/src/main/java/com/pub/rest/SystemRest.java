package com.pub.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pub.dao.UserMapper;
import com.pub.vo.UserVO;

@RestController
@RequestMapping("/system")
public class SystemRest {
	public UserMapper dao;

	@RequestMapping(value = "/version", method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "name", required = false) String name) {
		UserVO vo = new UserVO();
		vo.setUser_id("1");
		vo.setUser_name("zuolang");
		vo.setBill_code("10000");
		dao.insert(vo);
		return "version:0.1.1";
	}

	@RequestMapping(value = "/name", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody String json) {
		return "spring+mybatis+gradle";
	}
}
