package org.blog.util;

public class StringUtil {
	/** 判断字符串是否为空
	 * @param str ""返回true null返回true 其他为false 
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null){
			return true;
		}else if(str.trim().length()<1){
			return true;
		}else{
			return false;
		}
	}
}
