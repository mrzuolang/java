package org.job.tool.code;

public class CodeProducer {
	public static void main(String[] args) throws Exception {
		String path="/Users/lang/git/JFinal-Web/src/main/java/";
		String packageName = "com/lang/vo";
		new MakeClassBo().createClass("blog", "pub_user", path, packageName);
	}
}
