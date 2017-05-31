package bio;

import java.io.IOException;
import java.util.Random;

class Mutator {

	public Rozwiazanie mutuj(Rozwiazanie r1) {
		Random rand = new Random();
		int size = r1.getSlowa().size();
		int count=size*Projekt.getStopienMutacji()/100;
		for (int i = 0; i < count; i++) {

			int indeks1 = rand.nextInt(size);
			int indeks2 = rand.nextInt(size);
			while (indeks2 == indeks1) {
				indeks2 = rand.nextInt(size);
			}
			// r1.przeliczWartosc(Projekt.getGrafOl());
			r1.przesunSlowo(indeks1, indeks2);
		}
		// System.out.println(r1.getWartosc());
		// r1.przeliczWartosc(Projekt.getGrafOl());
		// System.out.println(r1.getWartosc());
		// try {
		// System.in.read();
		// } catch (IOException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return r1;
	}

}
