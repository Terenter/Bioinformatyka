package bio;

import java.util.Random;

class Mutator {

	public Rozwiazanie mutuj(Rozwiazanie r1) {
		Random rand = new Random();
		int size = r1.getSlowa().size();
		int indeks1 = rand.nextInt(size);
		int indeks2 = rand.nextInt(size);
		while(indeks2 == indeks1)
		{
			indeks2 = rand.nextInt(size);
		}
		r1.przesunSlowo(indeks1, indeks2);
		return r1;
	}

}
