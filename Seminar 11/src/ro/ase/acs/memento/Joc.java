package ro.ase.acs.memento;

public class Joc {
	private TablaJoc tablaJoc = new TablaJoc();
	private ManagerSalvari managerSalvari = new ManagerSalvari();

	public void valideazaCastigator() {
		/// ...
	}

	public void adaugaSimbol(char simbol, int linie, int coloana) {
		if (simbol == 'X') {
			tablaJoc.adaugaX(linie, coloana);
		} else {
			tablaJoc.adaugaO(linie, coloana);
		}
	}

	public void salvare() {
		managerSalvari.salveazaJoc(tablaJoc);
	}

	public void restaurare(int index) {
		tablaJoc = managerSalvari.restaurareJoc(index);
	}

	public void afiseazaTabla() {
		if (tablaJoc != null) {
			char[][] m = tablaJoc.getMatrice();
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print(m[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
