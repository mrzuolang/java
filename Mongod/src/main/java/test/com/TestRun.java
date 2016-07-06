package test.com;

public class TestRun implements Runnable{
	private int time;
	private String name;
	
	public TestRun(String name) {
		super();
		this.name = name;
	}

	public void run() {
		System.out.println("¿ªÊ¼£º"+time);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("½áÊø£º"+time);
	}

}
