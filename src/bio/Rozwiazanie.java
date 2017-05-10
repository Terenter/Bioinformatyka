package bio;

import java.util.ArrayList;
import java.util.List;

public class Rozwiazanie implements Cloneable {
	private int rozmiar=0;
	private int wartosc=0;
	private List<Oligonukleotyd>Slowa = new ArrayList<Oligonukleotyd>();
	
	public Rozwiazanie(List<Oligonukleotyd> clone) {
		Slowa = clone;
		setRozmiar(clone.size());
	}

	public int getWartosc() {
		return wartosc;
	}

	public List<Oligonukleotyd> getSlowa() {
		return Slowa;
	}
	
	public void przesunSlowo(int indeks, int nowyIndeks){
		Oligonukleotyd temp = Slowa.get(indeks);
		Slowa.remove(temp);
		Slowa.add(nowyIndeks, temp);
	}

	public void przeliczWartosc(int[][] grafOl) {
		Oligonukleotyd s1=Slowa.get(0);
		wartosc=s1.getLiczbaSlow();
		int dlugosc=s1.getDlugosc();
		int[][] graf = Projekt.getGrafOl();
		int i=1;
		while(dlugosc<Projekt.getDlugoscSekwencji()&&i<Slowa.size()){
			Oligonukleotyd s2=Slowa.get(i++);
			int i1=s1.getIndeks();
			int i2=s2.getIndeks();
			dlugosc+=graf[i1][i2];
			if(dlugosc<=Projekt.getDlugoscSekwencji()){
				wartosc+=s2.getLiczbaSlow();
				s1=s2;
			}
		}
	}
	
	public Rozwiazanie clone(){
		Rozwiazanie rNew = new Rozwiazanie( new ArrayList<Oligonukleotyd>(Slowa));
		return rNew;
	}

	public void dodajSlowo(Oligonukleotyd o) {
		Slowa.add(o);		
	}

	public int getRozmiar() {
		return rozmiar;
	}

	public void setRozmiar(int rozmiar) {
		this.rozmiar = rozmiar;
	}
	
	

}
