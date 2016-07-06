package com.str;

import org.apache.commons.lang3.RandomStringUtils;



public class StringFactory {	
	public static String uniqueStr(int len){
		return RandomStringUtils.randomAlphanumeric(len);
	}
	public static void main(String[] args) {
		System.out.println(16777216/1024/1024);
	}
}
