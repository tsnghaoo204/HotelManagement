package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;

import model.TaiKhoan;

public class DangKiDao {
	
	public static void DangKi(String us, String pw, String role) {
		ArrayList<TaiKhoan> dstk = TaiKhoanDao.getInstance().SelectAll();
		try {
			Connection conn = JDBCUtil.getConnection();
			
			Statement st = conn.createStatement();
			String sql = "INSERT into TaiKhoan values ('" + us + "', '" + pw + "', '" + role + "');";
			
			int rs = st.executeUpdate(sql);
			JDBCUtil.closeConnection(conn);
			
			TaiKhoan t = new TaiKhoan(us,pw,role);
			dstk.add(t);
			
		} catch (SQLException e) {
			 if (e.getSQLState().equals("23000")) {
	             System.out.println("Error: Duplicate key value. The primary key 'hao' already exists.");
	         } else {
	             e.printStackTrace();
	         }
		}
	}
}
