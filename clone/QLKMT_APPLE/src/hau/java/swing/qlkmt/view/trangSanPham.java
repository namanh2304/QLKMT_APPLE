/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hau.java.swing.qlkmt.view;

import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

import hau.java.swing.qlkmt.model.IMac;
import hau.java.swing.qlkmt.model.Laptop;
import hau.java.swing.qlkmt.model.MayTinh;
import hau.java.swing.qlkmt.dao.LaptopDao;
import hau.java.swing.qlkmt.dao.MayTinhDao;
import hau.java.swing.qlkmt.controller.TimKiemSP;
import hau.java.swing.qlkmt.dao.IMacDao;

/**
 *
 * @author ACER
 */
public class trangSanPham extends JInternalFrame {

	private DefaultTableModel tblModel;
	DecimalFormat formatter = new DecimalFormat("###,###,###");

	private JTable tblSanPham;
	private JTextField searchField;
	private TableModel DefaultTableModel;

	public trangSanPham() {
		//this.setLocale(null);
		this.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(1180, 650);
		this.initComponents();
		BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
		ui.setNorthPane(null);
		tblSanPham.setDefaultEditor(Object.class, null);
		initTable();
		loadDataToTable();
		changeTextSearch();
	}

	// tạo bảng
	public final void initTable() {
		tblModel = new DefaultTableModel();
		String[] headerTbl = new String[] { "Mã máy", "Tên máy", "Số lượng", "Đơn giá", "CPU", "RAM", "ROM",
				"Loại máy" };
		tblModel.setColumnIdentifiers(headerTbl);
		tblSanPham.setModel(tblModel);
		tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(5);
		tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(5);
		tblSanPham.getColumnModel().getColumn(5).setPreferredWidth(5);
		tblSanPham.getColumnModel().getColumn(6).setPreferredWidth(5);
	}

	public void loadDataToTable() {
		try {
			MayTinhDao mtdao = new MayTinhDao();
			ArrayList<MayTinh> armt = mtdao.selectAll();
			tblModel.setRowCount(0);
			for (MayTinh i : armt) {
				if (i.getTrangThai() == 1) {
					String loaiMay;
					if (LaptopDao.getInstance().isLaptop(i.getMaMay()) == true) {
						loaiMay = "Laptop";
					} else {
						loaiMay = "IMac";
					}
					tblModel.addRow(new Object[] { i.getMaMay(), i.getTenMay(), i.getSoLuong(),
							formatter.format(i.getGia()) + "đ", i.getTenCpu(), i.getRam(), i.getRom(), loaiMay });
				}
			}
		} catch (Exception e) {
		}
	}

	private void initComponents() {
		//JFrame productframe = new JFrame("Sản phẩm");
		
		Font fontBold = new Font("Arial", Font.BOLD, 14);

		// Khu vực trên
		JPanel topPanel = new JPanel(new BorderLayout(20, 20));
		// Tao panel chức năng
		JPanel function = new JPanel();
		function.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		function.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 1), "Chức năng",
				TitledBorder.LEFT, TitledBorder.TOP));

		JButton addButton = new JButton("Thêm");
//		addButton.setVerticalTextPosition(SwingConstants.BOTTOM);
//		addButton.setHorizontalTextPosition(SwingConstants.CENTER);
//		addButton.setPreferredSize(new Dimension(90, 60)); // Kích cỡ
		addButton.setBorderPainted(false);
		// addButton.setContentAreaFilled(false);
		addButton.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));

		JButton removeButton = new JButton("Xóa");
		removeButton.setBorderPainted(false);
		removeButton.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));
		JButton editButton = new JButton("Sửa");
		editButton.setBorderPainted(false);
		editButton.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));
		JButton viewButton = new JButton("Xem chi tiết");
		viewButton.setBorderPainted(false);
		viewButton.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));

		function.add(addButton);
		function.add(removeButton);
		function.add(editButton);
		function.add(viewButton);

		// Tạo panel tìm kiếm
		JPanel search = new JPanel();
		search.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 6));
		search.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Tìm kiếm",
				TitledBorder.LEFT, TitledBorder.TOP));
		search.setPreferredSize(new Dimension(700, 60)); // Kích cỡ

		String[] searchoptions = { "Tất cả", "Lựa chọn 1", "Lựa chọn 2" };
		JComboBox searchComboBox = new JComboBox<>(searchoptions);
		searchComboBox.setPreferredSize(new Dimension(180, 35));
		searchComboBox.setFont(fontBold);

		JTextField searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(300, 35));
		searchField.setFont(fontBold);

		JButton refreshButton = new JButton("Làm mới");
		// refreshButton.setBorderPainted(false);
		// refreshButton.setContentAreaFilled(false);

		search.add(searchComboBox);
		search.add(searchField);
		search.add(refreshButton);

		// Gắn các panel vào topPanel
		topPanel.add(function, BorderLayout.WEST);
		topPanel.add(search, BorderLayout.EAST);

		// Khu vực hiển thị chính
		JPanel content = new JPanel();
		content.setFont(fontBold);
		content.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		content.setPreferredSize(new Dimension(1168, 626));

		JTable tblSanPham = new JTable();
		// run 1 màn
