package com.zl.rest.pub;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zl.bo.pub.RedisBO;
import com.zl.dao.pub.UserMapper;
import com.zl.util.UUIDS;
import com.zl.vo.pub.UserVO;
@Controller
public class LoginRest {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RedisBO redisBo;
	/**
	 * @param user_name 用户名
	 * @param password 密码
	 * @param code 验证码
	 * @return
	 */
	@RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request,HttpServletResponse response,
    		@RequestParam("bill_code")String bill_code,
    		@RequestParam("phone")String phone,@RequestParam("mail")String mail,
    		@RequestParam(value="password", required=true)String password,
    		@RequestParam(value="code", required=true)String code)
    {
		UserVO user = userMapper.find(bill_code, mail, phone);
		if(user==null) {
			//用户名 邮箱 或 手机号为空
		}
		if(!user.getPassword().equals(password)) {
			//密码错误
		}else {
			//登陆成功
			String uid = UUIDS.getID();
			redisBo.setValue(uid, user.toJson());
			Cookie cookie = new Cookie("token",uid);  
		    cookie.setMaxAge(60*60*24*7);//保留7天  
		    response.addCookie(cookie);  
	
		}
		
		
			
		
		//密码错误
		//连续错误3次，账号锁定
		//验证码错误
		
        return "hello";
    }
}
