import java.util.Random;

public class Wuerfel 
{
	//Attribute
	private int augenzahl;
	
	//Konstruktor
	public Wuerfel(int augenzahl)
	{
		this.augenzahl = augenzahl;
	}
	
	/*
	 * Methode, die einen Wurf des W�rfels simuliert 
	 * @return - Zufallszahl des W�rfels
	 */
	public int wuerfeln() {
		Random rand = new Random();
		
		int x = rand.nextInt(this.augenzahl) + 1;
		return x;
	}
}
