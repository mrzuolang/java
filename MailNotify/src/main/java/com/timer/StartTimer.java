package com.timer;

import java.util.Map;

import com.conf.Config;

public class StartTimer {
	public static void main(String[] args) {
		try {
			Map<String, String> topics = Config.read();
			for (Map.Entry<String, String> item : topics.entrySet()) {
				Thread th = new Thread(new Task(item.getKey(),item.getValue()));
				th.start();
				th.join();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
