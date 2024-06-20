package controller;

import java.awt.event.*;

import view.NhanVienHomeView;
import view.HoaDonView;
import view.QuanLyHomeView;
public class HoaDonController implements ActionListener{

	
	private HoaDonView hoaDonView;
	
	public HoaDonController(HoaDonView qlhdv) {
		hoaDonView = qlhdv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String giaTri = e.getActionCommand();
		if(giaTri.equals("Lấy thông tin từ số phòng")) {
			hoaDonView.Xem(hoaDonView);
		}
		
		if(giaTri.equals("Thêm")) {
			hoaDonView.ThemHoaDon(hoaDonView);
		}
		
		if(giaTri.equals("Tìm kiếm")) {
			hoaDonView.TimKiem();
		}
		
		if(giaTri.equals("In hóa đơn")) {
			hoaDonView.InHoaDon(hoaDonView);
		}
		
		if(giaTri.equals("Quay lại")) {
			NhanVienHomeView.getInstance().setVisible(true);
			hoaDonView.dispose();
		}
	}
}
