package bio;

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
	
	public int[][] skrocGraf(int [][] graf, Oligonukleotyd[] dane){
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
					Oligonukleotyd oTym = zlacz(dane[i],dane[indeks]);
					dane[i] = oTym;
					dane[indeks] = oTym;
					dane[i].setNastepny(dane[indeks]);
					dane[indeks].setPoprzedni(dane[i]);
				}
			}
		}
		return graf;
	}
	
	private Oligonukleotyd zlacz(Oligonukleotyd o1, Oligonukleotyd o2)
	{
		Oligonukleotyd o = new Oligonukleotyd(o1.getLancuch()+o2.getLancuch().substring(o2.getDlugosc()-o1.getDlugosc()-1),o1.getDlugosc()+o2.getDlugosc()-10);
		o.setLiczbaSlow(o1.getLiczbaSlow()+o2.getLiczbaSlow());
		return o;
		
	}
}
