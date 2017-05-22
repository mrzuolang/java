package com.timer;

import java.util.List;

import com.kafka.consumer.TheConsumer;
import com.kafka.vo.KafkaMessage;
import com.log.FileZIP;
import com.log.LogFile;
import com.mail.send.MailSend;

public class Task implements Runnable {
	public String topic;
	public String mails;
	public String content;

	public Task(String topic, String mails) {
		super();
		this.topic = topic;
		this.mails = mails;

	}

	@Override
	public void run() {
		if (topic != null && mails != null) {
			LogFile logf = new LogFile();
			try {
				TheConsumer consumer = new TheConsumer();
				List<KafkaMessage> list = consumer.pull(topic);
				System.out.println("topic:" + topic + "记录数量:" + list == null ? 0 : list.size());
				if (list != null && list.size() > 0)
					content = logf.createFile(topic, list);
				System.out.println("日志文件：" + topic);
				String zipfileName = topic+ ".zip";
				System.out.println("zip文件名称：" + zipfileName);
				new FileZIP().zip(topic, zipfileName);
				System.out.println("开始发送邮件：" + zipfileName);
				MailSend.sendQQMail(topic, mails, "服务器错误日志:"+content, zipfileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
