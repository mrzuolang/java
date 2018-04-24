package org.blog.jobs.pk10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.blog.conf.ConnFactory;

public class DBDao {
	private static final Logger log = LogManager.getLogger();
	public static final String updateSql = "update pk10_2018 set n1=?,n2=?,n3=?,n4=?,n5=?,n6=?,n7=?,n8=?,n9=?,n10=?,"
			+ "result=?,nums=? "
			+ " where bill_code=?";
	public static void update(PK10VO vo) {
		Connection conn = ConnFactory.getConection();
		try {
			PreparedStatement ps = conn.prepareStatement(updateSql);
			String nums = vo.getN1()+","+vo.getN2()+","+vo.getN3()+","+vo.getN4()+","+vo.getN5()+","+vo.getN6()+","+vo.getN7()+","+vo.getN8()+","+vo.getN9()+","+vo.getN10();
			ps.setString(1, vo.getN1());
			ps.setString(2, vo.getN2());
			ps.setString(3, vo.getN3());
			ps.setString(4, vo.getN4());
			ps.setString(5, vo.getN5());
			ps.setString(6, vo.getN6());
			ps.setString(7, vo.getN7());
			ps.setString(8, vo.getN8());
			ps.setString(9, vo.getN9());
			ps.setString(10, vo.getN10());
			ps.setString(11, vo.getResult());
			ps.setString(12, nums);
			ps.setString(13, vo.getBill_code());
			boolean is = ps.execute();
			log.info(is?"保存成功":"保存失败");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
	}
	public static PK10VO getVOByPk(String bill_code) {
		Connection conn = ConnFactory.getConection();
		PK10VO vo=null;
		try {
			
			PreparedStatement ps = conn.prepareStatement("select bill_code,plan_code,plan_content from pk10_2018 where bill_code=?");
			ps.setString(1, bill_code);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo = new PK10VO();
				vo.setBill_code(bill_code);
				vo.setPlan_code(rs.getString("plan_code"));
				vo.setPlan_content(rs.getString("plan_content"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		return vo;
	}
	public static void insert (PK10VO vo) {
		Connection conn = ConnFactory.getConection();
		try {
			String insertSql = "insert into pk10_2018(bill_code,plan_code,plan_content) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(insertSql);
			ps.setString(1, vo.getBill_code());
			ps.setString(2, vo.getPlan_code());
			ps.setString(3, vo.getPlan_content());
			ps.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
