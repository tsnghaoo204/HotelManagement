package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;


import model.TaiKhoan;

public class TaiKhoanDao {
	public static TaiKhoanDao getInstance() {
		return new TaiKhoanDao();
	}
	public ArrayList<TaiKhoan> SelectAll() {
		ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
		try {
			Connection conn = JDBCUtil.getConnection();
			
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM TaiKhoan";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				TaiKhoan taiKhoan = new TaiKhoan(rs.getString("TenTK").trim(), rs.getString("MatKhau").trim(),rs.getString("VaiTro").trim());
				dstk.add(taiKhoan);
			}
			JDBCUtil.closeConnection(conn);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dstk;
	}
	
	public boolean update(String us, String pw, String role) {
		int ketQua = 0;
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();
			
			//Bước 2: tạo đối tượng statement
			Statement st = conn.createStatement();
			
			//Bước 3: thực thi câu lệnh sql
			String sql = "UPDATE TaiKhoan SET MatKhau = '" + pw + "' WHERE TenTK = '" + us +"' and VaiTro = '" + role + "'";
			
			 ketQua = st.executeUpdate(sql);
			
			// Bước 4: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}
}
