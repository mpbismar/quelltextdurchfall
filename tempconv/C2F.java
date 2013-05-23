
public class C2F {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length > 0)
		{
			
			double wert = Double.parseDouble(args[0]);
			Celsius zwischen = new Celsius();
			double ergebnis = zwischen.convert(wert);
			System.out.println(wert + " C = " + ergebnis + "F");
		}
		else
		{
			System.out.println("usage: java C2F + Gradzahl [cels] ");
		}
		
		
	}

}
