import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.mongo.InsertThread;
import com.mongo.MongoDBJDBC;

public class ThreadPoolMain {
	public static int total =10000;
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(16);
		// 1k 每交提交 1MB
		while ( total> 0) {
			if (InsertThread.b.get() < 32) {
				InsertThread.b.addAndGet(1);
				total--;
//				InsertThread it1 = new InsertThread(MongoDBJDBC.getClient(), "db1", "tb1", 1024, 100);
//				es.execute(it1);
//				// 10k 每交提交 1MB
//				InsertThread it2 = new InsertThread(MongoDBJDBC.getClient(), "db2", "tb1", 1024 * 10, 100);
//				es.execute(it2);
				// 100k 每交提交 1MB
				InsertThread it3 = new InsertThread(MongoDBJDBC.getClient(), "db3", "tb1", 1024 * 100, 10);
				es.execute(it3);
//				// 1MB 每交提交 1MB
//				InsertThread it4 = new InsertThread(MongoDBJDBC.getClient(), "db4", "tb1", 1024 * 1024, 1);
//				es.execute(it4);
				System.out.println(total);
			}else{
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		es.shutdown();
	}
}
