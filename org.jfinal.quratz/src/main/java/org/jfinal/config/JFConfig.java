package org.jfinal.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.lang.contorller.HelloController;
import com.lang.contorller.LoginController;
import com.lang.vo.UserVO;

public class JFConfig extends JFinalConfig {
	public void configConstant(Constants me) {
		me.setDevMode(true);
	}

	public void configRoute(Routes me) {
		me.add("/api/hello", HelloController.class);
		me.add("/api/login", LoginController.class);
	}

	public void configPlugin(Plugins me) {
		RedisPlugin bbsRedis = new RedisPlugin("jfinal", "118.190.205.51"); 
		me.add(bbsRedis);
		//mysq
		C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://118.190.205.51/blog", "mysql", "1234");
		me.add(cp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp); me.add(arp);
		arp.addMapping("pub_user", UserVO.class);
		
	}

	public void configInterceptor(Interceptors me) {
		
	}

	public void configHandler(Handlers me) {
	}
}