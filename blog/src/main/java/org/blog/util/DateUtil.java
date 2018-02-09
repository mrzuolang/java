package org.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author lang
 *	
 */
public class DateUtil {
	//年月日时分秒格式化对象
	public static SimpleDateFormat datetime_format = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
	//年月日格式化对象
	public static SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-DD");
	
	
	/**
	 * @return 返回年月日 
	 * 2018-02-39
	 */
	public static String getDate() {
		return date_format.format(new Date());
	}
	
	/**
	 * @return 返回年月日时分秒
	 * 2018-02-39 23:23:56
	 */
	public static String getDateTime() {
		return datetime_format.format(new Date());
	}
	
	/**
	 * @return 返回日期格式化对象
	 */
	public static SimpleDateFormat getDateFormater() {
		return date_format;
	}
	
	/**
	 * @return 返回年月日时分秒格式化对象
	 */
	public static SimpleDateFormat getDateTimeFormater() {
		return datetime_format;
	}
	
	public static void main(String[] args) {
		System.out.println(getDate());
		System.out.println(getDateTime());
	}
}
