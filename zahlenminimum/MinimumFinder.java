public class MinimumFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//In myIn = new In();
		System.out.println("Usage: beliebig viele ganze Zahlen eingeben, Ende mit negativer Zahl!");
		In.init();
		
		int minimum = 0;
		int aktuell = 0;
		int count = 0;
		
		do
		{
			aktuell = In.getInt();
			
			if(((aktuell < minimum) && (aktuell > 0)) || count == 0)
			{
				minimum = aktuell;
			}
			count++;
		}
		while(aktuell >= 0);
		
		if(count == 1)
		{
			System.out.println("Keine Eingabe - kein Minimum!");
		}
		else
		{
			System.out.print("Minimum: ");
			System.out.println(minimum);
		}
	}

}
