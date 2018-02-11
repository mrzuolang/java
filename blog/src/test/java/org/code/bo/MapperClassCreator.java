package org.code.bo;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import org.blog.util.DateUtil;
import org.blog.vo.MyException;
import org.code.tool.TableUtil;
import org.code.bo.TableBO;
import org.code.vo.ColumnVO;
import org.code.vo.TableVO;

public class MapperClassCreator {
	
	final String lineEnd = System.getProperty("line.separator");

	/**
	 * @param dbName 数据库
	 * @param tableName 表名称
	 * @param path 文件路径
	 * @param packageName 包名称
	 * @throws Exception
	 */
	public void createMapperClass(String dbName, String tableName, String path, String packageName,String voPackageName) {
		try {
			// 类名、文件名 UserDao
			String className = TableUtil.getMapperClassNameFromTableName(tableName);
			String code = this.voClassCode(packageName, className, dbName, tableName,voPackageName);
			// 创建文件目录
			File dir = new File(path + packageName);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 创建Java文件
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
	 * 
	 * @param packageName
	 * @param className
	 * @param dbName
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public String voClassCode(String packageName, String className, String dbName, String tableName,String voPackageName) throws Exception {
		List<ColumnVO> list = TableBO.findColumns(dbName, tableName);
		TableVO tableVO = TableBO.getTableVO(dbName, tableName);
		StringBuffer code = new StringBuffer();
		String voClassName = TableUtil.getVOClassNameFromTableName(tableName);
		// 包声明
		code.append("package " + packageName.replaceAll("/", ".") + ";").append(lineEnd);
		code.append(lineEnd);
		// 包引入
		code.append("import org.apache.ibatis.annotations.Mapper;").append(lineEnd);
		code.append("import org.apache.ibatis.annotations.Param;").append(lineEnd);
		code.append("import org.apache.ibatis.annotations.Insert;").append(lineEnd);
		code.append("import org.apache.ibatis.annotations.Delete;").append(lineEnd);
		code.append("import org.apache.ibatis.annotations.Select;").append(lineEnd);
		code.append("import "+voPackageName.replace("/", ".")+"."+voClassName+";").append(lineEnd);
		code.append(lineEnd);
		// 类注释
		code.append("/**").append(lineEnd);
		code.append(" * @作者 lang").append(lineEnd);
		code.append(" * 生成于：" + DateUtil.getDateTime()).append(lineEnd);
		code.append(" * " + tableVO.getTable_comment()).append(lineEnd);
		code.append(" */ ").append(lineEnd);
		// dao接口类
		code.append("@Mapper").append(lineEnd);
		code.append("public interface " + className + "{").append(lineEnd);
		code.append(lineEnd);

		//insert方法
		
	
		if(TableBO.isHashPrimaryKey(dbName, tableName)) {
			Map<String, Map<String, String>> pks_map = TableBO.getTablePrimaryKey(dbName, tableName);
			Map<String, String> pks = pks_map.get(tableName);
			if(pks.size()==1) {
				for(String pk_col_name : pks.keySet()) {
					//delete方法根据主键删除
					code.append("    @Delete(\"delete from "+tableName+" where "+tableName+"."+pk_col_name+"=#{pk}\")").append(lineEnd);
					code.append("    public int deleteByPk(@Param(\"pk\")"+ pks.get(pk_col_name)+" pk);").append(lineEnd);
					code.append(lineEnd);
					
					//根据主键查询对象
					code.append("    @Select(\"select * from "+tableName+" where "+pk_col_name+" =#{pk}\")").append(lineEnd);
					code.append("    public "+voClassName+" findByPk(@Param(\"pk\")"+pks.get(pk_col_name)+" pk);").append(lineEnd);
					code.append(lineEnd);
					
					//insert 方法
					String preString="";
					String valueString="";
					String voObjectName = TableUtil.getClassObject(voClassName);
					for (int i=0;i<list.size();i++) {
						ColumnVO columnVO = list.get(i);
						preString+=columnVO.getColumn_name();
						valueString+="#{"+voObjectName+"."+columnVO.getColumn_name()+"}";
						if(i+1<list.size()) {
							preString+=",";
							valueString+=",";
						}
					}
					
					code.append("    @Insert(\"insert into "+tableName+" \\n\"+").append(lineEnd);
					code.append("        \"("+preString+")\\n\" +").append(lineEnd);
					code.append("        \" values \\n\" +").append(lineEnd);
					code.append("        \"("+valueString+")\")").append(lineEnd);
					code.append("    public int insert(@Param(\""+voObjectName+"\") "+voClassName+" "+voObjectName+ ");").append(lineEnd);
					code.append(lineEnd);
				}
			}else {
				new MyException("还未支持多列主键");
			}
			
		}
		
	
		// 类结束方法
		code.append("}");

		return code.toString();
	}
}
