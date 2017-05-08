package com.timer;

import com.log.FileZIP;
import com.log.LogFile;
import com.mail.send.MailSend;

public class Task implements Runnable {
	public String topic;
	public String mails;

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
				if (fileName != null) {
					String zipfileName = fileName.split("\\.")[0] + ".zip";
					new FileZIP().zip(fileName, zipfileName);
					MailSend.sendQQMail(topic, mails, topic + "服务器错误日志", zipfileName);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
