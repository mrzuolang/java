package com.new_api;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;

public class KafkaConsumerA {
	@Test
	public void kafkaConsumer() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.0.50:9092");
		props.put("group.id", "group1");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("auto.offset.reset", "earliest");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("test1"));

//		List<PartitionInfo> list = consumer.partitionsFor("test1");
//		for (PartitionInfo info : list) {
//			System.out.println(info.partition() + "|" + info.topic() + "|" + info.leader().host());
//			Node[] nodes = info.replicas();
//			for (Node node : nodes) {
//				System.out.println(node.host() + ":" + node.port());
//			}
//		}

		// TopicPartition tp = new TopicPartition("test1", 0);
		// consumer.position(tp);
		// List list =new ArrayList();
		// list.add(tp);
		// consumer.assign(list);
		// consumer.seek(tp, 0L);
//		
//		Map<String, List<PartitionInfo>> map = consumer.listTopics();
//		for ( List<PartitionInfo> list : map.values()) {
//			for (PartitionInfo info : list) {
//				System.out.println("topic:"+info.topic()+"\tpartion:"+info.partition()+"\tLeader:"+info.leader());
//			}
//		}
		
//		List<PartitionInfo> list2 = consumer.partitionsFor("test1");
//		for (PartitionInfo info : list2) {
//			System.out.println("topic:"+info.topic()+"\tpartion:"+info.partition()+"\tLeader:"+info.leader());
//		}
		
		//List<TopicPartition> lt = new ArrayList<TopicPartition>();
		//lt.add(new TopicPartition("test1", 0));
//		TopicPartition tp = new TopicPartition("test", 0);
//		consumer.seek(tp, 1231);
		
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(5);
			for (ConsumerRecord<String, String> record : records)
				System.out.printf("partinon=%s\t offset = %d\t, key = %s\t, value = %s\n", record.partition(), record.offset(), record.key(), record.value());
		}
	}
}
