package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.NhanVienHomeView;
import view.NhanVienView;
import view.DangNhapView;
import view.DanhGiaNhanVienView;
import view.DanhSachTKView;
import view.HoaDonView;
import view.QuanLyKhachHangView;
import view.QuanLyPhongView;
import view.QuanLyHomeView;

public class TrangChuController implements ActionListener {
	private QuanLyHomeView view;
	private NhanVienHomeView vieww;
	private DanhSachTKView viewww;

	public TrangChuController(QuanLyHomeView view) {
		super();
		this.view = view;
	}

	public TrangChuController(NhanVienHomeView nhanVienHomeView) {
		super();
		this.vieww = nhanVienHomeView;
	}
	
	public TrangChuController(DanhSachTKView danhSachTKView) {
		super();
		this.viewww = danhSachTKView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		if (command.equals("Kiểm tra phòng")) {
			openQuanLyPhong();
		} else if (command.equals("Quản lý nhân viên")) {
			openQuanLyNhanVien();
		} else if (command.equals("Thông tin khách hàng")) {
			openThongTinKhachHang();
		} else if (command.equals("Hóa đơn")) {
			openQuanLyHoaDon();
		} else if (command.equals("Đánh Giá NV")) {
			openDanhGiaNhanVien();
		} else if (command.equals("Đăng Xuất!")) {
			openDangNhap(vieww);
		} else if (command.equals("Đăng Xuất")) {
			openDangNhap(view);
		}
		else if(command.equals("Quản lý tài khoản")) {
			openQLTK();
		}
		
		
	}

	private void openThongTinKhachHang() {
		JFrame frame = new QuanLyKhachHangView();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		vieww.setVisible(false);
	}

	private void openQuanLyPhong() {
		QuanLyPhongView.refresh();
		QuanLyPhongView.getInstance().setVisible(true);
		QuanLyPhongView.getInstance().setLocationRelativeTo(null);
		vieww.setVisible(false);
	}

	private void openQuanLyHoaDon() {
		HoaDonView.refresh();
		HoaDonView.getInstance().setVisible(true);
		HoaDonView.getInstance().setLocationRelativeTo(null);
		vieww.setVisible(false);
	}

	private void openQuanLyNhanVien() {
		JFrame quanLyNhanVienView = new NhanVienView();
		quanLyNhanVienView.setVisible(true);
		quanLyNhanVienView.setLocationRelativeTo(null);
		view.setVisible(false);
	}
	
	private void openDanhGiaNhanVien() {
		JFrame danhGiaNhanVienView = new DanhGiaNhanVienView();
		danhGiaNhanVienView.setVisible(true);
		danhGiaNhanVienView.setLocationRelativeTo(null);
		view.setVisible(false);
	}
	private void openDangNhap(QuanLyHomeView view) {
		JFrame dangNhapView = new DangNhapView();
		dangNhapView.setVisible(true);
		dangNhapView.setLocationRelativeTo(null);
		view.setVisible(false);
	}
	private void openDangNhap(NhanVienHomeView vieww) {
		JFrame dangNhapView = new DangNhapView();
		dangNhapView.setVisible(true);
		dangNhapView.setLocationRelativeTo(null);
		vieww.setVisible(false);
	}
	private void openQLTK() {
		JFrame dSTK = new DanhSachTKView();
		dSTK.setVisible(true);
		dSTK.setLocationRelativeTo(null);
		view.setVisible(false);
	}
}
