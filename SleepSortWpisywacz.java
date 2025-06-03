/* Klasa watku, ktorego zadaniem jest dopisanie okreslonej jako parametr
liczby do okreslonego kontenera SleepSortDocelowa po uplywie okreslonego czasu
od startu watku. */
class SleepSortWpisywacz extends Thread
{
	private SleepSortDocelowa cel;
	private int dana, opozn;

	public SleepSortWpisywacz (SleepSortDocelowa cc,
		int dd, int oo)
	{
		assert cc != null;
		assert oo >= 0;
		cel = cc;
		dana = dd;
		opozn = oo;
	}

	public void run ()
	{
		try {
			Thread.sleep (opozn);
		} catch (InterruptedException iex) {}
		cel.dopisz (dana);
	}
}
