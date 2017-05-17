package bio;

import java.util.ArrayList;

class Przedprzetwarzacz {

	public int[][]  generujGraf(Oligonukleotyd[] dane){
		int n=dane.length;
		int[][] graf=new int[dane.length][dane.length];
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if(i==j)continue;
				graf[i][j]=policzOdleglosc(dane[i], dane[j]);
			}
		}	
		return graf;
	}
	
	private int policzOdleglosc(Oligonukleotyd lewy, Oligonukleotyd prawy){
		String l=lewy.getLancuch();
		String p=prawy.getLancuch();
		int L=l.length();
		for(int i=1;i<L;i++){
			if(l.substring(i).equals(p.substring(0, L-i-1))){
				return i;
			}
		}
		return L;
	}
	
	private void znajdzPolaczenia(int [][] graf, Oligonukleotyd[] dane){
		int n=dane.length;
		int indeks,indeks2;
		for(int i=0;i<n;i++){
			indeks=-1;
			for(int j=0;j<n;j++){	
				if(graf[i][j]==1){
					if(indeks!=-1){
						indeks=-1;
						break;
					}
					indeks=j;
				}
			}
			if(indeks!=-1){
				indeks2=-1;
				for(int k=0;k<n;k++){
					if(graf[k][indeks]==1){
						if(indeks2!=-1){
							indeks2=-1;
							break;
						}
						indeks2=k;
					}
				}
				if(indeks2!=-1){
					dane[i].setNastepny(indeks);
					dane[indeks].setPoprzedni(i);
				}
			}
		}
	}
	
	private Oligonukleotyd zlacz(Oligonukleotyd o1, Oligonukleotyd o2)
	{
		Oligonukleotyd o = new Oligonukleotyd(o1.getLancuch()+o2.getLancuch().substring(o2.getDlugosc()-o1.getDlugosc()-1),o1.getDlugosc()+o2.getDlugosc()-10);
		o.setLiczbaSlow(o1.getLiczbaSlow()+o2.getLiczbaSlow());
		o.setPoprzedni(o1.getPoprzedni());
		if(o2.getNastepny()!=o2.getIndeks())o.setNastepny(o2.getNastepny());
		else o.setNastepny(o1.getIndeks());
		o.setIndeks(o1.getIndeks());
		return o;
		
	}

	public Oligonukleotyd[] przetworz(int[][] grafOl, Oligonukleotyd[] instancja) {
		znajdzPolaczenia(grafOl, instancja);
		ArrayList<Oligonukleotyd> nowa=new ArrayList<Oligonukleotyd>();
		for(int i=0;i<instancja.length;i++){
			if(instancja[i].getPoprzedni()==i){
				while(instancja[i].getNastepny()!=i){
					instancja[i] = zlacz(instancja[i],instancja[instancja[i].getNastepny()]); 
				}
				nowa.add(instancja[i]);
				int x=nowa.size()-1;
				nowa.get(x).setIndeks(x);
			}
		}
		return nowa.toArray(new Oligonukleotyd[nowa.size()]);
	}
}
