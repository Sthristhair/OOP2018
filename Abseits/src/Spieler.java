
public class Spieler {
	
	//Attribute
	private String name;
	private int augensumme;
	private boolean status;
	
	//Konstruktor 
	public Spieler(String name, int augensumme) {
		this.name = name;
		this.augensumme = 0;
		this.status = true;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAugensumme() {
		return augensumme;
	}
	
}
