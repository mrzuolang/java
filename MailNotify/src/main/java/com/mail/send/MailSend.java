package com.mail.send;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class MailSend {


	/**
	 * @param title 邮件主题
	 * @param toMail 接收邮件地址
	 * @param content 内容
	 * @param files 附件
	 * @return
	 */
	public static void sendQQMail(String title, String toMail, String content, String... files) {
		try {

			String smtpFromMail = "zuolang@e-teng.com.cn"; // 账号
			String pwd = "DAyvcb10010"; // 密码
			int port = 465; // 端口
			String host = "smtp.exmail.qq.com"; // 端口

			Properties props = new Properties();
			props.setProperty("mail.debug", "true");  
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.socketFactory.port", port);
	          
			Session session = Session.getDefaultInstance(props);
			session.setDebug(false);

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(smtpFromMail, "来自"+smtpFromMail+"提醒"));
			message.addRecipients(Message.RecipientType.TO,toMail);
			message.setSubject(title);
			message.addHeader("charset", "UTF-8");

			/* 添加正文内容 */
			Multipart multipart = new MimeMultipart();
			BodyPart contentPart = new MimeBodyPart();

			contentPart.setHeader("Content-Type", "text/html; charset=UTF-8");
			contentPart.setContent(content, "text/html;charset=UTF-8");
			multipart.addBodyPart(contentPart);

			/* 添加附件 */
			for (String file : files) {
				File usFile = new File(file);
				MimeBodyPart fileBody = new MimeBodyPart();
				DataSource source = new FileDataSource(file);
				fileBody.setDataHandler(new DataHandler(source));
				sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
				fileBody.setFileName("=?UTF-8?B?" + enc.encode(usFile.getName().getBytes()) + "?=");
				multipart.addBodyPart(fileBody);
			}

			message.setContent(multipart);
			message.setSentDate(new Date());
			message.saveChanges();
			Transport transport = session.getTransport("smtp");

			transport.connect(host, port, smtpFromMail, pwd);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			for (String file : files) {
				File zipFile = new File(file);
				if(zipFile.exists())zipFile.delete();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
