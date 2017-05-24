package bio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Eliminator {

	public int grupa = 15;

	public List<Rozwiazanie> turniej(List<Rozwiazanie> populacja) {
		int n = Projekt.getRozmiarPopulacji();
		Random rand = new Random();
		List<Rozwiazanie> r=new ArrayList<Rozwiazanie>();
		for (int i = 0; i < n-1; i++) {
			int n2=populacja.size();
			int x1, x2;
			x1 = rand.nextInt(n2);
			for (int j = 0; j < grupa; j++) {
				x2 = rand.nextInt(n2);
				while(x2==x1)x2 = rand.nextInt(n2);
				if (populacja.get(x2).getWartosc() > populacja.get(x1).getWartosc()) {
					x1 = x2;
				}
			}
			r.add(populacja.remove(x1));			
		}
		int x=0;
		for(int i=1;i<populacja.size();i++){
			if(populacja.get(i).getWartosc()>populacja.get(x).getWartosc()){
				x=i;
			}
		}
		r.add(populacja.remove(x));
		return r;
	}
}
