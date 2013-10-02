
public class BubbleSort {

	public static void bubble (int[] a)
	{
		sortiere(a);
		Sortierer.print(a);
	}
	
	
	
	
	public static void sortiere(int[] a)
	{
		for (int b=0; b<=99; b++)
		{
			boolean getauscht=false;
			
			for (int i=99; i>b; i--)
			{
				if (a[i]<a[i-1])
				{
					tausche(a,i,i-1);
					getauscht = true;
				}			
				if(getauscht = false)break;
			}
			if(getauscht = false)break;
			getauscht = false;
				
			
			
			
		}	
	}
	
	
	public static void tausche(int[]a, int x, int y)
	{
		int depp = a[x];
		a[x] = a[y];
		a[y] = depp;
	}
}