//		tblSanPham.setModel(new DefaultTableModel (
//				new Object [] [] {
//					
//				},
//				new String [] {
//						
//				}
//		));
		//tblSanPham.setModel(DefaultTableModel);

		JScrollPane scrollPane = new JScrollPane(tblSanPham);

		scrollPane.setViewportView(tblSanPham);
		scrollPane.setPreferredSize(new Dimension(1168, 626));
		content.add(scrollPane, BorderLayout.CENTER);
		content.add(tblSanPham, BorderLayout.CENTER);
		tblSanPham.setBackground(Color.WHITE);

		
		getContentPane().add(topPanel, BorderLayout.NORTH);
		getContentPane().add(content, BorderLayout.SOUTH);
		
//		productframe.add(topPanel, BorderLayout.NORTH);
//		productframe.add(content, BorderLayout.SOUTH);
		
		
	}

	public ArrayList<MayTinh> searchOc(String luachon, String content) {
		ArrayList<MayTinh> result = new ArrayList<MayTinh>();
		TimKiemSP searchPr = new TimKiemSP();

		if (luachon == "Mã máy") {
			result = searchPr.searchMaMay(content);
		} else if (luachon == "Tên máy") {
			result = searchPr.searchTenMay(content);
		}
		return result;
	}

	public MayTinh getMayTinhSelect() {
		int i_row = tblSanPham.getSelectedRow();
		MayTinh mt = MayTinhDao.getIntance().selectById(tblModel.getValueAt(i_row, 0).toString());
		return mt;
	}

	public boolean checkLap() {
		if (LaptopDao.getInstance().isLaptop(getMayTinhSelect().getMaMay()) == true) {
			return true;
		} else {
			return false;
		}
	}

	public Laptop getDetailLaptop() {
		Laptop lt = LaptopDao.getInstance().selectById(getMayTinhSelect().getMaMay());
		return lt;
	}

	public boolean checkIMac() {
		if (IMacDao.getInstance().isIMac(getMayTinhSelect().getMaMay()) == true) {
			return true;
		} else {
			return false;
		}
	}

	public IMac getDetailIMac() {
		IMac im = IMacDao.getInstance().selectById(getMayTinhSelect().getMaMay());
		return im;
	}

	public void xoaMayTinhSelect() {
		DefaultTableModel table_prd = (DefaultTableModel) tblSanPham.getModel();
		int i_row = tblSanPham.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sản phẩm này?", "Xóa sản phẩm",
				JOptionPane.YES_NO_OPTION);

		if (luaChon == JOptionPane.YES_OPTION) {
			MayTinh remove = getMayTinhSelect();
			MayTinhDao.getIntance().deleteTrangThai(remove.getMaMay());
		}
		loadDataToTable();
	}

	public void loadDataTableSearch(ArrayList<MayTinh> result) {
		try {
			tblModel.setRowCount(0);
			for (MayTinh i : result) {
				String loaiMay;
				if (LaptopDao.getInstance().isLaptop(i.getMaMay()) == true) {
					loaiMay = "Laptop";
				} else {
					loaiMay = "IMac";
				}
				tblModel.addRow(new Object[] { i.getMaMay(), i.getTenMay(), i.getSoLuong(),
						formatter.format(i.getGia()) + "đ", i.getTenCpu(), i.getRam(), i.getRom(), loaiMay });

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void changeTextSearch() {
		searchField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if (searchField.getText() == null) {
					loadDataToTable();
				}

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

}
