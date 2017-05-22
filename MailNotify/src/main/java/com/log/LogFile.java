package com.log;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import com.conf.Config;
import com.kafka.vo.KafkaMessage;

public class LogFile {

	public String createFile(String topic, List<KafkaMessage> list) throws Exception {
		File file = new File(topic);
		if (!file.exists())
			file.createNewFile();
		FileOutputStream os = new FileOutputStream(file);
		StringBuilder content = new StringBuilder();
		for (KafkaMessage msg : list) {
			boolean isgnore = false;
			// 判断是否忽略错误
			for (String s : Config.getIgnore()) {
				if (msg.value.contains(s)) {
					isgnore = true;
					break;
				}
			}
			// 判断是否有严重错误
			for (String s : Config.getImportand()) {
				if (msg.value.contains(s)) {
					content.append(s);
					break;
				}
			}
			if (!isgnore) {
				os.write(msg.value.getBytes());
			}
		}
		os.flush();
		os.close();
		return content.toString();
	}

}
