import java.util.List;


public class Bubble {


	
	public static List<Integer> bubblesort(List<Integer> l)
	{
		// bla
		int length = l.size();
		
		
		//int apfelmus = l.get(3);
		
		// aeussere schleife - ein von rechts immer kleiner werdender bereich wird untersucht
		for (int i = length-1; i>=0; i--)
		{
			boolean swapped = false;
			System.out.println("[BubbleSort] Sortiere... noch " + i);
			
			// innere schleife - von links nach rechts 2 elemente vergleichen und ggf. nach rechts schieben
			for (int j = 0; j<i; j++)
			{
				
				
				
				int a = l.get(j);
				int b = l.get(j+1);
				
				if(groesser(a,b))
				{
					l.set(j+1, a);
					l.set(j, b);
					swapped = true;
				}
			}
			
			// falls einen ganzen durchlauf nicht getauscht wird koennen wir aufhoeren!
			if (swapped==false)
				break; 
		}
		return l;
	}
	
	public static boolean groesser(int a, int b)
	{
		return (a>b);
	}
	
	

}
