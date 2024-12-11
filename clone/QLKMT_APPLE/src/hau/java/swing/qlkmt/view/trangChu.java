
package hau.java.swing.qlkmt.view;

import java.awt.*;
import javax.swing.*;
//import com.formdev.flatlaf.FlatLightLaf;

public class trangChu extends JFrame {
	private JPanel centerPanel;
	
	public trangChu() throws UnsupportedLookAndFeelException {
		this.init();
		this.setTitle("Trang chủ");
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		// UIManager.setLookAndFeel(new FlatLightLaf());
		UIManager.put("Table.showVerticalLines", true);
		UIManager.put("Table.showHorizontalLines", true);

		trangSanPham sp = new trangSanPham();
		
		centerPanel.add(sp).setVisible(true);

	}

	public void init() {
		JPanel mainpanel = new JPanel();
		// quy định về bố cục
		mainpanel.setLayout(new BorderLayout());
		// thêm một số nút nhấn
		// Tạo JPanel phụ để đặt các nút ở phía tây
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS)); // Xếp các nút theo chiều dọc
		// Thay đổi màu nền của westPanel
		westPanel.setBackground(new Color(102, 255, 255)); // Màu xanh lá
		westPanel.setPreferredSize(new Dimension(200, 0)); // 200px chiều rộng, chiều cao tự động
		westPanel.setLayout(new GridLayout(8, 1, 50, 40)); // 5 hàng, 1 cột, khoảng cách giữa các nút là 10px

		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(1000, 720));
		centerPanel.setBackground(Color.WHITE);

		JButton j_btn1 = new JButton("sản phẩm");
		JButton j_btn2 = new JButton("chi nhánh");
		JButton j_btn3 = new JButton("nhập hàng");
		JButton j_btn4 = new JButton("phiếu nhập");
		JButton j_btn5 = new JButton("xuất hàng");
		JButton j_btn6 = new JButton("phiếu xuất");
		JButton j_btn7 = new JButton("tồn kho");
		JButton j_btn8 = new JButton("thống kê");

		JLabel labelTieuDe = new JLabel("Quản lí kho máy tính");
		labelTieuDe.setFont(new Font("Arial", Font.BOLD, 30));
		labelTieuDe.setPreferredSize(new Dimension(0, 80)); // Chiều rộng tự động, chiều cao là 100px
		labelTieuDe.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa nội dung của labelTieuDe
		// Thay đổi màu nền cho JLabel
		labelTieuDe.setOpaque(true); // Đảm bảo màu nền hiển thị
		labelTieuDe.setBackground(new Color(102, 255, 255)); // Màu nền là Cyan

		// Chỉnh kích thước nút
		menuBtn(j_btn1);
		menuBtn(j_btn2);
		menuBtn(j_btn3);
		menuBtn(j_btn4);
		menuBtn(j_btn5);
		menuBtn(j_btn6);
		menuBtn(j_btn7);
		menuBtn(j_btn8);

		westPanel.add(j_btn1);
		westPanel.add(j_btn2);
		westPanel.add(j_btn3);
		westPanel.add(j_btn4);
		westPanel.add(j_btn5);
		westPanel.add(j_btn6);
		westPanel.add(j_btn7);
		westPanel.add(j_btn8);

		// Thêm JPanel phụ vào khu vực WEST của JPanel chính
		mainpanel.add(westPanel, BorderLayout.WEST);
		mainpanel.add(labelTieuDe, BorderLayout.NORTH);
		mainpanel.add(centerPanel, BorderLayout.CENTER);
		
		getContentPane().add(mainpanel);
		//this.add(mainpanel);
	}

	// Phương thức chỉnh kích thước và thêm padding cho JButton
	private void menuBtn(JButton button) {
		Font btnFont2 = new Font("Arial", Font.BOLD, 17); // Font chữ đậm, cỡ 17
		button.setFont(btnFont2);
		button.setPreferredSize(new Dimension(150, 80)); // Giới hạn bề ngang
		button.setMargin(new Insets(0, 5, 2, 5)); // Padding nhỏ hơn
		button.setBorder(BorderFactory.createLineBorder(new Color(102, 255, 255), 3));
		button.setFocusPainted(false); // Loại bỏ đường viền khi nhấn nút
		button.setContentAreaFilled(false); // Loại bỏ nền mặc định, làm cho viền rõ ràng hơn
	}
}
