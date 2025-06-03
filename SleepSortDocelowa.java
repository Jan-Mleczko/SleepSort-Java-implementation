/* Klasa zbierajaca wyniki sortowania do tablicy w sposob chroniony przed
jednoczesnym zapisem przez wiele watkow (dzieki zastosowaniu kwalifikatora
synchronized dla metody dopisujacej). */
class SleepSortDocelowa
{
	public int tablica[];
	public int rozmiar, wypeln;

	public SleepSortDocelowa (int rr)
	{
		assert rr > 0;
		tablica = new int[rozmiar = rr];
		wypeln = 0;
	}

	public synchronized void dopisz (int a)
	{
		assert wypeln < rozmiar;
		tablica[wypeln++] = a;
	}
}
