package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestNum {
	// AAAABBBB AABBCC ABABAB ABBBCDDD AAABCCCD ABABCCDD ABABCCCD
	@Test
	public void test1() {
		// AAAABBBB
		String num = "13266668888";
		String pattern = "(\\d)\\1{3}";
//		// 创建 Pattern 对象1
		Pattern r = Pattern.compile(pattern);
//		// 现在创建 matcher 对象
//		System.out.println(num.matches(pattern));

		Matcher m = r.matcher(num);
		while (m.find()) {
			int start = m.start();
			int end = m.end();
			String group = m.group();
			System.out.println(num + "|" + start + "-" + end + "=" + group);
		}
	}

	@Test
	public void test2() {
		String num = "13266112233";
		String pattern = "(\\d)\\1{1}";
		boolean isMatch = Pattern.matches(pattern, num);
		System.out.println("子字符串? " + isMatch);
	}
}
