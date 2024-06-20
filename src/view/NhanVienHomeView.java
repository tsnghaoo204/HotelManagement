package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.TrangChuController;
import javax.swing.JLabel;

public class NhanVienHomeView extends JFrame {
	private static NhanVienHomeView nhanVienHomeViewInstance = null;
	
	private JPanel contentPane;
	private ActionListener actionListener;

	public JButton btnQuanLyPhong, btnThongTinKhachHang, btnQuanLyHoaDon;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienHomeView frame = new NhanVienHomeView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static NhanVienHomeView getInstance() {
		if (nhanVienHomeViewInstance == null) {
			nhanVienHomeViewInstance = new NhanVienHomeView();
		}
		
		return nhanVienHomeViewInstance; 
	}
	
	/**
	 * Create the frame.
	 */
	public NhanVienHomeView() {
		setTitle("Nhân Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		actionListener = new TrangChuController(this);
		
		btnQuanLyHoaDon = new JButton("Hóa đơn");
		btnQuanLyHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnQuanLyHoaDon.setBackground(new Color(233, 250, 247));
		btnQuanLyHoaDon.setBorderPainted(false);
		btnQuanLyHoaDon.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnQuanLyHoaDon.setFocusPainted(false);
		btnQuanLyHoaDon.setContentAreaFilled(false);
		btnQuanLyHoaDon.setOpaque(true);
		btnQuanLyHoaDon.setMargin(new Insets(10, 10, 10, 10));
		btnQuanLyHoaDon.setBounds(201, 322, 250, 100);
		btnQuanLyHoaDon.addActionListener(actionListener);
		contentPane.add(btnQuanLyHoaDon);	
		
		btnThongTinKhachHang = new JButton("Thông tin khách hàng");
		btnThongTinKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnThongTinKhachHang.setBackground(new Color(233, 250, 247));
		btnThongTinKhachHang.setBorderPainted(false);
		btnThongTinKhachHang.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnThongTinKhachHang.setFocusPainted(false);
		btnThongTinKhachHang.setContentAreaFilled(false);
		btnThongTinKhachHang.setOpaque(true);
		btnThongTinKhachHang.setMargin(new Insets(10, 10, 10, 10));
		btnThongTinKhachHang.setBounds(201, 476, 250, 100);
		btnThongTinKhachHang.addActionListener(actionListener);
		contentPane.add(btnThongTinKhachHang);
		
		btnQuanLyPhong = new JButton("Kiểm tra phòng");
		btnQuanLyPhong.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnQuanLyPhong.setBackground(new Color(233, 250, 247));
		btnQuanLyPhong.setBorderPainted(false);
		btnQuanLyPhong.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnQuanLyPhong.setFocusPainted(false);
		btnQuanLyPhong.setContentAreaFilled(false);
		btnQuanLyPhong.setOpaque(true);
		btnQuanLyPhong.setMargin(new Insets(10, 10, 10, 10));
		btnQuanLyPhong.setBounds(201, 180, 250, 100);
		btnQuanLyPhong.addActionListener(actionListener);
		contentPane.add(btnQuanLyPhong);
		
		JLabel lblNewLabel = new JLabel("Bạn đang đăng nhập với tư cách Nhân Viên!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(24, 62, 394, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblXinCho = new JLabel("Xin chào..!");
		lblXinCho.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblXinCho.setBounds(24, 22, 374, 50);
		contentPane.add(lblXinCho);
		
		btnNewButton = new JButton("Đăng Xuất!");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(572, 10, 110, 21);
		btnNewButton.addActionListener(actionListener);
		contentPane.add(btnNewButton);
	}
}
