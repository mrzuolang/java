package com.kafka.consumer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.kafka.vo.KafkaMessage;

/**
 * @author zuolang kafka消息消费者
 *
 */
public class TheConsumer {
	public List<KafkaMessage> pull(String topic) throws Exception{
		Properties pro = new Properties();
		InputStream is = TheConsumer.class.getResourceAsStream("/kafka.properties");
		pro.load(is);
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(pro);
		List<KafkaMessage> list = new ArrayList<>();
		consumer.subscribe(Arrays.asList(topic));
		ConsumerRecords<String, String> records = consumer.poll(3000);
		for (ConsumerRecord<String,String> record : records) {
			KafkaMessage msg= new KafkaMessage();
			msg.key=record.key();
			msg.value=record.value();
			msg.topic=record.topic();
			list.add(msg);
			System.out.println(msg.value);
		}
		consumer.close();
		return list;
	}

}
