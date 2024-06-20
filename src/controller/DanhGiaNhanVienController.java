package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JFrame;

import dao.DanhGiaNVDao;
import model.DanhGiaNV;
import view.DanhGiaNhanVienView;
import view.QuanLyHomeView;

public class DanhGiaNhanVienController implements Action, MouseListener{
	public DanhGiaNhanVienView view;
	
	public DanhGiaNhanVienController(DanhGiaNhanVienView view) {
		super();
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		
		if(cm.equals("OK")) {
			System.out.println("Rate");
			int i = DanhGiaNVDao.getInstance().update(view.leak());
			view.HienThi();
		}
		
		if (cm.equals("Quay lại")) {
			System.out.println(" Ok ");
			JFrame frame = QuanLyHomeView.getInstance();
			frame.setVisible(true);
			this.view.dispose();
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
	@Override
	public void mouseClicked(MouseEvent e) {
		view.txtAdd();
		
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
		// TODO Auto-generated method stub
		
	}

}
