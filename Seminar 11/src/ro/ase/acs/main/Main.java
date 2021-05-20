package ro.ase.acs.main;

import ro.ase.acs.memento.Joc;

public class Main {

	public static void main(String[] args) {
		Joc joc = new Joc();
		joc.afiseazaTabla();
		joc.adaugaSimbol('X', 0, 0);
		joc.adaugaSimbol('O', 1, 1);
		joc.adaugaSimbol('X', 2, 2);
		joc.afiseazaTabla();
		joc.salvare();
		joc.adaugaSimbol('O', 0, 2);
		joc.afiseazaTabla();
		joc.salvare();
		joc.adaugaSimbol('X', 2, 0);
		joc.afiseazaTabla();
		
		joc.restaurare(0);
		joc.afiseazaTabla();
		joc.restaurare(1);
		joc.afiseazaTabla();
	}
}
