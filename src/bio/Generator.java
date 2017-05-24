package bio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Generator {

	public List<Rozwiazanie> generuj(Oligonukleotyd[] instancja, int rozmiarPopulacji) {
		ArrayList<Oligonukleotyd> temp = new ArrayList<Oligonukleotyd>(Arrays.asList(instancja));
		List<Rozwiazanie>populacja = new ArrayList<Rozwiazanie>();
		for(int i = 0; i < rozmiarPopulacji; ++i)
		{
			for(int j = 0; j < 20; j++ )
			{
				Collections.shuffle(temp);
			}
			Rozwiazanie rTemp = new Rozwiazanie(new ArrayList<Oligonukleotyd>(temp));
			populacja.add(rTemp);
		}
		return populacja;
	}

}
