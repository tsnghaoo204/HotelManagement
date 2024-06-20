package view;

import java.awt.EventQueue;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.TaiKhoanController;
import dao.TaiKhoanDao;
import model.TaiKhoan;
import security.MD5;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class QuenMatKhauView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usField;
	private JPasswordField pwField;
	private JPasswordField rppwField;
	private JRadioButton rdbtnNewRadioButton, rdbtnQunL;

	Action action = new TaiKhoanController(this);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuenMatKhauView frame = new QuenMatKhauView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuenMatKhauView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel caption = new JLabel("Quên Mật Khẩu");
		caption.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		caption.setBounds(140, 33, 225, 32);
		contentPane.add(caption);
		
		JLabel lblNewLabel_1 = new JLabel("Vui lòng nhập đúng tên đăng nhập và tư cách!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(25, 75, 435, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel roleLabel = new JLabel("Vai trò");
		roleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		roleLabel.setBounds(58, 151, 115, 32);
		contentPane.add(roleLabel);
		
		JLabel usLabel = new JLabel("Tên đăng nhập");
		usLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		usLabel.setBounds(58, 193, 115, 32);
		contentPane.add(usLabel);
		
		JLabel pwLabel = new JLabel("Đổi mật khẩu");
		pwLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pwLabel.setBounds(58, 235, 115, 32);
		contentPane.add(pwLabel);
		
		JLabel rppwLabel = new JLabel("Nhập lại mật khẩu");
		rppwLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rppwLabel.setBounds(58, 278, 115, 32);
		contentPane.add(rppwLabel);
		
		rdbtnNewRadioButton = new JRadioButton("Nhân Viên");
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(281, 158, 77, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnQunL = new JRadioButton("Quản Lý");
		rdbtnQunL.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnQunL.setBounds(183, 158, 77, 21);
		contentPane.add(rdbtnQunL);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnQunL);
		
		usField = new JTextField();
		usField.setBounds(183, 197, 223, 27);
		contentPane.add(usField);
		usField.setColumns(10);
		
		pwField = new JPasswordField();
		pwField.setColumns(10);
		pwField.setBounds(183, 239, 223, 27);
		contentPane.add(pwField);
		
		rppwField = new JPasswordField();
		rppwField.setColumns(10);
		rppwField.setBounds(183, 278, 223, 27);
		contentPane.add(rppwField);
		
		JButton smButton = new JButton("OK");
		smButton.setBackground(new Color(211, 211, 211));
		smButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		smButton.setBounds(179, 359, 125, 32);
		smButton.addActionListener(action);
		contentPane.add(smButton);
		
		JButton btnQuayLi = new JButton("Quay lại");
		btnQuayLi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnQuayLi.setBackground(new Color(211, 211, 211));
		btnQuayLi.setBounds(5, 10, 104, 21);
		btnQuayLi.addActionListener(action);
		contentPane.add(btnQuayLi);
	}
	public void doiMK() {
		char[] pw = pwField.getPassword();
		char[] rppw = rppwField.getPassword();
		String role;
		if(usField.getText().isEmpty() || pw.length == 0 || rppw.length == 0) {
			JOptionPane.showMessageDialog(rootPane, "Vui lòng không để trống dữ liệu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(!Arrays.equals(pw, rppw)) {
			JOptionPane.showMessageDialog(rootPane, "Mật khẩu không khớp!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		String encryptedPassword = MD5.encryptPassword(pw);
		
		if(rdbtnNewRadioButton.isSelected()) {
			role =  "staff";
			if(TaiKhoanDao.getInstance().update(usField.getText(), encryptedPassword, role)) {
				JOptionPane.showMessageDialog(rootPane, "Cập nhật mật khẩu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng TÊN ĐĂNG NHẬP và VAI TRÒ!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(rdbtnQunL.isSelected()) {
			role =  "manager";
			if(TaiKhoanDao.getInstance().update(usField.getText(), encryptedPassword, role)) {
				JOptionPane.showMessageDialog(rootPane, "Cập nhật mật khẩu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng TÊN ĐĂNG NHẬP và VAI TRÒ!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn VAI TRÒ!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
