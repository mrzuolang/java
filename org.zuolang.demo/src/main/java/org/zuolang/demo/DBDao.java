package org.zuolang.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBDao {
	public static final String insertSql = "insert into pk10_2018("
			+ "bill_code,plan_code,plan_content,num_one,open_time,result,nums,persen"
			+ ") values(?,?,?,?,?,?,?,?)";
	public static void insert (PK10VO vo) {
		Connection conn = ConnFactory.getConection();
		try {
			PreparedStatement ps = conn.prepareStatement(insertSql);
			ps.setString(1, vo.getBill_code());
			ps.setString(2, vo.getPlan_code());
			ps.setString(3, vo.getPlan_content());
			ps.setString(4, vo.getNum_one());
			ps.setDate(5, vo.getOpen_time());
			ps.setByte(6, vo.getResult());
			ps.setString(7, vo.getNums());
			ps.setInt(8, vo.getPersen());
			ps.addBatch();
			boolean is = ps.execute();
			if(is) {
				System.out.println("保存成功");
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
	}
	public static void insert (List<PK10VO> list) {
		Connection conn = ConnFactory.getConection();
		try {
			PreparedStatement ps = conn.prepareStatement(insertSql);
			for (PK10VO vo : list) {
				ps.setString(1, vo.getBill_code());
				ps.setString(2, vo.getPlan_code());
				ps.setString(3, vo.getPlan_content());
				ps.setString(4, vo.getNum_one());
				ps.setDate(5, vo.getOpen_time());
				ps.setByte(6, vo.getResult());
				ps.setString(7, vo.getNums());
				ps.setInt(8, vo.getPersen());
				ps.addBatch();
			}
			
			boolean is = ps.execute();
			if(is) {
				System.out.println("保存成功");
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
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0L;
	}
	public static void main(String[] args) {
		long max = getMax();
		System.out.println(max);
	}

}
