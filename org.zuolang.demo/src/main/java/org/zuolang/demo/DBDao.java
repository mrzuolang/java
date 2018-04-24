package org.zuolang.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDao {
	public static final String insertSql = "insert into pk10_2018(bill_code,plan_code,plan_content) values(?,?,?)";
	public static final String updateSql = "update pk10_2018 set n1=?,n2=?,n3=?n4=?,n5=?,n6=?,n7=?,n8=?,n9=?,n10=?,"
			+ "result=?,nums=n1|','|n2,|','|n3,|','|n4,|','|n5,|','|n6,|','|n7,|','|n8,|','|n9,|','|n10,result=?"
			+ "where bill_code=?";
	public static void update(PK10VO vo) {
		Connection conn = ConnFactory.getConection();
		try {
			PreparedStatement ps = conn.prepareStatement(updateSql);
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
			ps.setByte(11, vo.getResult());
			ps.setString(12, vo.getBill_code());
			boolean is = ps.execute();
			if(is) {
				System.out.println("保存成功");
			}
			
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
			PreparedStatement ps = conn.prepareStatement(insertSql);
			ps.setString(1, vo.getBill_code());
			ps.setString(2, vo.getPlan_code());
			ps.setString(3, vo.getPlan_content());
			ps.addBatch();
			boolean is = ps.execute();
			if(is) {
				System.out.println("保存成功");
			}
			
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
	
	public static long getMax() {
		String sql = "select max(bill_code)bill_code from pk10_2018";
		Connection conn = ConnFactory.getConection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getLong("bill_code");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		return 0L;
	}
	public static void main(String[] args) {
		long max = getMax();
		System.out.println(max);
	}

}
