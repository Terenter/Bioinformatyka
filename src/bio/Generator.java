package bio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Generator {

	public List<Rozwiazanie> generuj(Oligonukleotyd[] instancja,
			int rozmiarPopulacji) {
		ArrayList<Oligonukleotyd> temp = new ArrayList<Oligonukleotyd>(Arrays.asList(instancja));
		List<Rozwiazanie>populacja = new ArrayList<Rozwiazanie>();
		for(int i = 0; i < rozmiarPopulacji; ++i)
		{
			Collections.shuffle(temp);
			Rozwiazanie rTemp = new Rozwiazanie();
			for(Oligonukleotyd o : temp)
				rTemp.dodajSlowo(o);
			populacja.add(rTemp);
		}
		return populacja;
	}

}
