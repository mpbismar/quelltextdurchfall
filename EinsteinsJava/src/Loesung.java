
/**
 * 
 * @author Karl & Paul
 * 
 * Enthaelt eine moegliche Loesung fuer das Raetsel, bestehend aus
 * vier Mensch-Objekten
 *
 */
public class Loesung {

	Mensch[] menschen;
	
	Loesung(Mensch m1, Mensch m2, Mensch m3, Mensch m4)
	{
		menschen = new Mensch[4];
		menschen[0] = m1;
		menschen[1] = m2;
		menschen[2] = m3;
		menschen[3] = m4;
	}
	
}
