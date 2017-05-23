package com.conf;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.log.LogFile;

/**
 * @author zuolang 配置文件类型
 */
public class Config {
	public static Map<String, String> props = null;

	/**
	 * 取订阅主题的邮件
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> getTopicToMail() throws Exception {
		if (props != null) {
			return props;
		}
		Properties pros = new Properties();
		InputStream is = null;

		try {
			is = LogFile.class.getResourceAsStream("/topic_mail.properties");
			pros.load(is);
			String topics = pros.getProperty("topic");
			String[] topic = topics.split(",");
			props = new HashMap<String, String>();
			for (String t : topic) {
				String toStr = pros.getProperty(t);
				props.put(t, toStr);
			}
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return props;
	}

	/**
	 * @return 忽略关键异常
	 * @throws Exception
	 */
	public static List<String> getIgnore() throws Exception {
		Properties pros = new Properties();
		InputStream is = null;
		is = LogFile.class.getResourceAsStream("/topic_mail.properties");
		pros.load(is);
		String[] str = getTopicToMail().get("ignore").split(",");
		return Arrays.asList(str);
	}

	public static List<String> getImportand() throws Exception {
		Properties pros = new Properties();
		InputStream is = null;
		is = LogFile.class.getResourceAsStream("/topic_mail.properties");
		pros.load(is);
		String[] str = getTopicToMail().get("important").split(",");
		return Arrays.asList(str);
	}

	/**
	 * 是否清除日志，为了跳过发送邮件
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean getIsSend() throws Exception {
		Properties pros = new Properties();
		InputStream is = null;
		try {
			is = LogFile.class.getResourceAsStream("/topic_mail.properties");
			pros.load(is);
			System.out.println("清除开关：" + pros.getProperty("send"));
			return "yes".equals(pros.getProperty("send"));
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}
}
