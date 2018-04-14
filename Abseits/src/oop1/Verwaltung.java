package oop1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Iterator;

public class Verwaltung {
	//Attribute
	private int abseits;
	ArrayList<Spieler> spieler = new ArrayList<Spieler>();
	private String regeln;
	private static Scanner scan = new Scanner (System.in);
	private int anzahlSpieler = 0;
	
	//Konstruktor
	public Verwaltung() {
		
		this.abseits = randomNum(30,50);
		this.regeln = "REGELN: ABSEITS \n"
				+ "Jeder Spieler würfelts hintereinander. Ziel des Spiels ist es, als Augensumme eine festgelegte Zahl (Abseits) nicht zu überschreiten.\n"
				+ "Die gewürfelten Augenzahlen werden auf die aktuelle Augensumme des Spielers addiert.\n"
				+ "Der Spieler der die Abseitszahl überschreitet scheidet aus und es beginnt eine neue Runde wobei die bisher erreichten Augensummen der Spieler auf 0 gesetzt werden.\n"
				+ "Der Spieler der als letztes übrig geblieben ist hat das Spiel gewonnen.\n";
		}
	
	/**
	 * Diese Methode ist für die Eingabe der Spieldaten verantwortlich bezüglich der Funktionen ob die Regeln angezeigt werden sollen, wieviele Spieler erzeugt werden sollen und wie diese heißen sollen.
	 */
    public void createGame(){
    	String in = "-";
        while (!in.equals("y") && !in.equals("n")){
            System.out.println("Regeln anzeigen? (y oder n)");
            in=scan.next();
            if (!in.equals("y")&!in.equals("n")) {
				System.out.println("Die Eingabe war fehlerhaft, bitte erneut eingeben!");
			}
        }
        if (in.equals("y")){
            printRegeln();
        }
        
        while(anzahlSpieler<2) {
        	try {
        		System.out.println("Bitte gib die Anzahl der Spieler ein (mindestens zwei Spieler).\n");
        		anzahlSpieler = scan.nextInt();
        	} 
        	catch(Exception e) {
        		scan = new Scanner (System.in);
        		System.out.println("Prüfe deine Eingabe! Die Eingabe muss eine Ganzzahl sein!");
        	}
        }
        System.out.println("Bitte gib die Namen der Mitspieler ein. \n(Name{Enter} Name{Enter} usw. \":q\"{Enter} beendet die Eingabe):");
        
        in="";
        while (spieler.size()<anzahlSpieler){
            in = scan.nextLine();
            if (in.equalsIgnoreCase(":q")){
                break;
            } //check if name already exists
            else if(checkNames(in)){
                System.out.println("Die Namen muessen eindeutig sein.");
            } //check if there is a digit
            else if(!in.isEmpty()){
                Spieler s = new Spieler(in);
            	spieler.add(s);
            }
        }

        
        System.out.println("Abseitszahl: "+ getAbseits());
    }
    
    public boolean checkNames(String s) {
    	boolean check = false;
    	for(Spieler tmp : spieler) {
    		if(tmp.getName().equals(s)) {
    			check = true;
    		}
    	}
    	return check;
    }
    
    public void spielen(){        
        createGame();
        System.out.println("Mit was für einen Würfel soll gespielt werden?");
        int number;
        number = scan.nextInt();
        Wuerfel wuerfel = new Wuerfel(number-1);
        
        while(spieler.size()>1) {
			for (Iterator<Spieler> iterator = spieler.iterator(); iterator.hasNext();) {
				Spieler tmp = iterator.next();
	        	
	        	if(tmp.getStatus()==true && spieler.size() > 1) {
	        	System.out.println("\nAbseitszahl beträgt: " +abseits);
	        	tmp.Spielzug(wuerfel);
	        	
	        	}
  
		        if(tmp.getAugensumme()>abseits) {
		    		System.out.println("Spieler "+tmp.getName()+" ist ausgeschieden!\n"
		    				+ "--------------------------------------------------\n"
		    				+ "Neue Runde beginnt, es bleiben noch " + anzahlSpieler + " Spieler");
		    		tmp.setStatus(false);
		    		iterator.remove();
		    	
		    		for(Spieler t : spieler) {
		    			t.setAugensumme(0);
		    		}
		        }
			}
        }
        beenden();
    }
    
    public void beenden() {
        System.out.println("\nSpiel beendet: Der Gewinner ist " + spieler.get(0).getName() +" !");
    }
    
    public void printRegeln(){
        System.out.println(this.regeln);  
      }
    
    public int getAbseits() {
    	return this.abseits;
    }
    
    /**
     * generiert eine Zufallszahl zwischen den Grenzen
     * @param min untere Grenze
     * @param max obere Grenze
     * @return Zufallszahl
     */
    public int randomNum(int min, int max){
    	int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    	return randomNum;
    }
}