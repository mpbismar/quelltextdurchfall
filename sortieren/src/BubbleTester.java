import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;


public class BubbleTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		
		// Liste anlegen (als Arraylist, siehe Aufgabe1.txt
		
		// In diesem Fall vom Typ Integer
		
		List<Integer> unsorted = new ArrayList<Integer>();
		
		//int anzahl = getRandomInt();
		
		long s = System.nanoTime();
		int anzahl = 1000;
		
		debug("Fuelle Liste mit " + anzahl + " zufaelligen Zahlen...");
		
		for (int i=0; i<anzahl; i++)
		{
			int a = getRandomInt();
			unsorted.add(a);
			//debug("Habe hinzugefuegt [" + i + "]: " + a );
		}
		
		debug("Liste gefuellt. Sortiere...");
		
		List<Integer> sorted = Bubble.bubblesort(unsorted);
		s = System.nanoTime() -s;
		printList(sorted);
		debug("=============================");
		debug("Dauer(ms): " + (s/1000000) );
		

	}
	
	protected static int getRandomInt()
	{
		return (int)Math.floor(Math.random()*100000);
	}
	
	private static void debug(String msg)
	{
		System.out.println(msg);
	}
	
	private static void printList(List<Integer> liste)
	{
		int i = 0;
		for (int element: liste)
		{
			System.out.println("[" + i + "]: " + element);
			i++;
		}
	}

}
