package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dao.KhachHangDao;
import model.KhachHang;
import view.DatPhongView;

public class DatPhongController implements ActionListener, MouseListener {
	private DatPhongView view;
	
	public DatPhongController(DatPhongView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		if(command.equals("Xác nhận")) {
			String tenKH = view.tfTenKH.getText();
			String ngaySinh = view.getReverseDate(view.tfNgaySinh.getText().trim());
			String gioiTinh = view.bgNamNu.getSelection() == view.rdbNam.getModel() ? "Nam" : "Nữ";
			System.out.println(gioiTinh);
			String CCCD = view.tfCCCD.getText().trim();
			String diaChi = view.tfDiaChi.getText().trim();
			String SDT = view.tfSDT.getText().trim();
			if (tenKH.equals("") || ngaySinh.equals("dd/mm/yyyy") || gioiTinh.equals("") || CCCD.equals("") || diaChi.equals("") || SDT.equals("")) {
				view.alertInput();
			}
			KhachHang khachHang = new KhachHang(1, tenKH, gioiTinh, CCCD, diaChi, SDT, ngaySinh);
			int res = KhachHangDao.getInstance().insertOrUpdate(khachHang);
			view.XacNhan(res);
			view.updatePhong(khachHang, res);
		} else if (command.equals("Hủy")) {
			view.dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		view.tfNgaySinh.setText("");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
