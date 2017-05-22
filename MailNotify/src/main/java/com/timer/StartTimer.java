package com.timer;

import java.util.Map;

import com.conf.Config;
import com.kafka.consumer.TheConsumer;

public class StartTimer {
	public static void main(String[] args) {
		try {
			if(Config.getIsSend()){
				System.out.println("开始取日志");
				Map<String, String> topics = Config.getTopicToMail();
				System.out.println("topic:"+topics.size());
				for (Map.Entry<String, String> item : topics.entrySet()) {
					Thread th = new Thread(new Task(item.getKey(),item.getValue()));
					th.start();
					th.join();
				}
			}else{
				System.out.println("清除历史日志");
				Map<String, String> topics = Config.getTopicToMail();
				for (Map.Entry<String, String> item : topics.entrySet()) {
					TheConsumer consumer = new TheConsumer();
					consumer.pull(item.getKey());
				}
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
