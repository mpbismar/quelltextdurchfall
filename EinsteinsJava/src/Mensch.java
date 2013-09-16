public class Mensch
{
	public static enum HOBBY {KLAVIERSPIELEN, SCHACHSPIELEN, FUSSBALLSPIELEN, HANDBALLSPIELEN};
	//public static enum ALTER {ELF,ZWOELF,DREIZEHN,VIERZEHN};
	public static enum WOHNORT {MAINZ, LEIPZIG, BERLIN, HAMBURG};
	public static enum NAME {DAVID, ALEXANDER, LUKAS, FLORIAN};
	
	NAME name;
	HOBBY hobby;
	int alter;
	WOHNORT ort;
	
	Mensch(NAME newName, int newAlter, WOHNORT newOrt, HOBBY newHobby)
	{
		this.name = newName;
		setAlter(newAlter);
		this.ort = newOrt;
		this.hobby = newHobby;
	}
	
	public void setName(NAME newname) 	{name = newname;}	
	public void setHobby(HOBBY newhobby) 	{hobby = newhobby;}	
	
	public void setAlter(int newAlter) 	
	{
		if (newAlter >= 11 && newAlter <= 14)
		{
			this.alter = newAlter;
		}
		else
		{
			throw new NegativeArraySizeException();
		}
	}
		
	public void setWohnort(WOHNORT newwohnort) 	{this.ort = newwohnort;}	
	
	public NAME getName() 	{return name;}	
	public HOBBY getHobby() 	{return hobby;}	
	public int getAlter() 	{return alter;}	
	public WOHNORT getWohnort() 	{return ort;}
	
	
	
	public void print()
	{
		System.out.println(name +" :   Hobby: "+hobby+", Alter: "+alter+", Wohnort: "+ort);
	}
		
}