package view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.TrangChuController;
import dao.DanhGiaNVDao;

public class QuanLyHomeView extends JFrame {
	private static QuanLyHomeView trangChuViewInstance = null;
	
	private JPanel contentPane;
	private ActionListener actionListener;
	public JButton btnQuanLyNhanVien, btnDanhGiaNV, btnTK;
	private JLabel lblXinCho;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyHomeView frame = new QuanLyHomeView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static QuanLyHomeView getInstance() {
		if (trangChuViewInstance == null) {
			trangChuViewInstance = new QuanLyHomeView();
		}
		
		return trangChuViewInstance; 
	}

	/**
	 * Create the frame.
	 */
	private QuanLyHomeView() {
		setTitle("Quản Lý");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		
		actionListener = new TrangChuController(this);
		
		lblXinCho = new JLabel("Xin chào..!");
		lblXinCho.setHorizontalAlignment(SwingConstants.LEFT);
		lblXinCho.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblXinCho.setBounds(23, 10, 275, 50);
		contentPane.add(lblXinCho);
		
		JLabel lblNewLabel = new JLabel("Bạn đang đăng nhập với tư cách Quản Lý");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(24, 53, 425, 50);
		contentPane.add(lblNewLabel);
		
		btnQuanLyNhanVien = new JButton("Quản lý nhân viên");
		btnQuanLyNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnQuanLyNhanVien.setBackground(new Color(233, 250, 247));
		btnQuanLyNhanVien.setBorderPainted(false);
		btnQuanLyNhanVien.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnQuanLyNhanVien.setFocusPainted(false);
		btnQuanLyNhanVien.setContentAreaFilled(false);
		btnQuanLyNhanVien.setOpaque(true);
		btnQuanLyNhanVien.setMargin(new Insets(10, 10, 10, 10));
		btnQuanLyNhanVien.setBounds(159, 149, 250, 100);
		btnQuanLyNhanVien.addActionListener(actionListener);
		contentPane.add(btnQuanLyNhanVien);
		
		btnDanhGiaNV = new JButton("Đánh Giá NV");
		btnDanhGiaNV.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDanhGiaNV.setBackground(new Color(233, 250, 247));
		btnDanhGiaNV.setBorderPainted(false);
		btnDanhGiaNV.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnDanhGiaNV.setFocusPainted(false);
		btnDanhGiaNV.setContentAreaFilled(false);
		btnDanhGiaNV.setOpaque(true);
		btnDanhGiaNV.setMargin(new Insets(10, 10, 10, 10));
		btnDanhGiaNV.setBounds(159, 286, 250, 100);
		btnDanhGiaNV.addActionListener(actionListener);
		contentPane.add(btnDanhGiaNV);
		
		btnNewButton = new JButton("Đăng Xuất");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(462, 10, 101, 21);
		btnNewButton.addActionListener(actionListener);
		contentPane.add(btnNewButton);
		
		btnTK = new JButton("Quản lý tài khoản");
		btnTK.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnTK.setBackground(new Color(233, 250, 247));
		btnTK.setBorderPainted(false);
		btnTK.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnTK.setFocusPainted(false);
		btnTK.setContentAreaFilled(false);
		btnTK.setOpaque(true);
		btnTK.setMargin(new Insets(10, 10, 10, 10));
		btnTK.setBounds(159, 432, 250, 100);
		btnTK.addActionListener(actionListener);		
		contentPane.add(btnTK);
	}
}
