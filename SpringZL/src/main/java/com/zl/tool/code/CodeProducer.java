package com.zl.tool.code;

public class CodeProducer {
	public static void main(String[] args) throws Exception {
		String path="/home/zuo/git/java/SpringZL/src/main/java/";
		String packageName = "com/zl/vo/pub";
		new MakeClassBo().createClass("blog", "pub_user", path, packageName);
	}
}
