package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import dao.DanhGiaNVDao;
import view.DangKiView;
import view.DangNhapView;
import view.QuenMatKhauView;

public class DangNhapController implements Action {
	public DangNhapView view;
	public DangKiView vieww;
	public QuenMatKhauView viewww;
	
	public DangNhapController(DangNhapView view) {
		super();
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if(cm.equals("Đăng nhập")) {
			this.view.dangNhap();
		}
		else if(cm.equals("Đăng kí tại đây!")) {
			vieww = new DangKiView();
			vieww.setVisible(true);
			vieww.setLocationRelativeTo(null);
			view.dispose();
		}
		else if(cm.equals("Quên mật khẩu?")) {
			viewww = new QuenMatKhauView();
			viewww.setVisible(true);
			viewww.setLocationRelativeTo(null);
			view.dispose();
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
