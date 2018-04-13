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
	
	public String getName(){
		return name;
	}
	
	public int getAugensumme() {
		return augensumme;
	}
	
	public void Spielzug(Wuerfel wuerfel) {
		System.out.println(getName() + " ist am Zug.");
		
		System.out.println("Drücke {Enter} um zu wuerfeln.");
	
        scan.nextLine();
        int zahl = wuerfel.wuerfeln();
        System.out.println("Es ist eine " + zahl + "!" + " Deine Augensumme beträgt nun:" + addAugenzahl(zahl));
        
        
	}
	
	public int addAugenzahl(int zahl) {
		augensumme += zahl;
		return augensumme;
	}
}
