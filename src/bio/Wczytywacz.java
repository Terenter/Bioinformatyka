package bio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Wczytywacz {
	public Oligonukleotyd[] wczytajDane(String plik) throws IOException
	{
		int S = 0;
		int b = 0;
		if(plik.contains("+"))
		{
			S = Integer.parseInt(plik.split(".")[1].split("+")[0]);
			b = Integer.parseInt(plik.split(".")[1].split("+")[1]);
		}
		else
		{
			S = Integer.parseInt(plik.split(".")[1].split("-")[0]);
			b = -Integer.parseInt(plik.split(".")[1].split("-")[1]);
		}
		int l = 10;
		FileReader fr = new FileReader(plik);
		BufferedReader br = new BufferedReader(fr);
		Oligonukleotyd[] dane = new Oligonukleotyd[S+b];
		for(int i = 0; i < S+b; i++)
		{
			dane[i] = new Oligonukleotyd(br.readLine(), l);
			dane[i].setIndeks(i);
			dane[i].setNastepny(i);
			dane[i].setPoprzedni(i);
			
		}
		br.close();
		fr.close();
		return dane;
	}
}
