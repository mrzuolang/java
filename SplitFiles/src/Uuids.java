

public class Uuids {
	public static String uuid(){
		return java.util.UUID.randomUUID().toString();
	}
	public static void main(String[] args) {
		System.out.println(uuid().length());
	}
}