package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JFrame;

import view.DangKiView;
import view.DangNhapView;

public class DangKiController implements Action {
	public DangKiView dkview;
	
	public DangKiController(DangKiView dkview) {
		super();
		this.dkview = dkview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if(cm.equals("Đăng Kí")) {
			this.dkview.DangKi();
		}
		
		if (cm.equals("Quay lại")) {
			System.out.println(" Ok ");
			JFrame frame = DangNhapView.getInstance();
			frame.setVisible(true);
			this.dkview.dispose();
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
