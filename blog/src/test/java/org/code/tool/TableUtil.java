package org.code.tool;

import org.blog.util.StringUtil;
import org.blog.vo.MyException;

/**
 * 表信息转换成Java类文件
 * 
 * @author lang
 *
 */
public class TableUtil {
	public static final String LING_END = System.getProperty("line.separator");
	public static final String JAVA_INT = "int";
	public static final String JAVA_INTEGER = "Integer";
	public static final String JAVA_STRING = "String";
	public static final String JAVA_double = "double";
	public static final String JAVA_DOUBLE = "Double";
	public static final String JAVA_byte = "byte";
	public static final String JAVA_BYTE = "Byte";
	public static final String JAVA_DATE = "Date";
	public static final String JAVA_long = "long";
	public static final String JAVA_LONG = "LONG";

	/**
	 * 属性首字母转大写
	 * 
	 * @param pro
	 * @return
	 */
	public static String getProPertyName(String pro) {
		char[] chars = pro.toLowerCase().toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);
		return new String(chars);
	}

	/**
	 * 表数据类型转成Java类型
	 * 
	 * @param sqlType
	 * @param colName
	 * @return
	 */
	public static String getJavaType(String sqlType) {

		sqlType = sqlType.toLowerCase();
		String res = "";
		switch (sqlType) {
		case "varchar":
			res = JAVA_STRING;
			break;
		case "char":
			res = JAVA_STRING;
			break;
		case "text":
			res = JAVA_STRING;
			break;
		case "tinyint":
			res = JAVA_byte;
			break;
		case "date":
			res = JAVA_DATE;
			break;
		case "timestatmp":
			res = JAVA_STRING;
			break;
		case "datetime":
			res = JAVA_DATE;
			break;
		case "bigint":
			res = JAVA_long;
			break;
		case "int":
			res = JAVA_INT;
			break;
		case "timestamp":
			res = JAVA_DATE;
			break;
		default:
			System.out.println(sqlType);
			throw new MyException("代码数据类型未知！");
		}

		return res;
	}

	/**
	 * 根据表名生成类名 pub_user:UserVO pub_path_b:PathBVO
	 * 
	 * @param tableName
	 * @return
	 */
	public static String getVOClassNameFromTableName(String tableName) {
		if (StringUtil.isEmpty(tableName)) {
			throw new MyException("表名不能为空");
		}
		StringBuffer voClassName = new StringBuffer();
		tableName = tableName.toLowerCase();
		char[] names = tableName.toCharArray();
		int num = 0;
		boolean end_b = tableName.endsWith("b");
		for (int i = 0; i < names.length; i++) {
			char c = names[i];
			if (c == '_') {
				num++;
				names[i + 1] = Character.toUpperCase(names[i + 1]);
			}
		}
		int firstIndex = tableName.indexOf('_') + 1;
		int lastIndex = tableName.lastIndexOf('_');
		int len = tableName.length();
		if (num == 0) {
			arrayToUpCase(names, 0);
			voClassName.append(names);
			voClassName.append("VO");
		} else if (num == 1) {
			arrayToUpCase(names, firstIndex);
			voClassName.append(names, firstIndex, len - firstIndex);
			voClassName.append("VO");
		} else if (num == 2 && end_b) {
			arrayToUpCase(names, firstIndex);
			voClassName.append(names, firstIndex, lastIndex - firstIndex);
			voClassName.append("BVO");
		} else if (num >= 2 && !end_b) {
			arrayToUpCase(names, firstIndex);
			voClassName.append(names, firstIndex, len - firstIndex);
			voClassName.append("VO");
		} else if (num > 2 && end_b) {
			arrayToUpCase(names, firstIndex);
			voClassName.append(names, firstIndex, lastIndex - firstIndex);
			voClassName.append("BVO");
		}
		return voClassName.toString();
	}

	/**
	 * 表名生成Dao
	 * 
	 * @param tableName
	 * @return
	 */
	public static String getMapperClassNameFromTableName(String tableName) {
		if (StringUtil.isEmpty(tableName)) {
			throw new MyException("表名不能为空");
		}
		StringBuffer daoClassName = new StringBuffer();
		tableName = tableName.toLowerCase();
		char[] names = tableName.toCharArray();
		int num = 0;
		boolean b = tableName.endsWith("b");
		for (int i = 0; i < names.length; i++) {
			char c = names[i];
			if (c == '_') {
				num++;
				names[i + 1] = Character.toUpperCase(names[i + 1]);
			}
		}
		int firstIndex = tableName.indexOf('_') + 1;
		int lastIndex = tableName.lastIndexOf('_');
		int len = tableName.length();
		if (num == 0) {
			arrayToUpCase(names, 0);
			daoClassName.append(names);
			daoClassName.append("Dao");
		} else if (num == 1) {
			arrayToUpCase(names, firstIndex);
			daoClassName.append(names, firstIndex, len - firstIndex);
			daoClassName.append("Dao");
		} else if (num == 2 && b) {
			arrayToUpCase(names, firstIndex);
			daoClassName.append(names, firstIndex, lastIndex - firstIndex);
			daoClassName.append("BDao");
		} else if (num >= 2 && !b) {
			arrayToUpCase(names, firstIndex);
			daoClassName.append(names, firstIndex, len - firstIndex);
			daoClassName.append("Dao");
		} else if (num > 2 && b) {
			arrayToUpCase(names, firstIndex);
			daoClassName.append(names, firstIndex, lastIndex - firstIndex);
			daoClassName.append("BDao");
		}
		return daoClassName.toString();
	}
	
	/**
	 * 根据类名取类对象 UserVO ==> userVO
	 * @param className
	 * @return
	 */
	public static String getClassObject(String className) {
		char[] c = className.toCharArray();
		c[0]=Character.toLowerCase(c[0]);
		return new String(c);
	}
	/**
	 * 首字母变小
	 * @param arr
	 * @param post
	 */
	public static void arrayToLowCase(char[] arr, int post) {
		arr[post] = Character.toUpperCase(arr[post]);
	}
	
	/**
	 * 字符数据转大写
	 * 
	 * @param arr
	 * @param post
	 */
	public static void arrayToUpCase(char[] arr, int post) {
		arr[post] = Character.toUpperCase(arr[post]);
	}

}
