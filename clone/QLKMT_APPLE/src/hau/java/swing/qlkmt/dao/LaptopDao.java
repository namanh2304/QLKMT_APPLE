package hau.java.swing.qlkmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import hau.java.swing.qlkmt.model.Connector;
import hau.java.swing.qlkmt.model.Laptop;
import hau.java.swing.qlkmt.model.MayTinh;

public class LaptopDao implements DAOInterface<Laptop> {
	public static LaptopDao getInstance() {
		return new LaptopDao();
	}

	@Override
	public int insert(Laptop t) {
		int ketqua = 0;
		try {
			Connection con = Connector.getConnection();
			String sql = "INSERT INTO MayTinh (maMay, tenMay, soLuong, tenCpu,ram,rom,dungLuongPin,kichThuocMan,gia,loaiMay,trangThai) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaMay());
			ps.setString(2, t.getTenMay());
			ps.setInt(3, t.getSoLuong());
			ps.setString(4, t.getTenCpu());
			ps.setString(5, t.getRam());
			ps.setString(6, t.getRom());
			ps.setString(7, t.getdungLuongPin());
			ps.setDouble(8, t.getkichThuocMan());
			ps.setDouble(9, t.getGia());
			ps.setString(10, "Laptop");
			ps.setInt(11, t.getTrangThai());
			ketqua = ps.executeUpdate();
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Khong them duoc" + t.getMaMay(), "Loi", JOptionPane.ERROR_MESSAGE);
		}
		return ketqua;
	}

	@Override
	public int update(Laptop t) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = Connector.getConnection();
			String sql = "UPDATE MayTinh SET maMay = ?, tenMay=?, soLuong=?,tenCpu=?,ram=?,rom=?,dungLuongPin=?,kichThuocMan=?,gia=?,loaiMay=?,trangThai=?, WHERE maMay =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaMay());
			ps.setString(2, t.getTenMay());
			ps.setInt(3, t.getSoLuong());
			ps.setString(4, t.getTenCpu());
			ps.setString(5, t.getRam());
			ps.setString(6, t.getRom());
			ps.setString(7, t.getdungLuongPin());
			ps.setDouble(8, t.getkichThuocMan());
			ps.setDouble(9, t.getGia());
			ps.setString(10, "Laptop");
			ps.setInt(11, t.getTrangThai());
			ps.setString(12, t.getMaMay());
			ketqua = ps.executeUpdate();
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int delete(Laptop t) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = Connector.getConnection();
			String sql = "DELETE FROM MayTinh WHERE maMay=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ketqua = ps.executeUpdate();
			Connector.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<Laptop> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Laptop> ketqua = new ArrayList<Laptop>();
		try {
			Connection con = Connector.getConnection();
			String sql = "SELECT * FROM MayTinh";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maMay = rs.getString("maMay");
				String tenMay = rs.getString("tenMay");
				int soLuong = rs.getInt("soLuong");
				String tenCpu = rs.getString("tenCpu");
				String ram = rs.getString("ram");
				String rom = rs.getString("rom");
				String dungLuongPin = rs.getString("dungLuongPin");
				double kichThuocMan = rs.getDouble("kichThuocMan");
				double gia = rs.getDouble("gia");
				int trangThai = rs.getInt("trangThai");
				Laptop mt = new Laptop(kichThuocMan, dungLuongPin, maMay, tenMay, soLuong, tenCpu, ram, rom, gia, trangThai);
				ketqua.add(mt);
				
			}
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public Laptop selectById(String t) {
		// TODO Auto-generated method stub
		Laptop ketqua = null;
		try {
			Connection con = Connector.getConnection();
			String sql = "SELECT * FROM MayTinh WHERE maMay=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maMay = rs.getString("maMay");
				String tenMay = rs.getString("tenMay");
				int soLuong = rs.getInt("soLuong");
				String tenCpu = rs.getString("tenCpu");
				String ram = rs.getString("ram");
				String rom = rs.getString("rom");
				String dungLuongPin = rs.getString("dungLuongPin");
				double kichThuocMan = rs.getDouble("kichThuocMan");
				double gia = rs.getDouble("gia");
				int trangThai = rs.getInt("trangThai");
				ketqua = new Laptop(kichThuocMan, dungLuongPin, maMay, tenMay, soLuong, tenCpu, ram, rom, gia, trangThai);
				
			}
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public boolean isLaptop(String id) {
		try {
			Connection con = Connector.getConnection();
			String sql = "SELECT * FROM MayTinh WHERE maMay=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			String loai = null;
			while (rs.next()) {
				loai = rs.getString("loaiMay");
				
			}
			if (loai.equals("Laptop")) {
				return true;
			}
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
