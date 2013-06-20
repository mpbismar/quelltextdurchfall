package de.uni_potsdam.hpi;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		laufzeitanalyse();

		}

		public static void laufzeitanalyse ()
		{
		DequeRing testRing = new DequeRing(1000);
		DequeList testList = new DequeList(1000);

		double time1 = java.lang.System.nanoTime();

		for (int i=1; i<=500; i++)
		{
		int e = i;
		try {
		testList.addFirst(e);
		//System.out.println("added: " + e);
		} catch (DequeFull e1) {
		e1.printStackTrace();
		}
		}
		double time2 = java.lang.System.nanoTime();
		System.out.println("runtime Liste mit 500 Elementen befuellt: "+ ((time2-time1)/1000000) + " ms");

		double time3 = java.lang.System.nanoTime();

		for (int i=1; i<=500; i++)
		{
		int e = i;
		try {
		testRing.addFirst(e);
		//System.out.println("added: " + e);
		} catch (DequeFull e1) {
		e1.printStackTrace();
		}
		}
		double time4 = java.lang.System.nanoTime();
		System.out.println("runtime Ring mit 500 Elementen befuellt: "+ ((time4-time3)/1000000) + " ms");
		System.out.println("");
		
		
		
		String leer = " ";
		
		double time5 = java.lang.System.nanoTime();
		for (int i=1; i<=500; i++)
		{
			if (i%2 == 1)
			{	
				 try {
				 testList.removeLast();
//				 System.out.println("removed:");
				 } catch (DequeEmpty e) {
				 e.printStackTrace();
				 }
			} 
			else
			{
				
				try {
					testList.addLast(leer);
//					System.out.println("added: ");
					} catch (DequeFull e1) {
					e1.printStackTrace();
					}
			}	
			
		}
		double time6 = java.lang.System.nanoTime();
		System.out.println("runtime je 250mal Element aus Liste entfernt und Leerstring hinzugefuegt : "+ ((time6-time5)/1000000) + " ms");

		double time7 = java.lang.System.nanoTime();
		for (int i=1; i<=500; i++)
		{
			if (i%2 == 1)
			{	
				 try {
				 testRing.removeLast();
//				 System.out.println("removed:");
				 } catch (DequeEmpty e) {
				 e.printStackTrace();
				 }
			} 
			else
			{
				
				try {
					testRing.addLast(leer);
//					System.out.println("added: ");
					} catch (DequeFull e1) {
					e1.printStackTrace();
					}
			}	
			
		}
		double time8 = java.lang.System.nanoTime();
		System.out.println("runtime je 250mal Element aus Ring entfernt und Leerstring hinzugefuegt : "+ ((time8-time7)/1000000) + " ms");
		
		System.out.println("test: Anzahl Ringelemente, Listenelemente: " + testRing.currentSize + "," + testList.currentSize);
		
		
	}
			
}
