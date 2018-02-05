package org.jfinal.config;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class BlogInterceptor implements Interceptor{


	@Override
	public void intercept(ActionInvocation inv) {
		inv.invoke();
	}

}
