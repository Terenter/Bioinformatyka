package bio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rozwiazanie implements Cloneable {
	private int rozmiar;
	private int wartosc;
	private List<Oligonukleotyd>Slowa = new ArrayList<Oligonukleotyd>();
	
	public int getWartosc() {
		return wartosc;
	}

	public List<Oligonukleotyd> getSlowa() {
		return Slowa;
	}
	
	public void zamienSlowo(int indeks, int nowyIndeks){
		Slowa.get(indeks).setIndeks(nowyIndeks);
		Slowa.get(nowyIndeks).setIndeks(indeks);
		Collections.sort(Slowa);
	}

	public void przeliczWartosc(int[][] grafOl) {
		wartosc=0;
		int[][] graf = Projekt.getGrafOl();
		for(int i =0;i<rozmiar-1;i++){
			int i1=Slowa.get(i).getIndeks();
			int i2=Slowa.get(i+1).getIndeks();
			wartosc+=graf[i1][i2];
		}
	}
	
	public Rozwiazanie clone(){
		Rozwiazanie rNew = new Rozwiazanie();
		rNew.Slowa = Slowa;
		return rNew;
	}
	
	

}
