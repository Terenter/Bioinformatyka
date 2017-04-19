package bio;

import java.io.IOException;

public class Projekt {

	private static int rozmiarPopulacji;
	private static int prawdopodobienstwoMutacji;
	private static int prawdopodobienstwoKrzyzowania;
	private static int[][] grafOl;
	private static Oligonukleotyd[] instancja;
	public static void main(String[] args) {
		try {
			instancja = new Wczytywacz().wczytajDane(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
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
