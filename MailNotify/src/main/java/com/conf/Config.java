package com.conf;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.log.LogFile;

public class Config {
	public static Map<String, String> read() throws Exception {
		Properties pros = new Properties();
		Map<String, String> toMail = null;
		InputStream is = null;
		try {
			is = LogFile.class.getResourceAsStream("/topic_mail.properties");
			pros.load(is);
			String topics = pros.getProperty("topic");
			String[] topic = topics.split(",");
			toMail = new HashMap<String, String>();
			for (String t : topic) {
				String toStr = pros.getProperty(t);
				toMail.put(t, toStr);
			}

		} finally {
			if (is != null) {
				is.close();
			}
		}
		return toMail;
	}
}
