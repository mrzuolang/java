package org.job.util;


import org.job.vo.ClientEnv;

public class ThreadSession {
	public static final ThreadLocal<String> THREAD_SESSION = new ThreadLocal<>();
	
	
	public static ClientEnv getENV() {
		ClientEnv env = new ClientEnv();
		return env;
	}

}
