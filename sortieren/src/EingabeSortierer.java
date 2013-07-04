import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class EingabeSortierer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("usage: Parameter eingeben und mit Enter bestaetigen !");
		System.out.println("usage: Beenden durch Leere Zeile  !");

		
        List<String> eingaben = new ArrayList<String>();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String input;
        
        try {
			while ( ((input = buff.readLine()) != null) && !(( input.equals("") )) ) {
			    eingaben.add(input);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		System.out.println(" Ende der Eingabe");
		System.out.println(" Sortiere Liste...");
		
		List<String> sorted = Bubble.bubblesort(eingaben);
		System.out.println("");
		System.out.println("======================== Sortierte Liste:  =========================");

		printList(sorted);

        
        
        
        
	}
	
	private static void printList(List<String> liste)
	{
		int i = 0;
		for (String element: liste)
		{
			System.out.println("[" + i + "]: " + element);
			i++;
		}
	}

}
