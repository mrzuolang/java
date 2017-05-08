import com.kafka.consumer.TheConsumer;

public class TestConsumer {
	public static void main(String[] args) {

		try {
			new TheConsumer().pull("jxqd_error");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
