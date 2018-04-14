import java.util.Scanner;

public class Spieler {
	
	//Attribute
	private String name;
	private int augensumme;
	private boolean status;
	private static Scanner scan = new Scanner (System.in);
	
	//Konstruktor 
	public Spieler(String name) {
		this.name = name;
		this.augensumme = 0;
		this.status = true;
	}
		
	/**
	 * Methode führt einen Spielzug durch, nachdem der Spieler ihn mit "Enter" beginnt
	 * @param wuerfel
	 */
	public void Spielzug(Wuerfel wuerfel) {
		System.out.println(getName() + " ist am Zug. Die aktuelle Augensumme von "+ getName() + " beträgt "+ getAugensumme() + " !");
		
		System.out.println("Drücke {Enter} um zu wuerfeln.");
	
        scan.nextLine(); 	//Beginnen eines neuen Spielzugs durch den Spieler
        int zahl = wuerfel.wuerfeln(); 
        System.out.println("Es ist eine " + zahl + "!" +" Die Augensumme von " + getName() + " beträgt nun: " + addAugenzahl(zahl));
	}
	
	public String getName(){
		return name;
	}
	
	public int getAugensumme() {
		return augensumme;
	}
	
	public void setAugensumme(int s) {
		augensumme = s;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean s) {
		this.status = s;
	}
	
	public int addAugenzahl(int zahl) {
		augensumme += zahl;
		return augensumme;
	}
}
