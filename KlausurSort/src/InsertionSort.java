
public class InsertionSort {

	public static void insertion (int a[])
	{
		sortiere (a);
		Sortierer.print(a);
	}
	
	public static void sortiere(int[]a)
	{
		for(int i=1; i<=99; i++)
		{
			boolean getauscht = false;
			for (int j=0; j<i; j++)
			{
				if (a[i]<a[j])
				{
					tausche(a,i,j);
					getauscht = true;
				}
			}
			if(getauscht = false)break;
//			getauscht = false;
			Sortierer.print(a);
		}
	}
	
	
	
	
	public static void tausche(int[]a, int x, int y)
	{
		int depp = a[x];
		a[x] = a[y];
		a[y] = depp;
	}
}
