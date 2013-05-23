
public class F2C {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (args.length > 0)
		{
			double wert = Double.parseDouble(args[0]);
			Fahrenheit zwischen = new Fahrenheit ();
			double ergebnis = zwischen.convert(wert);
			System.out.println(wert + " F = " + ergebnis + "C");
		}
		else
		{
			System.out.println("usage: java F2C + Gradzahl [fahr.] ");
		}
	
	
	
	}

}
