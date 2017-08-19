package com.zl.rest.pub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginRest {
	/**
	 * @param user_name 用户名
	 * @param password 密码
	 * @param code 验证码
	 * @return
	 */
	@RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@RequestParam(value="user_name", required=true)String user_name,
    		@RequestParam(value="password", required=true)String password,
    		@RequestParam(value="code", required=true)String code)
    {
		//密码错误
		//连续错误3次，账号锁定
		//验证码错误
		
        return "hello";
    }
}
