package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.TaiKhoanController;
import controller.TrangChuController;
import dao.TaiKhoanDao;
import model.TaiKhoan;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DanhSachTKView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	ArrayList<TaiKhoan> dstk;
	String data[][];
	
	ActionListener action = new TaiKhoanController(this);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DanhSachTKView frame = new DanhSachTKView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String[] collumName = {
			"Tên đăng nhập", "Mật khẩu", "Vai trò"
	};
	
	/**
	 * Create the frame.
	 */
	public DanhSachTKView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 619, 260);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table.setModel(model);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		HienThi();
		
		JButton rtButton = new JButton("Quay lại!");
		rtButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rtButton.setBackground(new Color(211, 211, 211));
		rtButton.setBounds(277, 280, 85, 21);
		rtButton.addActionListener(action);
		contentPane.add(rtButton);
	}
	
	public void HienThi() {
		dstk = TaiKhoanDao.getInstance().SelectAll();
		int n = dstk.size();
		data = new String[n][3];
		int index = 0;
		for(TaiKhoan tk : dstk) {
			data[index][0] = tk.getTenTK();
			data[index][1] = tk.getMatKhau();
			data[index][2] = ((tk.getVaiTro().equals("manager"))? true:false)? "Quản Lý":"Nhân Viên";
			index++;
		}
		model.setDataVector(data, collumName);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(170);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);	
	}
}
