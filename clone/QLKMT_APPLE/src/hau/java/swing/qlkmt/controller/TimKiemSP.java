package hau.java.swing.qlkmt.controller;

import java.util.ArrayList;

import hau.java.swing.qlkmt.dao.MayTinhDao;
import hau.java.swing.qlkmt.model.MayTinh;

public class TimKiemSP {
	public static TimKiemSP getInstance() {
		return new TimKiemSP();
	}
	
	public ArrayList<MayTinh> searchMaMay (String text) {
		ArrayList<MayTinh> result = new ArrayList<>();
		ArrayList<MayTinh> armt = MayTinhDao.getIntance().selectAllExist();
		for (var mt : armt) {
			if (mt.getTrangThai() == 1) {
				if(mt.getMaMay().toLowerCase().contains(text.toLowerCase())) {
					result.add(mt);
				}
			}
			 
		}
		return result;		
	}
	
	public ArrayList<MayTinh> searchTenMay (String text) {
		ArrayList<MayTinh> result = new ArrayList<>();
		ArrayList<MayTinh> armt = MayTinhDao.getIntance().selectAllExist();
		for (var mt : armt) {
			if (mt.getTrangThai() == 1) {
				if(mt.getTenMay().toLowerCase().contains(text.toLowerCase())) {
					result.add(mt);
				}
			}
			 
		}
		return result;		
	}
}
