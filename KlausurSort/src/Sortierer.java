
public class Sortierer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		int [] a = new int [100];
		for (int i=0; i<100;i++ )
		{
			a[i] = (int)(Math.random() *100);
			
		}
		print(a);
		System.out.println();
//		BubbleSort.bubble(a);
		InsertionSort.insertion(a);
	}

	
	
	public static void print(int[] a)
	{
		for (int j=0; j <100; j++)
		{
			System.out.print(a[j]+ ", ");
			
		}
		System.out.println();
	}
	
	
}


