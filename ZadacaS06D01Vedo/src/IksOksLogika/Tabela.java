package IksOksLogika;

public class Tabela {

	private Polje[][] matrica;

	public Tabela() {
		matrica = new Polje[3][3];
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				matrica[i][j] = new Polje();
			}
		}
	}
/**
 * Funckija postavlja polje u matricu pod koordinatama i,j.
 * @param aktivniIgrac
 * @param i
 * @param j
 * @throws Exception
 */
	public void setPolje(int aktivniIgrac, int i, int j) throws Exception{
		if(provjeriPolje(i, j)){
			matrica[i][j].postaviPolje(aktivniIgrac);
		}
		throw new ArrayIndexOutOfBoundsException("Nisu dobri indexi(setPolje)");
	}
	/**
	 * Getter polja matrice pod koordinatama i,j
	 * @param i
	 * @param j
	 * @return
	 */
	public Polje getPolje(int i, int j) {
		if (provjeriPolje(i, j)) {
			return matrica[i][j];
		}
		throw new ArrayIndexOutOfBoundsException("Nisu dobri indexi");
	}
/**
 * Provjera jesu li koordinate ok.
 * @param i
 * @param j
 * @return
 */
	public boolean provjeriPolje(int i, int j) {
		return !(i < 0 || i >= matrica.length || j < 0 || j >= matrica[i].length);

	}
}
