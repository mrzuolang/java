package test.mysql.bo;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BussinessExcetopion;
import com.util.StringUtils;

import test.mysql.jdbc.ConnectionFactory;
import test.mysql.table.ColumnVO;
import test.mysql.table.CommonVO;

public class Table2VO extends CommonVO{
	public List<ColumnVO> findColumns(String db_name, String tb_name) throws SQLException {
		if (StringUtils.isEmpty(db_name)) {
			throw new BussinessExcetopion("生成VO的数据库名不能为空");
		}
		if (StringUtils.isEmpty(tb_name)) {
			throw new BussinessExcetopion("生成VO的表名不能为空");
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT t.CHARACTER_MAXIMUM_LENGTH,t.CHARACTER_OCTET_LENGTH, ");
		sql.append(" t.CHARACTER_SET_NAME,t.COLLATION_NAME,t.COLUMN_COMMENT, ");
		sql.append(" t.COLUMN_DEFAULT,t.COLUMN_KEY, ");
		sql.append(" t.COLUMN_NAME,t.COLUMN_TYPE,t.DATA_TYPE, ");
		sql.append(" t.DATETIME_PRECISION,t.EXTRA,t.GENERATION_EXPRESSION, ");
		sql.append(" t.IS_NULLABLE,t.NUMERIC_PRECISION,t.NUMERIC_SCALE, ");
		sql.append(" t.ORDINAL_POSITION,t.PRIVILEGES,t.TABLE_NAME, ");
		sql.append(" t.TABLE_CATALOG,t.TABLE_SCHEMA ");
		sql.append(" FROM information_schema.COLUMNS t ");
		sql.append(" WHERE ");
		sql.append(" t.TABLE_SCHEMA =?");
		sql.append(" AND t.TABLE_NAME = ? ");
		Connection conn = ConnectionFactory.getConection();
		System.out.println(sql.toString());
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ps.setString(1, db_name);
		ps.setString(2, tb_name);
		ResultSet rs = ps.executeQuery();
		List<ColumnVO> list = new ArrayList<>();
		while (rs.next()) {
			ColumnVO vo = new ColumnVO();
			String charmax = rs.getString("CHARACTER_MAXIMUM_LENGTH");
			if(!StringUtils.isEmpty(charmax))
			vo.setCharacter_maximum_length(new BigInteger(charmax));
			String char_oct = rs.getString("CHARACTER_OCTET_LENGTH");
			if(!StringUtils.isEmpty(char_oct))
			vo.setCharacter_octet_length(new BigInteger(char_oct));
			vo.setCharacter_set_name(rs.getString("CHARACTER_SET_NAME"));
			vo.setCollation_name(rs.getString("COLLATION_NAME"));
			vo.setColumn_comment(rs.getString("COLUMN_COMMENT"));
			vo.setColumn_default(rs.getString("COLUMN_DEFAULT"));
			vo.setColumn_key(rs.getString("COLUMN_KEY"));
			vo.setColumn_name(rs.getString("COLUMN_NAME"));
			vo.setColumn_type(rs.getString("COLUMN_TYPE"));
			vo.setData_type(rs.getString("DATA_TYPE"));
			String datePre = rs.getString("DATETIME_PRECISION");
			if(!StringUtils.isEmpty(datePre))
			vo.setDatetime_precision(new BigInteger(datePre));
			vo.setExtra(rs.getString("EXTRA"));
			vo.setGenration_expression(rs.getString("GENERATION_EXPRESSION"));
			vo.setIs_nullable(rs.getString("IS_NULLABLE"));
			String numeric = rs.getString("NUMERIC_PRECISION");
			if(!StringUtils.isEmpty(numeric))
			vo.setNumeric_precision(new BigInteger(numeric));
			String numeric_scale = rs.getString("NUMERIC_SCALE");
			if(!StringUtils.isEmpty(numeric_scale))
			vo.setNueric_scale(new BigInteger(numeric_scale));
			String ordinal = rs.getString("ORDINAL_POSITION");
			if(!StringUtils.isEmpty(ordinal))
			vo.setOrdinal_position(new BigInteger(ordinal));
			vo.setPrivileges(rs.getString("PRIVILEGES"));
			vo.setTable_name(rs.getString("TABLE_NAME"));
			vo.setTable_catalog(rs.getString("TABLE_CATALOG"));
			vo.setTable_schema(rs.getString("TABLE_SCHEMA"));
			list.add(vo);
		}
		println(list.size());
		return list;
	}
}
