package test.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {
	public static void main(String[] args) {
		TestRun th = new TestRun("test");
		ExecutorService es = Executors.newFixedThreadPool(3);
		es.execute(th);
	}
}
