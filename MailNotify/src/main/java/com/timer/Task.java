package com.timer;

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
				String fileName = logf.createFile(topic);
				System.out.println("日志文件：" + fileName);
				if (fileName != null) {
					String zipfileName = fileName.split("\\.")[0] + ".zip";
					System.out.println("文件名称：" + zipfileName);
					new FileZIP().zip(fileName, zipfileName);
					System.out.println("开始发送邮件：" + zipfileName);
					MailSend.sendQQMail(topic, mails, topic + "服务器错误日志", zipfileName);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
