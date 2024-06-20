package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Action;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.DangKiController;
import dao.DangKiDao;
import security.MD5;

public class DangKiView extends JFrame {
	
	private DangKiDao dki;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	Action action = new DangKiController(this);
	private JTextField usField;
	private JPasswordField pwField;
	private JPasswordField rppwField;
	private JRadioButton staffButton;
	private JRadioButton mngButton;
	private ButtonGroup bg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKiView frame = new DangKiView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangKiView() {
		setTitle("Đăng Kí");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		
		JLabel captionLabel = new JLabel("Đăng Kí Tài Khoản");
		captionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		captionLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		captionLabel.setBounds(80, 57, 355, 68);
		contentPane.add(captionLabel);
		
		JLabel usLabel = new JLabel("Tài Khoản");
		usLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		usLabel.setBounds(60, 179, 115, 30);
		contentPane.add(usLabel);
		
		JLabel pwLabel = new JLabel("Nhập mật khẩu");
		pwLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pwLabel.setBounds(60, 234, 134, 30);
		contentPane.add(pwLabel);
		
		JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu");
		lblNhpLiMt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNhpLiMt.setBounds(60, 295, 147, 30);
		contentPane.add(lblNhpLiMt);
		
		JLabel roleLabel = new JLabel("Vai trò");
		roleLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		roleLabel.setBounds(60, 371, 115, 30);
		contentPane.add(roleLabel);
		
		usField = new JTextField();
		usField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		usField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		usField.setBackground(new Color(240, 255, 255));
		usField.setBounds(224, 181, 211, 30);
		contentPane.add(usField);
		usField.setColumns(10);
		
		pwField = new JPasswordField();
		pwField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pwField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		pwField.setBackground(new Color(240, 255, 255));
		pwField.setColumns(10);
		pwField.setBounds(224, 236, 211, 30);
		contentPane.add(pwField);
		
		rppwField = new JPasswordField();
		rppwField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rppwField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		rppwField.setBackground(new Color(240, 255, 255));
		rppwField.setColumns(10);
		rppwField.setBounds(224, 297, 211, 30);
		contentPane.add(rppwField);
		
		staffButton = new JRadioButton("Nhân Viên");
		staffButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		staffButton.setBounds(337, 376, 97, 21);
		contentPane.add(staffButton);
		
		mngButton = new JRadioButton("Quản Lý");
		mngButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		mngButton.setBounds(219, 376, 97, 21);
		contentPane.add(mngButton);
		
		bg = new ButtonGroup();
		bg.add(mngButton);
		bg.add(staffButton);
		
		JButton sUButton = new JButton("Đăng Kí");
		sUButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		sUButton.setBackground(new Color(240, 255, 240));
		sUButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sUButton.setBounds(187, 472, 118, 46);
		sUButton.addActionListener(action);
		contentPane.add(sUButton);
		
		JButton btnNewButton = new JButton("Quay lại");
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 10, 85, 21);
		btnNewButton.addActionListener(action);
		contentPane.add(btnNewButton);
	}
	
	public void DangKi() {
		String us = usField.getText();
		char[] pw = pwField.getPassword();
		char[] rppw = rppwField.getPassword();
		
		if(us.isEmpty() || pw.length == 0 || rppw.length == 0) {
			JOptionPane.showMessageDialog(rootPane, "Bạn không được để trống tài khoản mật khẩu", "Thông báo" , JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
        if (!Arrays.equals(pw, rppw)) {
            JOptionPane.showMessageDialog(rootPane, "Nhập lại mật khẩu không khớp!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Mật khẩu đã khớp!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        
        String encryptedPassword = MD5.encryptPassword(pw);
        
		String role;
		
		if(staffButton.isSelected()) {
			role = "staff";
			dki.DangKi(us, encryptedPassword, role);
			JOptionPane.showMessageDialog(rootPane, "Đăng kí tài khoản Nhân Viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			JFrame frame = DangNhapView.getInstance();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			this.dispose();
		}
		else if(mngButton.isSelected()) {
			role = "manager";
			dki.DangKi(us, encryptedPassword, role);
			JOptionPane.showMessageDialog(rootPane, "Đăng kí tài khoản Quản Lý thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			JFrame frame = DangNhapView.getInstance();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn vai trò của người đăng kí!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
