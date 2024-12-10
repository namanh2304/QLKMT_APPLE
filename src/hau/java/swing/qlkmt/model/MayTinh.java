package hau.java.swing.qlkmt.model;

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
    }

    public MayTinh(String maMay, String tenMay, int soLuong, double gia,String tenCpu, String ram,String Rom) {
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
}
