package hau.java.swing.qlkmt.model;

import java.util.Objects;
public class MayTinh {
    public String maMay;
    public String tenMay;
    public int soLuong;
    public String tenCpu;
    public String ram;
    public String rom;
    public double gia;
    public int trangThai;
    

    public MayTinh(){
        
    }

    public MayTinh(String maMay, String tenMay, int soLuong, double donGia, String boXuLi, String loaiMay, int trangThai){
        
    }

    public MayTinh(String maMay, String tenMay, int soLuong, String tenCpu, String ram, String rom, double gia, int trangThai) {
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.soLuong = soLuong;
        this.tenCpu = tenCpu;
        this.ram = ram;
        this.rom = rom;
        this.gia = gia;
        this.trangThai = trangThai;
    }
    
    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public MayTinh(String maMay, String tenMay, int soLuong, double gia,String tenCpu, String ram,String rom) {
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tenCpu = tenCpu;
        this.ram = ram;
        this.rom = rom;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenCpu() {
        return tenCpu;
    }

    public void setTenCpu(String tenCpu) {
        this.tenCpu = tenCpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void xuatHang (int s1) {
        this.soLuong -= s1;
    }

    @Override
    public String toString() {
        return "MayTinh{" + "maMay=" + maMay + ", tenMay=" + tenMay + ", soLuong=" + soLuong + ", gia=" + gia + ", tenCpu=" + tenCpu + ", ram=" + ram + ", rom=" + rom + '}';
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MayTinh other = (MayTinh) obj;
        if (this.soLuong != other.soLuong) {
            return false;
        }
        if (Double.doubleToLongBits(this.gia) != Double.doubleToLongBits(other.gia)) {
            return false;
        }
        if (!Objects.equals(this.maMay, other.maMay)) {
            return false;
        }
        if (!Objects.equals(this.tenMay, other.tenMay)) {
            return false;
        }
        if (!Objects.equals(this.tenCpu, other.tenCpu)) {
            return false;
        }
        if (!Objects.equals(this.ram, other.ram)) {
            return false;
        }
        return Objects.equals(this.rom, other.rom);
    }
}
