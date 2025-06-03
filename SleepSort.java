/* Implementacja algorytmu sleep sort w jezyku programowania Java.
Algorytm ten, chociaz jest (znacznie) niepraktyczny jako algorytm sortowania,
jest oparty o programowanie wielowatkowe, zatem jest to demonstracja
zastosowania systemu wielowatkowosci w Javie.

Ten plik zawiera klase glowna. W sklad programu wchodza takze klasy
SleepSortDocelowa i SleepSortWpisywacz zawarte w oddzielnych plikach.
	Jan Mleczko, czerwiec 2025. */

import java.io.*;

public class SleepSort
{
	private static BufferedReader br;

/* Metody pomocnicze we-wy. */
	private static int czytajLiczbe ()
	throws IOException
	{
		try {
			return Integer.parseInt (br.readLine ());
		} catch (NumberFormatException nfe) {
			return 0;
		}
	}

	private static void piszTablice (int tabl[], int rozmiar)
	{
		int i;
		
		i = 0;
		while (i < rozmiar) {
			if (i > 0)
				System.out.print (',');
			System.out.print (tabl[i++]);
		}
	}

	private static void piszTablice (int tabl[])
	{
		piszTablice (tabl, tabl.length);
	}

/* Metoda glowna. */
	public static void main (String args[])
	throws IOException, InterruptedException
	{
		int tabl[], i, ilosc, a;
		SleepSortDocelowa docel;
		Thread watki[], wt;

		br = new BufferedReader (
			new InputStreamReader (System.in)
		);
		System.out.print ("Dlugosc tablicy liczb? ");
		ilosc = czytajLiczbe ();
		assert ilosc > 0;
		assert ilosc <= 100;
		tabl = new int[ilosc];
		docel = new SleepSortDocelowa (ilosc);
		watki = new Thread[ilosc];
		i = 0;
		while (i < ilosc) {
			System.out.print ("Liczba do tablicy? ");
			tabl[i++] = czytajLiczbe ();
		}
		
		System.out.print ("Tablica PRZED sortowaniem:\n  ");
		piszTablice (tabl);
		System.out.println ();

		i = 0;
		while (i < ilosc) {
			a = tabl[i];
			assert a >= 0;
			assert a <= 10000;
			wt = new SleepSortWpisywacz (docel, a, a * 500);
			watki[i++] = wt;
			wt.start ();
		}
		System.out.print ("\nSortowanie...");
		i = 0;
		while (i < ilosc)
			watki[i++].join ();

		System.out.print ("\n\nTablica PO sortowaniu:\n  ");
		piszTablice (docel.tablica, docel.wypeln);
		System.out.println ();
	}
}
