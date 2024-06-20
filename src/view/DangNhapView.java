package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.DangNhapController;
import controller.QuanLyNhanVienController;
import dao.DanhGiaNVDao;
import dao.TaiKhoanDao;
import model.TaiKhoan;
import security.MD5;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DangNhapView extends JFrame {
	private static DangNhapView dangnhapInstance = null;
	Action action = new DangNhapController(this);
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private ButtonGroup bt;
	private JRadioButton staffRadio;
	private JRadioButton managerRadio;
	private JLabel text;
	private JButton sUButton1;
	private JButton btnQunMtKhu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapView frame = new DangNhapView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static DangNhapView getInstance() {
		if (dangnhapInstance == null) {
			dangnhapInstance = new DangNhapView();
		}
		
		return dangnhapInstance; 
	}
	
	/**
	 * Create the frame.
	 */
	public DangNhapView() {
		setTitle("Đăng Nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		setBackground(Color.white);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("G11 HOTEL MANAGEMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(183, 86, 341, 40);
		contentPane.add(lblNewLabel);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBackground(new Color(233, 250, 247));
		txtTaiKhoan.setBounds(212, 290, 262, 35);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBackground(new Color(233, 250, 247));
		txtMatKhau.setBounds(212, 377, 262, 35);
		contentPane.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(action);
		btnDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnDangNhap.setBackground(new Color(225, 232, 230));
		btnDangNhap.setBorderPainted(false);
		btnDangNhap.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnDangNhap.setFocusPainted(false);
		btnDangNhap.setContentAreaFilled(false);
		btnDangNhap.setOpaque(true);
		btnDangNhap.setMargin(new Insets(10, 10, 10, 10));
		btnDangNhap.setBounds(287, 456, 100, 40);
		contentPane.add(btnDangNhap);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(212, 347, 100, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tài khoản");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(212, 260, 100, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel roleLabel = new JLabel("Bạn là..?");
		roleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		roleLabel.setBounds(212, 182, 45, 13);
		contentPane.add(roleLabel);
		
		staffRadio = new JRadioButton("Nhân Viên");
		staffRadio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		staffRadio.setBounds(371, 206, 103, 21);
		contentPane.add(staffRadio);
		
		managerRadio = new JRadioButton("Quản Lý");
		managerRadio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		managerRadio.setBounds(212, 206, 103, 21);
		contentPane.add(managerRadio);
		
		bt = new ButtonGroup();
		bt.add(staffRadio);
		bt.add(managerRadio);
		
		text = new JLabel("Chưa có tài khoản?");
		text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		text.setBounds(462, 22, 118, 13);
		contentPane.add(text);
		
		sUButton1 = new JButton("Đăng kí tại đây!");
		sUButton1.addActionListener(action);
		sUButton1.setBackground(new Color(220, 220, 220));
		sUButton1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sUButton1.setBounds(558, 18, 118, 21);
		sUButton1.setBorderPainted(false);
		contentPane.add(sUButton1);
		
		btnQunMtKhu = new JButton("Quên mật khẩu?");
		btnQunMtKhu.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnQunMtKhu.setBackground(new Color(220, 220, 220));
		btnQunMtKhu.setBounds(274, 520, 118, 21);
		btnQunMtKhu.setBorderPainted(false);
		btnQunMtKhu.addActionListener(action);
		contentPane.add(btnQunMtKhu);
	}

	public void dangNhap() {
		String role;
		boolean check = false;
		
		if(txtTaiKhoan.getText().isEmpty() || txtMatKhau.getText().isEmpty()) {
			JOptionPane.showMessageDialog(rootPane, "Bạn không được để trống tài khoản mật khẩu", "Thông báo" , JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		ArrayList<TaiKhoan> dstk = TaiKhoanDao.getInstance().SelectAll();
		
		if(managerRadio.isSelected()) {
			role = "manager";
			for(TaiKhoan tk : dstk) {
				System.out.println(MD5.encryptPassword(txtMatKhau.getPassword()));
				if(txtTaiKhoan.getText().compareTo(tk.getTenTK()) == 0 && MD5.encryptPassword(txtMatKhau.getPassword()).equals(tk.getMatKhau()) && role.compareTo(tk.getVaiTro()) == 0) {
					check = true;
				}
			}
			if(check) {
				JFrame frame = QuanLyHomeView.getInstance();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(rootPane, "Tài khoản và mật khẩu không đúng", "Thông báo" , JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (staffRadio.isSelected()) {
			role = "staff";
			for(TaiKhoan tk : dstk) {
				if(txtTaiKhoan.getText().compareTo(tk.getTenTK()) == 0 && MD5.encryptPassword(txtMatKhau.getPassword()).equals(tk.getMatKhau()) && role.compareTo(tk.getVaiTro()) == 0) {
					check = true;
				}
			}
			if(check) {
				JFrame frame = NhanVienHomeView.getInstance();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(rootPane, "Tài khoản và mật khẩu không đúng", "Thông báo" , JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn tư cách đăng nhập!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
