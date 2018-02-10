package org.code.bo;

import java.io.File;
import java.io.FileWriter;
import org.blog.util.DateUtil;
import org.code.tool.TableUtil;
import org.code.bo.TableBO;
import org.code.vo.TableVO;

public class MapperClassCreator {
	
	/**
	 * @param dbName 数据库
	 * @param tbName 表名称
	 * @param path 文件输出目录
	 * @param packageName 包名称
	 * @param daoPackageName dao 包名称
	 */
	public void createVOClass(String dbName, String tbName, String path, String packageName,String daoPackageName) {
		try {
			//类名、文件名
			String className = TableUtil.getMapperClassNameFromTableName(tbName);
			String code = this.daoClassCode(packageName, className,dbName,tbName,daoPackageName);
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
	 * @param daoClassName
	 * @param dbName
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public String daoClassCode(String packageName,String daoClassName,String dbName,String tableName,String daoPackageName) throws Exception {
		TableVO tableVO = TableBO.getTableVO(dbName, tableName);
		StringBuffer code = new StringBuffer();
		// 包声明
		code.append("package " + packageName.replaceAll("/", ".") + ";").append(TableUtil.lineEnd);
		code.append(TableUtil.lineEnd);
		// 包引入
		code.append("import org.apache.ibatis.annotations.Mapper;").append(TableUtil.lineEnd);
		code.append("import org.apache.ibatis.annotations.Param;").append(TableUtil.lineEnd);
		// VO引入
		String voClassName = TableUtil.getVOClassNameFromTableName(tableName);
		code.append("import "+daoPackageName+"."+voClassName).append(TableUtil.lineEnd);
		code.append(TableUtil.lineEnd);
		// 类注释
		code.append("/**").append(TableUtil.lineEnd);
		code.append(" * @作者 lang").append(TableUtil.lineEnd);
		code.append(" * 生成于：" + DateUtil.getDateTime()).append(TableUtil.lineEnd);
		code.append(" * "+tableVO.getTable_comment()).append(TableUtil.lineEnd);
		code.append(" */ ").append(TableUtil.lineEnd);
		// 类定义
		code.append("public interface " + daoClassName + " implements Serializable{").append(TableUtil.lineEnd);
		//code.append("    private static final long serialVersionUID = 1L;").append(TableUtil.lineEnd);
		code.append(TableUtil.lineEnd);

		// 无参构造方法
		code.append(TableUtil.lineEnd);
		code.append("    public " + daoClassName + "(){").append(TableUtil.lineEnd);
		code.append(TableUtil.lineEnd);
		code.append("    }").append(TableUtil.lineEnd);
		code.append(TableUtil.lineEnd);
		
		code.append("public "+voClassName+" getByPk(@Param(\"pk\") "+"int"+" pk);").append(TableUtil.lineEnd);
		code.append("public int insert(@Param(\"pk\") "+"int"+" pk);").append(TableUtil.lineEnd);
		code.append("public int update(@Param(\"pk\") "+"int"+" pk);").append(TableUtil.lineEnd);
		code.append("public int deleteByPk(@Param(\"pk\") "+"int"+" pk);").append(TableUtil.lineEnd);
		// 类结束方法
		code.append("}");

		return code.toString();
	}
}
