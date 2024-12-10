package hau.java.swing.qlkmt.view;

import javax.swing.UIManager;

public class QLkhoMayTinh {

    public static void main(String[] args) {
        // quy định về cách nhìn và cảm nhận 
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // TODO: handle exception
        }
        //new trangChu();
         new trangSanPham();
    }
}
