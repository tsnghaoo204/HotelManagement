package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.DanhGiaNhanVienController;
import controller.QuanLyNhanVienController;
import dao.DanhGiaNVDao;
import dao.NhanVienDao;
import model.DanhGiaNV;
import model.NhanVien;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class DanhGiaNhanVienView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JTable table;
	DefaultTableModel model;

	String[][] data;
	public ArrayList<DanhGiaNV> dsdgnv;
	/**
	 * Launch the application.
	 */
	
	
	String[] column = {"Mã NV","Tên NV","Đánh giá","Ghi chú"};
	private JLabel maNVLabel;
	private JLabel tenNVLabel;
	private JLabel lblnhGi;
	private JLabel lblGhiCh;
	private JTextField maNVField;
	private JTextField tenNVField;
	private JTextField gcField;
	private JButton btnNewButton;
	private JTextArea textArea;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DanhGiaNhanVienView frame = new DanhGiaNhanVienView();
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
	public DanhGiaNhanVienView() {
		setTitle("Đánh Giá Nhân Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1052, 641);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		Action action = new DanhGiaNhanVienController(this);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		MouseListener mouseListener = new DanhGiaNhanVienController(this);
		table.addMouseListener(mouseListener);
		table.setModel(model);
		table.setRowHeight(25);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(319, 80, 689, 421);
		contentPane.add(scrollPane);
		
		HienThi();
		
		lblNewLabel = new JLabel("BẢNG ĐÁNH GIÁ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(437, 22, 438, 48);
		contentPane.add(lblNewLabel);
		
		maNVLabel = new JLabel("Mã NV");
		maNVLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		maNVLabel.setBounds(33, 114, 68, 37);
		contentPane.add(maNVLabel);
		
		tenNVLabel = new JLabel("Tên NV");
		tenNVLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tenNVLabel.setBounds(33, 180, 68, 37);
		contentPane.add(tenNVLabel);
		
		lblnhGi = new JLabel("Đánh Giá");
		lblnhGi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblnhGi.setBounds(33, 265, 68, 37);
		contentPane.add(lblnhGi);
		
		lblGhiCh = new JLabel("Ghi Chú");
		lblGhiCh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGhiCh.setBounds(33, 378, 68, 37);
		contentPane.add(lblGhiCh);
		
		btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(122, 480, 85, 21);
		btnNewButton.addActionListener(action);
		contentPane.add(btnNewButton);
		
		maNVField = new JTextField();
		maNVField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		maNVField.setBounds(111, 119, 171, 29);
		contentPane.add(maNVField);
		maNVField.setColumns(10);
		
		tenNVField = new JTextField();
		tenNVField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tenNVField.setColumns(10);
		tenNVField.setBounds(111, 185, 171, 29);
		contentPane.add(tenNVField);
		
		gcField = new JTextField();
		gcField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		gcField.setColumns(10);
		gcField.setBounds(111, 386, 171, 29);
		contentPane.add(gcField);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textArea.setBorder(new LineBorder(new Color(192, 192, 192)));
		textArea.setBounds(111, 265, 171, 80);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		contentPane.add(textArea);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBounds(467, 532, 90, 35);
		btnQuayLai.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnQuayLai.setBackground(new Color(225, 232, 230));
		btnQuayLai.setBorderPainted(false);
		btnQuayLai.setFocusPainted(false);
		btnQuayLai.setContentAreaFilled(false);
		btnQuayLai.setOpaque(true);
		btnQuayLai.addActionListener(action);
		btnQuayLai.setMargin(new Insets(10, 10, 10, 10));
		contentPane.add(btnQuayLai);		
		
	}
	

	public void HienThi() {
		dsdgnv = DanhGiaNVDao.getInstance().SelectAll();
		int n = dsdgnv.size();
		data = new String[n][4];
		int index = 0;
		for(DanhGiaNV dgnv : dsdgnv) {
			data[index][0] = dgnv.getMaNV();
			data[index][1] = NhanVienDao.getInstance().SelectedByID(dgnv.getMaNV()).getTenNV();
			data[index][2] = dgnv.getDanhGia();
			data[index][3] = dgnv.getGhiChu();
			index++;
		}
		model.setDataVector(data, column);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		getContentPane().add(scrollPane);
	}
	
	public void txtAdd() {
		int r = table.getSelectedRow();
		String maNV = data[r][0];
		NhanVien nv = NhanVienDao.getInstance().SelectedByID(maNV);
		maNVField.setText(maNV);
		tenNVField.setText(nv.getTenNV());
		textArea.setText(data[r][2]);
		gcField.setText(data[r][3]);
	}

	public DanhGiaNV leak() {
		DanhGiaNV l =  new DanhGiaNV(textArea.getText(),gcField.getText(),maNVField.getText());
		return l;
	}
	
	public void suaDanhGia(DanhGiaNV dgnv) {
		int i = DanhGiaNVDao.getInstance().update(dgnv);
		JOptionPane.showMessageDialog(rootPane, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);	
		HienThi();
	}
	
}
