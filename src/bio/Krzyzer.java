package bio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Krzyzer {

	public Rozwiazanie[] krzyzuj(Rozwiazanie r1, Rozwiazanie r2 ,int l1) {
//		r1.przeliczWartosc(Projekt.getGrafOl());
//		r2.przeliczWartosc(Projekt.getGrafOl());
//		int w1 = r1.getWartosc();
//		int w2 = r2.getWartosc();
		//l1 = (Projekt.getLiczbaSlow()/2)-1;
		int m = 0;
		List<Oligonukleotyd> rTemp = new ArrayList<Oligonukleotyd>();
		List<Oligonukleotyd> rTemp2 = new ArrayList<Oligonukleotyd>();
		int i=0;
		//l1 = Projekt.getLiczbaSlow() / 2;
		while(m <= l1 && i < r1.getSlowa().size()){
			m += r1.getSlowa().get(i++).getLiczbaSlow();
		}
		m = i;
		//m = r1.getSlowa().size()/2+1;
		int k = 0;
		while(k < m){
			rTemp.add(r1.getSlowa().get(k++));
		}
		while(k < r1.getSlowa().size()){
			rTemp2.add(r1.getSlowa().get(k++));
		}
		int position = 0;
		while(rTemp.size() < r2.getSlowa().size())
		{
			for(i = 0; i < r2.getSlowa().size(); i++){
				Oligonukleotyd o = r2.getSlowa().get(i);
				int index  = indexOn(rTemp, o);
				if(index == -1)
				{
					while (position < rTemp.size())
					{
						int a = Projekt.getGrafOl()[o.getIndeks()][rTemp.get(position).getIndeks()];
						int b = 0;
						if(position > 0) b = Projekt.getGrafOl()[rTemp.get(position-1).getIndeks()][o.getIndeks()];
						int c =  b = Projekt.getGrafOl()[rTemp.get(rTemp.size()-1).getIndeks()][o.getIndeks()];
						if(c <= a + b - o.getDlugosc()) break;
						++position;
					}
					if(position < rTemp.size())
					{
						rTemp.add(position++, o);
					}
					else rTemp.add(o);
				}
			}
		}
		position = 0;
		while(rTemp2.size() < r2.getSlowa().size())
		{
			for(i = 0; i < r2.getSlowa().size(); i++){
				Oligonukleotyd o = r2.getSlowa().get(i);
				int index  = indexOn(rTemp2, o);
				if(index == -1)
				{
					while (position < rTemp2.size())
					{
						int a = Projekt.getGrafOl()[o.getIndeks()][rTemp2.get(position).getIndeks()];
						int b = 0;
						if(position > 0) b = Projekt.getGrafOl()[rTemp2.get(position-1).getIndeks()][o.getIndeks()];
						int c =  b = Projekt.getGrafOl()[rTemp2.get(rTemp2.size()-1).getIndeks()][o.getIndeks()];
						if(c <= a + b - o.getDlugosc()) break;
						++position;
					}
					if(position < rTemp2.size())
					{
						rTemp2.add(position++, o);
					}
					else rTemp2.add(o);
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
		Rozwiazanie[] table = new Rozwiazanie[2];
		table[0] = new Rozwiazanie(rTemp);
		table[1] = new Rozwiazanie(rTemp2);
		return table;// new Rozwiazanie[](rTemp);
	}
	
	private  int indexOn(List<Oligonukleotyd> rTemp, Oligonukleotyd o) {
			for(int i = 0; i < rTemp.size(); i++)
				if(rTemp.get(i).equals(o)) return i;
			return -1;
	}
}
