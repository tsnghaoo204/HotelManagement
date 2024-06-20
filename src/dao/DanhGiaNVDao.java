package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.DanhGiaNV;
import model.NhanVien;


public class DanhGiaNVDao {
	public static DanhGiaNVDao getInstance() {
		return new DanhGiaNVDao();
	}
	
	public void addValues(int i) {
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();
			
			//Bước 2: tạo đối tượng statement
			Statement st = conn.createStatement();
			
			//Bước 3: thực thi câu lệnh sql
			String sql = "DELETE FROM DanhGiaNV"
					+ "\nINSERT INTO DanhGiaNV (DanhGia, GhiChu, MaNV)\r\n"
					+ "SELECT  N'Trống', N'Lần "+i+"', MaNV\r\n"
					+ "FROM NhanVien;\r\n";
			
			int rs = st.executeUpdate(sql);
			
			// Bước 4: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int update(DanhGiaNV t) {
		int ketQua = 0;
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();
			
			//Bước 2: tạo đối tượng statement
			Statement st = conn.createStatement();
			
			//Bước 3: thực thi câu lệnh sql
			String sql = "UPDATE DanhGiaNV SET DanhGia = N'" + t.getDanhGia() + "', GhiChu = N'" + t.getGhiChu() 
				 + "' WHERE MaNV = '" + t.getMaNV()+"'";
			
			
			
			 ketQua = st.executeUpdate(sql);
			
			// Bước 4: Xử lý kết quả			
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + "dòng bị thay đổi!");
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;	
	}
	public ArrayList<DanhGiaNV> SelectAll() {
		ArrayList<DanhGiaNV> dsnv = new ArrayList<DanhGiaNV>();
		Connection conn = JDBCUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "Select * from DanhGiaNV";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				DanhGiaNV nv = new DanhGiaNV( rs.getString("MaNV").trim(), rs.getInt("MaDG"),rs.getString("DanhGia").trim(), rs.getString("GhiChu").trim());
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	
}
