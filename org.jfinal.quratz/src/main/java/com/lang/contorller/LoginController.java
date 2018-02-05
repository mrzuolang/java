package com.lang.contorller;

import com.jfinal.core.Controller;
import com.lang.vo.UserVO;

public class LoginController extends Controller {

	public void validate() {
		
		//UserVO userVO = getModel(UserVO.class);
		String user_code = getPara("user_code");
		String pass_word = getPara("pass_word");
		UserVO user = new UserVO();
		user.user_code = user_code;
		user.pass_word = pass_word;
		System.out.println("user_code:"+user_code);
		System.out.println("pass_word:"+pass_word);
		//renderJson(JSONObject.toJSON(user));
		renderJson(user);
	}
}
