package org.code.main;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.blog.util.DateUtil;
import org.blog.util.StringUtil;
import org.code.tool.TableUtil;
import org.code.vo.ColumnVO;
import org.code.bo.TableBO;
import org.code.vo.TableVO;

public class MapperCodeMain {
final String lineEnd = System.getProperty("line.separator");
	

	/**
	 * @param dbName
	 *            数据库
	 * @param tbName
	 *            表名称
	 * @param path
	 *            文件路径
	 * @param packageName
	 *            包名称
	 * @throws Exception
	 */
	public void createMapperClass(String dbName, String tbName, String path, String packageName) {
		try {
			//类名、文件名
			String className = TableUtil.getVOClassNameFromTableName(tbName);
			String code = this.voClassCode(packageName, className,dbName,tbName);
			//创建文件目录
			File dir = new File(path + packageName);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			//创建Java文件
			String fileName = path + packageName + "/" + className + ".java";
			File javaFile = new File(fileName);
			if (!javaFile.exists()) {
				javaFile.createNewFile();
			} else {
				javaFile.delete();
			}
			FileWriter pw = new FileWriter(javaFile);
			System.out.println(code);
			pw.write(code);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * java类的文件内容
	 * @param packageName
	 * @param className
	 * @param dbName
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public String voClassCode(String packageName,String className,String dbName,String tableName) throws Exception {
		List<ColumnVO> list = TableBO.findColumns(dbName, tableName);
		TableVO tableVO = TableBO.getTableVO(dbName, tableName);
		StringBuffer code = new StringBuffer();
		// 包声明
		code.append("package " + packageName.replaceAll("/", ".") + ";").append(lineEnd);
		code.append(lineEnd);
		// 包引入
		code.append("import java.util.Date;").append(lineEnd);
		code.append("import com.alibaba.fastjson.JSONObject;").append(lineEnd);
		code.append("import java.io.Serializable;").append(lineEnd);
		code.append(lineEnd);
		// 类注释
		code.append("/**").append(lineEnd);
		code.append(" * @作者 lang").append(lineEnd);
		code.append(" * 生成于：" + DateUtil.getDateTime()).append(lineEnd);
		code.append(" * "+tableVO.getTable_comment()).append(lineEnd);
		code.append(" */ ").append(lineEnd);
		// 类定义
		code.append("public class " + className + " implements Serializable{").append(lineEnd);
		code.append("    private static final long serialVersionUID = 1L;").append(lineEnd);
		code.append(lineEnd);

		// 类属性
		for (ColumnVO vo : list) {
			String javaType = TableUtil.getJavaType(vo.getData_type());
			if (StringUtil.isEmpty(vo.getColumn_comment())) {
				code.append(lineEnd);
			} else {
				code.append("    //" + vo.getColumn_comment()).append(lineEnd);
			}
			code.append("    public " + javaType + " " + vo.getColumn_name().toLowerCase() + ";").append(lineEnd);
		}
		// 无参构造方法
		code.append(lineEnd);
		code.append("    public " + className + "(){").append(lineEnd);
		code.append(lineEnd);
		code.append("    }").append(lineEnd);
		code.append(lineEnd);
		// 类Getter,Setter方法
		for (ColumnVO vo : list) {
			String javaType = TableUtil.getJavaType(vo.getData_type());
			String proPertyName = TableUtil.getProPertyName(vo.getColumn_name());
			// 类的get方法
			code.append("    public " + javaType + " get" + proPertyName + "(){").append(lineEnd);
			code.append("        return " + vo.getColumn_name().toLowerCase()).append(";").append(lineEnd);
			code.append("    }").append(lineEnd);
			// 类的set方法
			code.append("    public void set" + proPertyName + "(" + javaType + " " + proPertyName.toLowerCase() + "){")
					.append(lineEnd);
			code.append("        this." + vo.getColumn_name().toLowerCase() + " =" + vo.getColumn_name().toLowerCase())
					.append(";").append(lineEnd);
			code.append("    }").append(lineEnd);
		}

		// toString()方法
		code.append("    public String toString(){").append(lineEnd);
		code.append("	 return JSONObject.toJSONString(this);").append(lineEnd);
		code.append("    }").append(lineEnd);

		// 类结束方法
		code.append("}");

		return code.toString();
	}
}
