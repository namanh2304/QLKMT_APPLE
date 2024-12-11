package hau.java.swing.qlkmt.model;

import java.util.Objects;

public class IMac extends MayTinh {
	private double kichThuocMan;
	private String congSuatNguon;

	public IMac(double kichThuocMan, String congSuatNguon, String maMay, String tenMay, int soLuong, String tenCpu, String ram, String rom, double gia,
			int trangThai) {
		super(maMay, tenMay, soLuong, rom, tenCpu, ram, gia, trangThai);
		this.kichThuocMan = kichThuocMan;
		this.congSuatNguon = congSuatNguon;
	}

	public IMac() {

	}

	public double getkichThuocMan() {
		return kichThuocMan;
	}

	public void setkichThuocMan() {
		this.kichThuocMan = kichThuocMan;
	}
	
	public String getcongSuatNguon () {
		return congSuatNguon;
	}
	
	public void setcongSuatNguon() {
		this.congSuatNguon = congSuatNguon;
	}
	
	@Override
    public String toString() {
        return "IMac{" + "kichThuocMan=" + kichThuocMan + ", congSuatNguon=" + congSuatNguon + '}';
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
	        final IMac other = (IMac) obj;
	        if (!Objects.equals(this.kichThuocMan, other.kichThuocMan)) {
	            return false;
	        }
	        return Objects.equals(this.congSuatNguon, other.congSuatNguon);
	    }
}
