package com.log;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import com.kafka.consumer.TheConsumer;
import com.kafka.vo.KafkaMessage;

public class LogFile {

	private void writeFile(List<KafkaMessage> list, String fileName) throws Exception {
		File file = new File(fileName);
		if (!file.exists())
			file.createNewFile();
		FileOutputStream os = new FileOutputStream(file);
		for (KafkaMessage msg : list) {
			os.write(msg.value.getBytes());
		}
		os.flush();
		os.close();
	}

	public String createFile(String topic) throws Exception {
		TheConsumer consumer = new TheConsumer();
		List<KafkaMessage> list = consumer.pull(topic);
		String fileName = null;
		System.out.println("topic:"+topic+"记录数量:"+list==null?0:list.size());
		if (list.size() > 0) {
			KafkaMessage msg = list.get(0);
			fileName = topic + "_" + msg.value.substring(0, 16).replace("-", "") + ".log";
			fileName = fileName.replace(":", "").replace(" ", "");
			System.out.println(fileName);
			writeFile(list, fileName);
		}
		return fileName;
	}
	
}
