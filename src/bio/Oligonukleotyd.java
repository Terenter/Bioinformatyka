package bio;

class Oligonukleotyd {
	private String lancuch;
	private int poprzedni = -1;
	private int nastepny = -1;
	private int dlugosc;
	private int liczbaSlow = 1;
	public Oligonukleotyd(String lancuch, int l) {
		this.lancuch = lancuch;
		this.dlugosc = l;
	}
	public String getLancuch() {
		return lancuch;
	}
	public void setLancuch(String lancuch) {
		this.lancuch = lancuch;
	}
	public int getPoprzedni() {
		return poprzedni;
	}
	public void setPoprzedni(int poprzedni) {
		this.poprzedni = poprzedni;
	}
	public int getNastepny() {
		return nastepny;
	}
	public void setNastepny(int nastepny) {
		this.nastepny = nastepny;
	}
	public int getDlugosc() {
		return dlugosc;
	}
	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}
	public int getLiczbaSlow() {
		return liczbaSlow;
	}
	public void setLiczbaSlow(int liczbaSlow) {
		this.liczbaSlow = liczbaSlow;
	}


}
