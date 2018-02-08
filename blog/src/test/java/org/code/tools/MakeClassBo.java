package org.code.tools;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.blog.util.DateUtil;
import org.blog.util.StringUtil;
import org.blog.vo.MyException;


public class MakeClassBo {
	final String lineEnd = System.getProperty("line.separator");
	final String java_int = "int";
	final String java_integer = "Integer";
	final String java_string = "String";
	final String java_double = "double";
	final String java_Double = "Double";
	final String java_byte = "byte";
	final String java_Byte = "Byte";
	final String java_date = "Date";
	final String java_bigint = "BigInteger";



	public void createClass(String dbName, String tbName, String path, String packageName) throws Exception {
		String className = this.getClassName(tbName);
		List<ColumnVO> list = new Table2VO().findColumns(dbName, tbName);
		String code = this.classStr(packageName, className, list);
		File dir = new File(path + packageName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String fileName = path + packageName + "/" + className + ".java";
		File javaFile = new File(fileName);
		if(!javaFile.exists()) {
			javaFile.createNewFile();
		}else {
			javaFile.delete();
		}
		FileWriter pw = new FileWriter(javaFile);
		println(code);
		pw.write(code);
		pw.flush();
		pw.close();
	}
	
	public void println(Object str) {
		System.out.println(str);
	}

	public String classStr(String packageName, String className, List<ColumnVO> list) {
		StringBuffer code = new StringBuffer();
		code.append("package " + packageName.replaceAll("/", ".") + ";").append(lineEnd);
		code.append(lineEnd);
		code.append("import java.util.Date;").append(lineEnd);
		code.append("import com.alibaba.fastjson.JSONObject;").append(lineEnd);
		code.append("import java.io.Serializable;").append(lineEnd);
		code.append(lineEnd);
		code.append("/**").append(lineEnd);
		code.append(" * @作者 lang").append(lineEnd);
		code.append(" * 生成于："+DateUtil.getDateTime()).append(lineEnd);
		code.append(" */ ").append(lineEnd);
		code.append("public class " + className +" implements Serializable{").append(lineEnd);
		code.append("    private static final long serialVersionUID = 1L;").append(lineEnd);
		// 成员方法
		for (ColumnVO vo : list) {
			String javaType = this.getJavaType(vo.getData_type(), vo.getColumn_name());
			code.append("    //" + vo.getColumn_comment()).append(lineEnd);
			code.append("    public " + javaType + " " + vo.getColumn_name().toLowerCase() + ";").append(lineEnd);
		}
		
		for (ColumnVO vo : list) {
			String javaType = this.getJavaType(vo.getData_type(), vo.getColumn_name());
			String proPertyName = this.getProPertyName(vo.getColumn_name());
			// 类的get方法
			code.append("    public " + javaType + " get" + proPertyName + "(){").append(lineEnd);
			code.append("        return " + vo.getColumn_name().toLowerCase()).append(";").append(lineEnd);
			code.append("    }").append(lineEnd);
			// 类的set方法
			code.append("    public void set" + proPertyName + "("+javaType+" "+proPertyName.toLowerCase()+"){").append(lineEnd);
			code.append("        this." + vo.getColumn_name().toLowerCase()+" ="+vo.getColumn_name().toLowerCase()).append(";").append(lineEnd);
			code.append("    }").append(lineEnd);
		}
		code.append("    public String toString(){").append(lineEnd);
		code.append("	 return JSONObject.toJSONString(this);").append(lineEnd);
		code.append("    }").append(lineEnd);
		code.append("}");

		return code.toString();
	}

	/**
	 * 属性首字母转大写
	 * 
	 * @param pro
	 * @return
	 */
	public String getProPertyName(String pro) {
		char[] chars = pro.toLowerCase().toCharArray();
		chars[0] = (char) (chars[0] - 32);
		return new String(chars);
	}

	public String getJavaType(String sqlType, String colName) {
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
			println(sqlType);
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
	public String getClassName(String tbName) {
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

	public void arrayToUpCase(char[] arr, int post) {
		arr[post] = upcase(arr[post]);
	}

	public char upcase(char c) {
		if (c >= 'a' && c <= 'z') {
			return (char) (c - 32);
		} else {
			return c;
		}
	}

}
