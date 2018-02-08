package org.code.tools;

public class CodeProducer {
	public static void main(String[] args) throws Exception {
		String path="/Users/lang/Desktop/";
		String packageName = "org/blog/vo";
		new MakeClassBo().createClass("blog", "pub_permission", path, packageName);
	}
}
