package com.timer;

import java.util.List;

import com.kafka.consumer.TheConsumer;
import com.kafka.vo.KafkaMessage;
import com.log.FileZIP;
import com.log.LogFile;
import com.mail.send.MailSend;

/**
 * @author zuolang
 * 多线程任务类
 *
 */
public class Task implements Runnable {
	public String topic;//消息主题
	public String mails;//订阅主题的邮件
	public String content;//邮件内容
	public String zipName;//压缩文件名称

	public Task(String topic, String mails) {
		super();
		this.topic = topic;
		this.mails = mails;
		zipName = topic+".zip";

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
				else{
					System.out.println(topic+"主题消息为空");
					return ;
				}
				
				boolean res = new FileZIP().zip(topic);
				if(res){
					System.out.println("开始发送邮件：.....");
					MailSend.sendQQMail(topic, mails, "服务器错误日志:"+content,zipName);
					System.out.println("发送完成");
				}else{
					System.out.println(topic+"主题消息为空");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
