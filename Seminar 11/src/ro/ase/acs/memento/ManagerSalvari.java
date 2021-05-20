package ro.ase.acs.memento;

import java.util.ArrayList;
import java.util.List;

public class ManagerSalvari {
	private List<TablaJoc> salvari = new ArrayList<TablaJoc>();
	
	public void salveazaJoc(TablaJoc tablaJoc) {
		try {
			salvari.add((TablaJoc)tablaJoc.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	public TablaJoc restaurareJoc(int index) {
		if(index>=0 && index <salvari.size()) {
			return salvari.get(index);
		}else {
			return null;
		}
	}
}
