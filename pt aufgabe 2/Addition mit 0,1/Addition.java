
public class Addition {

	
	public static void main(String args[]) {

		double a = 0;
		double b = 0.1;

		for (int i = 0; i < 10; i++)
		{
			a = a + b;
		}
		
		if (a == 1.0)
		{
			System.out.println("a = " + a + " ;b = " + b);
		} else {
			System.out.println("a != 1.0	: a = " + a + " ;b = " + b);
		}
	}

}
