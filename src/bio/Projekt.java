package bio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Projekt {
	private static int dlugoscSekwencji;
	private static int liczbaSlow;
	public static int getLiczbaSlow() {
		return liczbaSlow;
	}
	public static void setLiczbaSlow(int liczbaSlow) {
		Projekt.liczbaSlow = liczbaSlow;
	}
	public static int getLiczbaIteracji() {
		return liczbaIteracji;
	}
	public static void setLiczbaIteracji(int liczbaIteracji) {
		Projekt.liczbaIteracji = liczbaIteracji;
	}
	public static List<Rozwiazanie> getPopulacja() {
		return populacja;
	}
	public static void setPopulacja(List<Rozwiazanie> populacja) {
		Projekt.populacja = populacja;
	}
<<<<<<< HEAD
	private static int rozmiarPopulacji = 50;
=======
	private static int rozmiarPopulacji = 1000;
>>>>>>> branch 'sec' of https://github.com/Terenter/bioinformatyka
	private static int prawdopodobienstwoMutacji = 100;
	private static int prawdopodobienstwoKrzyzowania = 100;
	private static int[][] grafOl;
	private static Oligonukleotyd[] instancja;
	private static int liczbaIteracji = 1000;
	private static List<Rozwiazanie> populacja;
	
	
	public static void main(String[] args) {
		try {
			instancja = new Wczytywacz().wczytajDane(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Przedprzetwarzacz przedp = new Przedprzetwarzacz();
		grafOl = przedp.generujGraf(instancja);

		instancja = przedp.przetworz(grafOl, instancja);
		grafOl = przedp.generujGraf(instancja);
		int j = 0;
		for(int [] l : grafOl){
			System.out.print(instancja[j++].getLancuch().length()+" ");
			for(int i:l){
				System.out.print(i+",");
			}
			System.out.println("|");
		}
		populacja = new Generator().generuj(instancja, rozmiarPopulacji);
		for(Rozwiazanie r1 : populacja)
		{
			r1.przeliczWartosc(grafOl);
		}
//		for(Rozwiazanie r1 : populacja) System.out.println(r1.getWartosc());
//		try {
//			System.in.read();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Mutator mutator = new Mutator();
		Krzyzer krzyzer = new Krzyzer();
		Eliminator eliminator = new Eliminator();
		Random rand = new Random();
		for(int i = 0; i <liczbaIteracji; i++)
		{
			List<Rozwiazanie> temp = new ArrayList<Rozwiazanie>();
			for(Rozwiazanie r1 : populacja)
			{
				if(rand.nextInt(100) < prawdopodobienstwoMutacji)
				{
					temp.add(mutator.mutuj(r1.clone()));
				}
			}
			for(Rozwiazanie r1 : temp)
			{
				r1.przeliczWartosc(grafOl);
				populacja.add(r1);
			}
			temp.clear();
			for(Rozwiazanie r1 : populacja)
			{
				if(rand.nextInt(100) < prawdopodobienstwoKrzyzowania)
				{
					int l = rand.nextInt(populacja.size() - 1);
					Rozwiazanie r2 = populacja.get(l);
					if(r2.equals(r1)) r2 = populacja.get(populacja.size()-1);
					temp.add(krzyzer.krzyzuj(r1.clone(),r2.clone()));
				}
			}
			for(Rozwiazanie r1 : temp)
			{
				r1.przeliczWartosc(grafOl);
				populacja.add(r1);
			}
			temp.clear();
			populacja = eliminator.turniej(populacja);
		}
		Rozwiazanie best = populacja.get(0);
		for(int i = 1; i < populacja.size(); i++){
			if(populacja.get(i).getWartosc() > best.getWartosc()) best = populacja.get(i);
		}
		System.out.println(best.getWartosc());
		for(Oligonukleotyd i : best.getSlowa()){
			System.out.println(i.getLancuch());
		}
		System.out.println(best.Wynik(grafOl));

	}
	public static int getRozmiarPopulacji() {
		return rozmiarPopulacji;
	}
	public static void setRozmiarPopulacji(int rozmiarPopulacji) {
		Projekt.rozmiarPopulacji = rozmiarPopulacji;
	}
	public static int getPrawdopodobienstwoMutacji() {
		return prawdopodobienstwoMutacji;
	}
	public static void setPrawdopodobienstwoMutacji(int prawdopodobienstwoMutacji) {
		Projekt.prawdopodobienstwoMutacji = prawdopodobienstwoMutacji;
	}
	public static int getPrawdopodobienstwoKrzyzowania() {
		return prawdopodobienstwoKrzyzowania;
	}
	public static void setPrawdopodobienstwoKrzyzowania(
			int prawdopodobienstwoKrzyzowania) {
		Projekt.prawdopodobienstwoKrzyzowania = prawdopodobienstwoKrzyzowania;
	}
	public static int[][] getGrafOl() {
		return grafOl;
	}
	public static void setGrafOl(int[][] grafOl) {
		Projekt.grafOl = grafOl;
	}
	public static Oligonukleotyd[] getInstancja() {
		return instancja;
	}
	public static void setInstancja(Oligonukleotyd[] instancja) {
		Projekt.instancja = instancja;
	}
	public static int getDlugoscSekwencji() {
		return dlugoscSekwencji;
	}
	public static void setDlugoscSekwencji(int dlugoscSekwencji) {
		Projekt.dlugoscSekwencji = dlugoscSekwencji;
	}
	
	

}
