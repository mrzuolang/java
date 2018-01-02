package com.zl.rest.pub;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zl.bo.pub.RedisBO;
import com.zl.dao.pub.UserMapper;

@Controller("/user")
public class UserRest {
	@Autowired
	public UserMapper userMapper;
	@Autowired
	public RedisBO redisBo;
	
	private Logger log = LogManager.getLogger(UserRest.class);

	/**
	 * @param user_name 用户名
	 * @param password 密码
	 * @param code 验证码
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletResponse response, 
		@RequestParam(value = "bill_code", required = true) String bill_code,
	 	@RequestParam(value = "password", required = true) String password, @RequestParam(value = "code", required = true) String code) {
		
		log.info("bill_code:"+bill_code);
		// 密码错误
		// 连续错误3次，账号锁定
		// 验证码错误

		return "hello";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest request, HttpServletResponse response, @RequestParam("bill_code") String bill_code, @RequestParam("phone") String phone,
			@RequestParam("mail") String mail, @RequestParam(value = "password", required = true) String password, @RequestParam(value = "code", required = true) String code) {

		return "hello";
	}
}
