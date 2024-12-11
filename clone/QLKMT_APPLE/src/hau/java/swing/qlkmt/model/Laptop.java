package hau.java.swing.qlkmt.model;

import java.util.Objects;

public class Laptop extends MayTinh {
	private double kichThuocMan;
	private String dungLuongPin;

	public Laptop(double kichThuocMan, String dungLuongPin, String maMay, String tenMay, int soLuong, String tenCpu,
			String ram, String rom, double gia, int trangThai) {
		super(maMay, tenMay, soLuong, rom, tenCpu, ram, gia, trangThai);
		this.kichThuocMan = kichThuocMan;
		this.dungLuongPin = dungLuongPin;
	}

	public Laptop() {

	}

	public double getkichThuocMan() {
		return kichThuocMan;
	}

	public void setkichThuocMan() {
		this.kichThuocMan = kichThuocMan;
	}

	public String getdungLuongPin() {
		return dungLuongPin;
	}

	public void setdungLuongPin() {
		this.dungLuongPin = dungLuongPin;
	}

	@Override
	public String toString() {
		return "Laptop{" + "kichThuocMan=" + kichThuocMan + ", dungLuongPin=" + dungLuongPin + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Laptop other = (Laptop) obj;
		if (!Objects.equals(this.kichThuocMan, other.kichThuocMan)) {
			return false;
		}
		return Objects.equals(this.dungLuongPin, other.dungLuongPin);
	}
}
