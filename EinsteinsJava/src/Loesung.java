
/**
 * 
 * @author Karl Wolf & Paul Wille
 * 
 * Enthaelt eine moegliche Loesung fuer das Raetsel, bestehend aus
 * vier Mensch-Objekten
 *
 */


public class Loesung {

	Mensch[] menschen;
	
	Loesung(Mensch m0, Mensch m1, Mensch m2, Mensch m3)
	{
		menschen = new Mensch[4];
		menschen[0] = m0;
		menschen[1] = m1;
		menschen[2] = m2;
		menschen[3] = m3;
	}
	
	public void print ()
	{
		int a;
		System.out.println("Loesung :");
		for (a=0; a < menschen.length; a++)
		{
			menschen[a].print();
		}
		System.out.println();
	}
	public static void printLoesungen(Loesung[] loesung, int counter)
	{
		int a=0;
		int b=0;
		for (a=0 ; a < counter ; a++)
		{
			for (b=0; b < loesung[a].menschen.length ; b++)
			{
				loesung[a].menschen[b].print();
			}
			System.out.println();
		}
		System.out.println(counter + " Loesungen gefunden:");
	}
	

	//TODO catch exception, if Mensch with asked alter does not exist
	public Mensch getMenschByAlter (int alter, Mensch[] menschen)
	{
		int n = 0;
		for (n=0 ; n < menschen.length ; n++)
		{
			if (menschen[n].alter == alter)
			{
				return menschen[n];
			}
			
		}
		return null;
	}
	
	
	//TODO catch exception, if Mensch with asked ort does not exist
	public Mensch getMenschByOrt (Mensch.WOHNORT ort, Mensch[] menschen)
	{
		int n = 0;
		for (n=0 ; n < menschen.length ; n++)
		{
			if (menschen[n].ort == ort)
			{
				return menschen[n];
			}
			
		}
		return null;
	}


	//TODO catch exception, if Hobby with asked hobby does not exist
	public Mensch getMenschByHobby (Mensch.HOBBY hobby, Mensch[] menschen)
	{
		int n = 0;
		for (n=0 ; n < menschen.length ; n++)
		{
			if (menschen[n].hobby == hobby)
			{
				return menschen[n];
			}
			
		}
		return null;
	}
	
	
	//TODO catch exception, if Mensch with asked name does not exist
	public Mensch getMenschByName (Mensch.NAME name, Mensch[] menschen)
	{
		int n = 0;
		for (n=0 ; n < menschen.length ; n++)
		{
			if (menschen[n].name == name)
			{
				return menschen[n];
			}
			
		}
		return null;
	}

}
