

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.junit.Test;

public class KafkaProducerA {
	@Test
	public void send() {
		try {
			Properties props = new Properties();
			props.put("bootstrap.servers", "192.168.0.203:9092");
			props.put("acks", "1");
			props.put("retries", 0);
			props.put("batch.size", 1);
			props.put("linger.ms", 1);
			props.put("buffer.memory", 128);
			props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
			props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
			
			Producer<String, String> producer = new KafkaProducer<String, String>(props);
//			TopicPartition tp = new TopicPartition("test1", 1);
//			List<PartitionInfo> parts = producer.partitionsFor("test1");
//			for (PartitionInfo info : parts) {
//				System.out.println(info.partition()+"|"+info.topic()+"|"+info.leader().host());
//				Node[] nodes = info.replicas();
//				for (Node node : nodes) {
//					System.out.println(node.host()+":"+node.port());
//				}
//			}
//			
//			
			for (int i = 1000; i < 2000; i++) {
				ProducerRecord<String, String> record = new ProducerRecord<String, String>("test1",0,"key:"+i, "value:"+i);
				producer.send(record);
				System.out.println("send:hello"+"key:"+i+":"+"value:"+i+record.partition());
				producer.flush();

			}
			System.out.println("test");
			producer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
