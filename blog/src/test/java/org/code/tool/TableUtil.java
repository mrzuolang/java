package org.code.tool;

import org.blog.util.StringUtil;
import org.blog.vo.MyException;

/**
 * 表信息转换成Java类文件
 * @author lang
 *
 */
public class TableUtil {
	static final String java_int = "int";
	static final String java_integer = "Integer";
	static final String java_string = "String";
	static final String java_double = "double";
	static final String java_Double = "Double";
	static final String java_byte = "byte";
	static final String java_Byte = "Byte";
	static final String java_date = "Date";
	static final String java_bigint = "BigInteger";
	/**
	 * 属性首字母转大写
	 * 
	 * @param pro
	 * @return
	 */
	public static String getProPertyName(String pro) {
		char[] chars = pro.toLowerCase().toCharArray();
		chars[0] = (char) (chars[0] - 32);
		return new String(chars);
	}
	
	/**
	 * 表数据类型转成Java类型
	 * @param sqlType
	 * @param colName
	 * @return
	 */
	public static String getJavaType(String sqlType, String colName) {
		if ("ts".equals(colName.toLowerCase())) {
			return java_string;
		} else if (colName.toLowerCase().contains("pk")) {
			return java_string;
		}
		sqlType = sqlType.toLowerCase();
		String res = "";
		switch (sqlType) {
		case "varchar":
			res = java_string;
			break;
		case "char":
			res = java_string;
			break;
		case "text":
			res = java_string;
			break;
		case "tinyint":
			res = java_byte;
			break;
		case "date":
			res = java_date;
			break;
		case "timestatmp":
			res = java_string;
			break;
		case "datetime":
			res = java_date;
			break;
		case "bigint":
			res = java_bigint;
			break;
		case "int":
			res = java_int;
			break;
		case "timestamp":
			res = "Date";
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
	 * @param tbName
	 * @return
	 */
	public static String getClassNameFromTableName(String tbName) {
		if (StringUtil.isEmpty(tbName)) {
			throw new MyException("表名不能为空");
		}
		StringBuffer res = new StringBuffer();
		tbName = tbName.toLowerCase();
		char[] names = tbName.toCharArray();
		int num = 0;
		boolean b = tbName.endsWith("b");
		for (char c : names) {
			if (c == '_') {
				num++;
			}
		}
		int firstIndex = tbName.indexOf('_') + 1;
		int lastIndex = tbName.lastIndexOf('_');
		int len = tbName.length();
		if (num == 0) {
			arrayToUpCase(names, 0);
			res.append(names);
			res.append("VO");
		} else if (num == 1) {
			arrayToUpCase(names, firstIndex);
			res.append(names, firstIndex, len - firstIndex);
			res.append("VO");
		} else if (num == 2 && b) {
			arrayToUpCase(names, firstIndex);
			res.append(names, firstIndex, lastIndex - firstIndex);
			res.append("BVO");
		} else if (num >= 2 && !b) {
			arrayToUpCase(names, firstIndex);
			res.append(names, firstIndex, len - firstIndex);
			res.append("VO");
		} else if (num > 2 && b) {
			arrayToUpCase(names, firstIndex);
			res.append(names, firstIndex, lastIndex - firstIndex);
			res.append("BVO");
		}
		return res.toString();
	}

	public static void arrayToUpCase(char[] arr, int post) {
		arr[post] = upcase(arr[post]);
	}

	public static char upcase(char c) {
		if (c >= 'a' && c <= 'z') {
			return (char) (c - 32);
		} else {
			return c;
		}
	}
}
