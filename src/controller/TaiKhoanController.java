package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JFrame;

import view.DangNhapView;
import view.DanhSachTKView;
import view.QuanLyHomeView;
import view.QuenMatKhauView;

public class TaiKhoanController implements Action{
	public DangNhapView vieww;
	public QuenMatKhauView view;
	public DanhSachTKView v;
	
	public TaiKhoanController(QuenMatKhauView view) {
		super();
		this.view = view;
	}

	public TaiKhoanController(DanhSachTKView view) {
		super();
		this.v = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if(cm.equals("OK")) {
			this.view.doiMK();
		}
		else if(cm.equals("Quay lại")) {
			vieww = new DangNhapView();
			vieww.setVisible(true);
			vieww.setLocationRelativeTo(null);
			view.dispose();
		}
		else if(cm.equals("Quay lại!")) {
			JFrame frame = QuanLyHomeView.getInstance();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			v.dispose();
		}
		
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
