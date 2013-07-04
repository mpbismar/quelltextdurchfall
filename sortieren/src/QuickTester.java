
public class QuickTester {


	public static void main(String[] args) {
		
		System.out.println("Lets go!");
		
		final int N = 100000;
		Integer[] random = new Integer[N];
		
		System.out.println("Fuelle Array: zufaellig");
		fillStupid(random);
		
		//System.out.println("Vorher:");
		//printArr(random);
		
		//System.out.println("Sortiere...");
		try
		{
			QuickSort.sortQuick(random);
			System.out.println("=========================================");
			System.out.println("Alles sortiert. Anzahl Iterationen: " + QuickSort.mileage);
		}
		catch(StackOverflowError S)
		{
			System.out.println("!!!!\nAbbruch wg Stack Overflow bei Rekursionsstiefe " + QuickSort.depth);
		}
		
		//System.out.println("Nachher: ");
		//printArr(random);
		
		
	}
	
	
	public static void fillRandom(Integer[] arr)
	{
		final int M = 10000000;
		
		for(int i = 0; i < arr.length; i++)
			arr[i] = (int)Math.floor(Math.random()*M);
	}
	
	public static void fillReverse(Integer[] arr)
	{
		int n = arr.length;
		for(int i = 0; i<n; i++ )
			arr[i] = n-i;
	}
	
	public static void fillStupid(Integer[] arr)
	{
		int n = arr.length;
		for(int i = 0; i<n; i++ )
			arr[i] = i;
	}

	public static void printArr(Integer[] blubb)
	{
		for(int i: blubb)
			System.out.println(i);
	}

}
