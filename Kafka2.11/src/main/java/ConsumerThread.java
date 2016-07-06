import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

public class ConsumerThread implements Runnable {
	private KafkaStream kafkaStream;
	// 线程编号
	private int threadNumber;

	public ConsumerThread(KafkaStream kafkaStream, int threadNumber) {
		this.threadNumber = threadNumber;
		this.kafkaStream = kafkaStream;
	}

	public void run() {
		ConsumerIterator<byte[], byte[]> it = kafkaStream.iterator();
		StringBuffer sb = new StringBuffer();
		// 该循环会持续从Kafka读取数据，直到手工的将进程进行中断
		while (it.hasNext()) {
			MessageAndMetadata metaData = it.next();
			sb.append("Thread: " + threadNumber + " ");
			sb.append("Part: " + metaData.partition() + " ");
			sb.append("Key: " + metaData.key().toString() + " ");
			sb.append("Message: " + metaData.message().toString() + " ");
			sb.append("\n");
			System.out.println(sb.toString());
		}
		System.out.println("Shutting down Thread: " + threadNumber);
	}
}