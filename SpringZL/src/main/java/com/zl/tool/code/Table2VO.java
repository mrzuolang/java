package com.zl.tool.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zl.config.ConnectionFactory;
import com.zl.util.StringUtils;
import com.zl.vo.common.CommonVO;
import com.zl.vo.common.MyException;
import com.zl.vo.pub.ColumnVO;

public class Table2VO extends CommonVO{
	public List<ColumnVO> findColumns(String db_name, String tb_name) throws SQLException {
		if (StringUtils.isEmpty(db_name)) {
			throw new MyException("生成VO的数据库名不能为空");
		}
		if (StringUtils.isEmpty(tb_name)) {
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
		System.out.println(sql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List<ColumnVO> list = new ArrayList<>();
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
		println(list.size());
		return list;
	}
}
