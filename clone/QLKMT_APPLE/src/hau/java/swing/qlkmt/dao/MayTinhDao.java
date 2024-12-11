package hau.java.swing.qlkmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hau.java.swing.qlkmt.model.Connector;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import hau.java.swing.qlkmt.model.Laptop;
import hau.java.swing.qlkmt.model.MayTinh;
import hau.java.swing.qlkmt.model.IMac;

public class MayTinhDao implements DAOInterface<MayTinh> {
	public static MayTinhDao getIntance() {
		return new MayTinhDao();
	}

	@Override
	public int insert(MayTinh t) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int update(MayTinh t) {
		int ketqua = 0;
		try {
			Connection con = Connector.getConnection();
			String sql = "UPDATE MayTinh SET tenMay = ?, soLuong = ?, gia = ?, tenCpu=?, ram=?, rom=?, trangThai=?, WHERE maMay=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getTenMay());
			ps.setInt(2, t.getSoLuong());
			ps.setDouble(3, t.getGia());
			ps.setString(4, t.getTenCpu());
			ps.setString(5, t.getRam());
			ps.setString(6, t.getRom());
			ps.setInt(7, t.getTrangThai());
			ketqua = ps.executeUpdate(sql);
			Connector.closeConnection(con);
		} catch (SQLException ex) {
			Logger.getLogger(MayTinhDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ketqua;
	}

	@Override
	public int delete(MayTinh t) {
		int ketqua = 0;
		try {
			Connection con = Connector.getConnection();
			String sql = "DELETE FROM MayTinh WHERE maMay=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getMaMay());
			ketqua = ps.executeUpdate(sql);
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<MayTinh> selectAll() {
		ArrayList<MayTinh> ketqua = new ArrayList<MayTinh>();
		try {
			Connection con = Connector.getConnection();
			String sql = "SELECT maMay, tenMay, soLuong, tenCpu,ram,rom,gia,trangThai FROM MayTinh";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maMay = rs.getString("maMay");
				String tenMay = rs.getString("tenMay");
				int soLuong = rs.getInt("soLuong");
				String tenCpu = rs.getString("tenCpu");
				String ram = rs.getString("ram");
				String rom = rs.getString("rom");
				double gia = rs.getDouble("gia");
				int trangThai = rs.getInt("trangThai");
				MayTinh mt = new MayTinh(maMay, tenMay, soLuong, tenCpu, ram, rom, gia, trangThai);
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
	public MayTinh selectById(String t) {
		// TODO Auto-generated method stub
		MayTinh ketqua = null;
		try {
			Connection con = Connector.getConnection();
			String sql = "SELECT maMay, tenMay, soLuong, tenCpu,ram,rom,gia,trangThai FROM MayTinh";
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
				double gia = rs.getDouble("gia");
				int trangThai = rs.getInt("trangThai");
				ketqua = new MayTinh(maMay, tenMay, soLuong, tenCpu, ram, rom, gia, trangThai);
			}
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	public int updateSoLuong(String maMay, int soLuong) {
		int ketqua = 0;
		try {
			Connection con = Connector.getConnection();
			String sql = "UPDATE MayTinh SET soLuong = ? WHERE maMay=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, soLuong);
			ps.setString(2, maMay);
			ketqua = ps.executeUpdate();
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	public int deleteTrangThai(String maMay) {
		int ketqua = 0;
		try {
			Connection con = Connector.getConnection();
			String sql = "UPDATE MayTinh SET trangThai = 0 WHERE maMay=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maMay);
			ketqua = ps.executeUpdate();
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	public ArrayList<MayTinh> selectAlle() {
		ArrayList<MayTinh> ketqua = new ArrayList<MayTinh>();
		ArrayList<MayTinh> ketquaTonKho = new ArrayList<>();
		try {
			Connection con = Connector.getConnection();
			String sql = "SELECT maMay, tenMay, soLuong, tenCpu,ram,rom,gia,trangThai FROM MayTinh";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maMay = rs.getString("maMay");
				String tenMay = rs.getString("tenMay");
				int soLuong = rs.getInt("soLuong");
				String tenCpu = rs.getString("tenCpu");
				String ram = rs.getString("ram");
				String rom = rs.getString("rom");
				double gia = rs.getDouble("gia");
				int trangThai = rs.getInt("trangThai");
				MayTinh mt = new MayTinh(maMay, tenMay, soLuong, tenCpu, ram, rom, gia, trangThai);
				ketqua.add(mt);

			}
			for (MayTinh mayTinh : ketqua) {
				if (mayTinh.getSoLuong() > 0) {
					ketquaTonKho.add(mayTinh);
				}
			}
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketquaTonKho;
	}
	
	public ArrayList<MayTinh> selectAllExist() {
		ArrayList<MayTinh> ketqua = new ArrayList<MayTinh>();
		try {
			Connection con = Connector.getConnection();
			String sql = "SELECT maMay, tenMay, soLuong, tenCpu,ram,rom,gia,trangThai FROM MayTinh WHERE trangThai = 1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maMay = rs.getString("maMay");
				String tenMay = rs.getString("tenMay");
				int soLuong = rs.getInt("soLuong");
				String tenCpu = rs.getString("tenCpu");
				String ram = rs.getString("ram");
				String rom = rs.getString("rom");
				double gia = rs.getDouble("gia");
				int trangThai = rs.getInt("trangThai");
				MayTinh mt = new MayTinh(maMay, tenMay, soLuong, tenCpu, ram, rom, gia, trangThai);
				ketqua.add(mt);

			}
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public int getSoLuong () {
		int soluong = 0;
		try {
			Connection con = Connector.getConnection();
			String sql = "SELECT * FROM MayTinh WHERE trangThai = 1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				soluong++;
			}
			Connector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return soluong;
	}

}
