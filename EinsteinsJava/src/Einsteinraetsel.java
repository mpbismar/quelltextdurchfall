
public class Einsteinraetsel {

	/**
	 * @param args
	 */

	public static enum HOBBY {KLAVIERSPIELEN, SCHACHSPIELEN, FUSSBALLSPIELEN, HANDBALLSPIELEN};
	public static enum ALTER {ELF,ZWOELF,DREIZEHN,VIERZEHN};
	public static enum WOHNORT {MAINZ, LEIPZIG, BERLIN, HAMBURG};
	public static enum NAME {DAVID, ALEXANDER, LUKAS, FLORIAN};
	
	
	
	public class Mensch
	{
		NAME name;
		HOBBY hobby;
		ALTER alter;
		WOHNORT wohnort;
		
		public void setName(NAME newname) 	{name = newname;}	
		public void setHobby(HOBBY newhobby) 	{hobby = newhobby;}	
		public void setAlter(ALTER newalter) 	{alter = newalter;}	
		public void setWohnort(WOHNORT newwohnort) 	{wohnort = newwohnort;}	
		
		public NAME getName() 	{return name;}	
		public HOBBY getHobby() 	{return hobby;}	
		public ALTER getAlter() 	{return alter;}	
		public WOHNORT getWohnort() 	{return wohnort;}
		
		
		public void print()
		{
			System.out.println(name +" :   Hobby: "+hobby+", Alter: "+alter+", Wohnort: "+wohnort);
		}
		
	}
	
	
	
	public static void main(String[] args) {


		Mensch David = new Mensch();
		David.setName(NAME.DAVID);
		
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
