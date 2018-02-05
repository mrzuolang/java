package com.lang.contorller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;

public class HelloController extends Controller {
	public void index() {
		Cache bbs = Redis.use();
		bbs.set("hello", "JFinal");
		renderText("Hello JFinal World."+bbs.get("hello"));
	}
}
