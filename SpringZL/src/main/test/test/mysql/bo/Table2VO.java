package test.mysql.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BussinessExcetopion;
import com.util.StringUtils;

import test.mysql.jdbc.ConnectionFactory;
import test.mysql.table.ColumnVO;

public class Table2VO {
	public void findColumns(String db_name, String tb_name) throws SQLException {
		if (StringUtils.isEmpty(db_name)) {
			throw new BussinessExcetopion("生成VO的数据库名不能为空");
		}
		if (StringUtils.isEmpty(tb_name)) {
			throw new BussinessExcetopion("生成VO的表名不能为空");
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select SELECT t.CHARACTER_MAXIMUM_LENGTH,t.CHARACTER_OCTET_LENGTH, ");
		sql.append(" t.CHARACTER_SET_NAME,t.COLLATION_NAME,t.COLUMN_COMMENT, ");
		sql.append(" t.COLUMN_DEFAULT,t.COLUMN_DEFAULT,t.COLUMN_KEY, ");
		sql.append(" t.COLUMN_NAME,t.COLUMN_TYPE,t.DATA_TYPE, ");
		sql.append(" t.DATETIME_PRECISION,t.EXTRA,t.GENERATION_EXPRESSION, ");
		sql.append(" t.IS_NULLABLE,t.NUMERIC_PRECISION,t.NUMERIC_SCALE, ");
		sql.append(" t.ORDINAL_POSITION,t.PRIVILEGES,t.TABLE_NAME, ");
		sql.append(" t.TABLE_CATALOG,t.TABLE_SCHEMA, ");
		sql.append(" FROM information_schema.COLUMNS t ");
		sql.append(" WHERE ");
		sql.append(" t.TABLE_NAME = ? ");
		sql.append(" AND t.TABLE_SCHEMA =? ");
		Connection conn = ConnectionFactory.getConection();
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ps.setString(0, db_name);
		ps.setString(1, tb_name);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ColumnVO vo = new ColumnVO();

		}

	}
}
