public class QuickSort
{
	
	public static int mileage = 0;
	public static int depth = 0;
	
	public static <T extends Comparable<? super T>> void sortQuick (T[] arr)
	{
		sortQuick(arr, 0, arr.length-1);
	}
	
	private static <T extends Comparable<? super T>> void sortQuick (T[] arr, int L, int R)
	{
		mileage++;
		depth++;
		
		
		if(L >= R ) 
			{
			depth--;
			return; // Listen kleiner gleich 1 sind sortiert
			}
		else
		{
			debug("Quicksort von " + L + " bis " + R + ", aktuelle Tiefe: " + depth);
			// pivot element finden und einsortieren
			int v = partition(arr, L, R);
			
			// links und rechts des pivot elementes wieder quicksorten
			sortQuick(arr, L, v-1);
			sortQuick(arr, v+1, R);		
			depth--;
		}
	}
	
	private static <T extends Comparable<? super T>> int partition (T[] arr, int L, int R)
	{
		// letztes element als pivot, wir untersuchen also alles links davon (im Bereich):
		T pivot = arr[R];
		
		// i und j hoeher weil direkt erstmal reduziert werden
		int i = L-1;
		int j = R;
		
		for(;;) // unendliche schleife, wird mittels break verlassen
		{
			while(kleiner(arr[++i], pivot)); // i erhoehen bis an position eines elements > pivot
			while(kleiner(pivot, arr[--j])) // j verringern ("nach links gehen"), bis element < pivot
			{	
				if (j==L) break; // abbruch, wenn dabei an linke Grenze gestossen weil Pivot kleinstes Element
			}
			
			if (i>=j) break; // fertig, wenn pointer sich begegnen
			else swap(arr, i, j); // sonst elemente tauschen und weiter			
		}
		swap(arr, i, R); // R position des pivot elements		
		return i; // gib jetztige position des pivot elements zurueck
	}
	
	private static <T extends Comparable<? super T>> boolean kleiner(T a, T b)
	{
		return (a.compareTo(b) < 0);
	}
	
	private static <T extends Comparable<? super T>> void swap(T[] arr, int a, int b)
	{
		T tmp = arr[b];
		arr[b] = arr[a];
		arr[a] = tmp;
	}
	
	private static void debug(String msg)
	{
		System.out.println(msg);
	}
}
