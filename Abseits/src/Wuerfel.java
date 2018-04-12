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
	
	//Methoden
	public int wuerfeln() {
		Random rand = new Random();
		
		int x = rand.nextInt(5) + 1;
		return x;
	}
}
