public class Einsteinraetsel {

	/**
	 * @param args
	 */

	
	public static void main(String[] args) {


		Mensch David = new Mensch();
		David.setName(Mensch.NAME.DAVID);
		
		Mensch Alexander = new Mensch();
		Alexander.setName(NAME.ALEXANDER);
		
		Mensch Lukas = new Mensch();
		Lukas.setName(NAME.ALEXANDER);
		
		Mensch Florian= new Mensch();
		Florian.setName(NAME.FLORIAN);
		
		
		David.setWohnort(WOHNORT.BERLIN);
		Alexander.setWohnort(WOHNORT.LEIPZIG);
		Lukas.setWohnort(WOHNORT.HAMBURG);
		Alexander.setAlter(ALTER.ZWOELF);
		Lukas.setAlter(ALTER.DREIZEHN);
		Florian.setHobby(HOBBY.KLAVIERSPIELEN);
		

		
		
		
		
		
		
	}
	
	public void printAll () 
	{
		
	}
	
}
