package bio;

class Oligonukleotyd {
	private String lancuch;
	private Oligonukleotyd poprzedni = null;
	private Oligonukleotyd nastepny = null;
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
	public Oligonukleotyd getPoprzedni() {
		return poprzedni;
	}
	public void setPoprzedni(Oligonukleotyd poprzedni) {
		this.poprzedni = poprzedni;
	}
	public Oligonukleotyd getNastepny() {
		return nastepny;
	}
	public void setNastepny(Oligonukleotyd nastepny) {
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
