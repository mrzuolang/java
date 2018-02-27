package org.code.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.blog.util.StringUtil;
import org.blog.vo.MyException;
import org.code.conf.ConnectionFactory;
import org.code.tool.TableUtil;
import org.code.vo.ColumnVO;
import org.code.vo.TableVO;


/**
 * MySQL表工具类
 * @author lang
 *
 */
public class TableBO{
	
	/**
	 * 查询MySQL表的字段与注释
	 * @param db_name
	 * @param tb_name
	 * @return
	 * @throws SQLException
	 */
	public static List<ColumnVO> findColumns(String db_name, String tb_name) {
		if (StringUtil.isEmpty(db_name)) {
			throw new MyException("生成VO的数据库名不能为空");
		}
		if (StringUtil.isEmpty(tb_name)) {
			throw new MyException("生成VO的表名不能为空");
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" t.COLUMN_COMMENT, ");
		sql.append(" t.COLUMN_DEFAULT,t.COLUMN_KEY, ");
		sql.append(" t.COLUMN_NAME,t.COLUMN_TYPE,t.DATA_TYPE, ");
		sql.append(" t.EXTRA, ");//t.GENERATION_EXPRESSION,
		sql.append(" t.IS_NULLABLE,");
		sql.append(" t.TABLE_NAME, ");
		sql.append(" t.TABLE_SCHEMA ");
		sql.append(" FROM information_schema.COLUMNS t ");
		sql.append(" WHERE ");
		sql.append(" t.TABLE_SCHEMA ='"+db_name+"'");
		sql.append(" AND t.TABLE_NAME =  '"+tb_name+"'");
		Connection conn = ConnectionFactory.getConection();
		List<ColumnVO> list = new ArrayList<>();
		try {
		System.out.println(sql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			ColumnVO vo = new ColumnVO();
			//String charmax = rs.getString("CHARACTER_MAXIMUM_LENGTH");
			//if(!StringUtils.isEmpty(charmax))
			//vo.setCharacter_maximum_length(new BigInteger(charmax));
			//String char_oct = rs.getString("CHARACTER_OCTET_LENGTH");
			//if(!StringUtils.isEmpty(char_oct))
			//vo.setCharacter_octet_length(new BigInteger(char_oct));
			//vo.setCharacter_set_name(rs.getString("CHARACTER_SET_NAME"));
			//vo.setCollation_name(rs.getString("COLLATION_NAME"));
			vo.setColumn_comment(rs.getString("COLUMN_COMMENT"));
			vo.setColumn_default(rs.getString("COLUMN_DEFAULT"));
			vo.setColumn_key(rs.getString("COLUMN_KEY"));
			vo.setColumn_name(rs.getString("COLUMN_NAME"));
			vo.setColumn_type(rs.getString("COLUMN_TYPE"));
			vo.setData_type(rs.getString("DATA_TYPE"));
			//String datePre = rs.getString("DATETIME_PRECISION");
			//if(!StringUtils.isEmpty(datePre))
			//vo.setDatetime_precision(new BigInteger(datePre));
			vo.setExtra(rs.getString("EXTRA"));
			//vo.setGenration_expression(rs.getString("GENERATION_EXPRESSION"));
			vo.setIs_nullable(rs.getString("IS_NULLABLE"));
			//String numeric = rs.getString("NUMERIC_PRECISION");
			//if(!StringUtils.isEmpty(numeric))
			//vo.setNumeric_precision(new BigInteger(numeric));
			//String numeric_scale = rs.getString("NUMERIC_SCALE");
			//if(!StringUtils.isEmpty(numeric_scale))
			//vo.setNueric_scale(new BigInteger(numeric_scale));
			//String ordinal = rs.getString("ORDINAL_POSITION");
			//if(!StringUtils.isEmpty(ordinal))
			//vo.setOrdinal_position(new BigInteger(ordinal));
			//vo.setPrivileges(rs.getString("PRIVILEGES"));
			vo.setTable_name(rs.getString("TABLE_NAME"));
			//vo.setTable_catalog(rs.getString("TABLE_CATALOG"));
			vo.setTable_schema(rs.getString("TABLE_SCHEMA"));
			list.add(vo);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * MySQL表信息：表注释
	 * @param dbName
	 * @param tableName
	 * @return
	 */
	public static TableVO getTableVO(String dbName,String tableName) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t.TABLE_COMMENT FROM information_schema.TABLES t where t.TABLE_NAME = ? AND t.TABLE_SCHEMA= ?");
		Connection conn = ConnectionFactory.getConection();
		TableVO table = new TableVO();
		try {
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, tableName);
			ps.setString(2, dbName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String comment = rs.getString("TABLE_COMMENT");
				table.setTable_comment(comment);
			}
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return table;
	}
	
	/**
	 * 根据数据库，表名，查询主键名称与主键数据类型
	 * @param dbName
	 * @param tableName
	 * @return
	 */
	public static Map<String,Map<String,String>> getTablePrimaryKey(String dbName,String tableName){
		Connection conn = ConnectionFactory.getConection();
		StringBuilder sql= new StringBuilder("select pks.table_schema,pks.table_name,pks.column_name,col.data_type from ");
		sql.append(" information_schema.key_column_usage pks ");
		sql.append(" join information_schema.columns col "); 
		sql.append(" on pks.table_schema=col.table_schema ");
		sql.append(" and pks.table_name = col.table_name ");
		sql.append(" and pks.column_name = col.column_name ");
		sql.append(" and pks.referenced_table_name is null ");
		sql.append(" where pks.table_schema= ? ");
		if(!StringUtil.isEmpty(tableName)) {
			sql.append(" and pks.table_name = ?");
		}
		sql.append(" and pks.constraint_name='PRIMARY' ");
		Map<String,Map<String,String>> res = new HashMap<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, dbName);
			if(!StringUtil.isEmpty(tableName)) {
				ps.setString(2, tableName);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tableName = rs.getString("table_name");
				String columnName = rs.getString("column_name");
				String dataType = rs.getString("data_type");
				dataType = TableUtil.getJavaType(dataType);
				if(res.containsKey(tableName)) {
					Map<String, String> pk_column = res.get(tableName);
					pk_column.put(columnName, dataType);
				}else {
					Map<String, String> pk_column = new HashMap<>();
					pk_column.put(columnName, dataType);
					res.put(tableName, pk_column);
				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		return res;
		
	}
	
	/**
	 * 判断表是否有主键
	 * @param dbName
	 * @param tableName
	 * @return
	 */
	public static boolean isHashPrimaryKey(String dbName,String tableName) {
		String sql="select * from INFORMATION_SCHEMA.TABLE_CONSTRAINTS t \n" + 
				"where t.table_schema=? and t.table_name= ? and t.constraint_type='PRIMARY KEY'";
		Connection conn = ConnectionFactory.getConection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, dbName);
			ps.setString(2, tableName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		
		return false;
	}
	
	/**
	 * 数据库连接关闭
	 * @param conn
	 */
	public static void close(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
