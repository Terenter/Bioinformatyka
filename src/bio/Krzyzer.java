package bio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Krzyzer {

	public Rozwiazanie krzyzuj(Rozwiazanie r1, Rozwiazanie r2) {
//		r1.przeliczWartosc(Projekt.getGrafOl());
//		r2.przeliczWartosc(Projekt.getGrafOl());
//		int w1 = r1.getWartosc();
//		int w2 = r2.getWartosc();
		int m = 0;
		List<Oligonukleotyd> rTemp = new ArrayList<Oligonukleotyd>();
		int i=0;
		while(m <= (Projekt.getLiczbaSlow()/2)-1 && i < r1.getSlowa().size()){
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
//		Rozwiazanie Temp = new Rozwiazanie(rTemp);
//		Temp.przeliczWartosc(Projekt.getGrafOl());
//		System.out.println(Integer.toString(w1) + " " + Integer.toString(w2) + " " + Integer.toString(Temp.getWartosc()));
//		try {
//			System.in.read();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return new Rozwiazanie(rTemp);
	}
	
	private  int indexOn(List<Oligonukleotyd> rTemp, Oligonukleotyd o) {
			for(int i = 0; i < rTemp.size(); i++)
				if(rTemp.get(i).equals(o)) return i;
			return -1;
	}
}
