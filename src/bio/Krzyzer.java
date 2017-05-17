package bio;

import java.util.ArrayList;
import java.util.List;


class Krzyzer {

	public Rozwiazanie krzyzuj(Rozwiazanie r1, Rozwiazanie r2) {
		int m = 0;
		List<Oligonukleotyd> rTemp = new ArrayList<Oligonukleotyd>();
		int i=0;
		while(m <= (Projekt.getLiczbaSlow()/2)-1){
			m += r1.getSlowa().get(i++).getLiczbaSlow();
		}
		m = i;
		for(int k = 0; k < m ; k++ ){
			rTemp.add(r1.getSlowa().get(k));
		}
		for(Oligonukleotyd o : rTemp) r1.getSlowa().remove(o);
		int diff = 0;
		int inId = 0;
		/*while(!rTemp.isEmpty()){
			for(i = 0; i < r2.getSlowa().size(); i++){
				Oligonukleotyd o = r2.getSlowa().get(i);
				int index  = indexOn(rTemp, o);
				if(index > -1)
				{
					rTemp.remove(o);
					r1.dodajSlowo(o);
				}
			}
		}*/
		while(rTemp.size() < r2.getSlowa().size())
		{
			for(i = 0; i < r2.getSlowa().size(); i++){
				Oligonukleotyd o = r2.getSlowa().get(i);
				int index  = indexOn(rTemp, o);
				if(index == -1)
				{
					rTemp.add(o);
				}
			}
		}
		//r1.setSlowa(rTemp);
		return new Rozwiazanie(rTemp);
	}
	
	private  int indexOn(List<Oligonukleotyd> rTemp, Oligonukleotyd o) {
			for(int i = 0; i < rTemp.size(); i++)
				if(rTemp.get(i).equals(o)) return i;
			return -1;
	}
}
