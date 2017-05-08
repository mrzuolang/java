

import java.io.IOException;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TheProducter extends Thread {
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			properties.load(TheProducter.class.getClassLoader().getResourceAsStream("producer.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		ProducerRecord<String, String> res = new ProducerRecord<String, String>("test", 0, "hello", "test");
		producer.send(res);
		producer.close();
	}
}