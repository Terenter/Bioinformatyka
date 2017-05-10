package bio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Projekt {

	private static int rozmiarPopulacji;
	private static int prawdopodobienstwoMutacji;
	private static int prawdopodobienstwoKrzyzowania;
	private static int[][] grafOl;
	private static Oligonukleotyd[] instancja;
	private static int liczbaIteracji;
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
		populacja = new Generator().generuj(instancja, rozmiarPopulacji);
		for(Rozwiazanie r1 : populacja) r1.przeliczWartosc(grafOl);
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
					temp.add(krzyzer.krzyzuj(r1,r2));
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
	
	

}
