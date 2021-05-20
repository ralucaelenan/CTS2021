package ro.ase.acs.memento;

public class TablaJoc implements Cloneable {
	private char [][] matrice= new char[3][3];
	
	public char[][] getMatrice() {
		char [][] matriceNoua = new char [3][3];
		for(int i=0; i<matrice.length;i++) {
			for(int j=0; j<matrice[i].length;j++) {
				matriceNoua[i][j]=matrice[i][j];
			}
		}
		return matrice;
	}

	public Object clone() throws CloneNotSupportedException {
		TablaJoc copy = (TablaJoc)super.clone();
		
		copy.matrice= new char[3][3];
		for(int i=0; i<matrice.length;i++) {
			for(int j=0; j<matrice[i].length;j++) {
				copy.matrice[i][j]=matrice[i][j];
			}
		}
		return copy;
	};
	
	public void adaugaX(int linie, int coloana) {
		matrice[linie][coloana] = 'X';
	}
	
	public void adaugaO(int linie, int coloana) {
		matrice[linie][coloana] = 'O';
	}
	
	public void stergeTabla() {
		for(int i=0; i<matrice.length;i++) {
			for(int j=0; j<matrice[i].length;j++) {
				matrice[i][j]=0;
			}
		}
	}
}
