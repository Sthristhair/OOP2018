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
				+ "Jeder Spieler w�rfelts hintereinander. Ziel des Spiels ist es, als Augensumme eine festgelegte Zahl (Abseits) nicht zu �berschreiten.\n"
				+ "Die gew�rfelten Augenzahlen werden auf die aktuelle Augensumme des Spielers addiert.\n"
				+ "Der Spieler der die Abseitszahl �berschreitet scheidet aus und es beginnt eine neue Runde wobei die bisher erreichten Augensummen der Spieler auf 0 gesetzt werden.\n"
				+ "Der Spieler der als letztes �brig geblieben ist hat das Spiel gewonnen.\n";
		
	}
	
	/**
	 * Diese Methode ist f�r die Eingabe der Spieldaten verantwortlich bez�glich der Funktionen ob die Regeln angezeigt werden sollen, wieviele Spieler erzeugt werden sollen und wie diese hei�en sollen.
	 */
    public void createGame(){
    	String in = "-";
        while (!in.equals("y") && !in.equals("n")){
            System.out.println("Regeln anzeigen? (y oder n)");
            in=scan.next();
        }
        if (in.equals("y")){
            printRegeln();
        }
        
        while(anzahlSpieler<2) {
        try {
        System.out.println("Bitte gib die Anzahl der Spieler ein (mindestens zwei Spieler).\n");
        anzahlSpieler = scan.nextInt();
        } catch(Exception e) {
            scan = new Scanner (System.in);
            System.out.println("Pr�fe deine Eingabe! Die Eingabe muss eine Ganzzahl sein!");
        }
        }
        System.out.println("Bitte gib die Namen der Mitspieler ein. \n(Name{Enter} Name{Enter} usw. \":q\"{Enter} beendet die Eingabe):");
        
        
        
        in="";
        while (spieler.size()<anzahlSpieler){
            in = scan.nextLine();
            if (in.equalsIgnoreCase(":q")){
                break;
            } //checkt ob es den Spielernamen schon gibt
            else if(checkNames(in)){
                System.out.println("Die Namen muessen eindeutig sein.");
            } //checkt ob die Eingabe ein Zeichen beinhaltet
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
        System.out.println("Mit was f�r einen W�rfel soll gespielt werden?");
        int number;
        number = scan.nextInt();
        Wuerfel wuerfel = new Wuerfel(number-1);
        
        // > 1 weil der letzte Spieler (der noch im Spiel ist) der Gewinner ist
        while(spieler.size()>1) {
        // iteriere �ber die Liste der Spieler 	
		for (Iterator<Spieler> iterator = spieler.iterator(); iterator.hasNext();) {
			Spieler tmp = iterator.next();
        	// wenn der Spieler noch im Spiel ist && noch mehr als ein Spieler im Spiel ist dann darf gew�rfelt werden
        	if(tmp.getStatus()==true && spieler.size() > 1) {
        	System.out.println("\nAbseitszahl betr�gt:" +abseits);
        	tmp.Spielzug(wuerfel);
        	
        	}
  
        	
        	
            if(tmp.getAugensumme()>abseits) {
        		System.out.println("Spieler "+tmp.getName()+" ist ausgeschieden!");
        		tmp.setStatus(false);
        		//l�sche Spieler aus Liste wenn er die Abseitszahl �berschreitet
        		iterator.remove();
        		// setze alle Augensummen der anderen Spieler auf Null
        		for(Spieler t : spieler) {
        			t.setAugensumme(0);
        		}
            }
         }
        }

      
        beenden();
    }
    
    public void beenden() {
    	// gibt den letzten / einzigen Spieler der noch in der Liste ist aus
        System.out.println("\nSpiel beendet: Der Gewinner ist " + spieler.get(0).getName() +" !");
    }
    public void printRegeln(){
        System.out.println(this.regeln);  
      }
    public int getAbseits() {
    	return this.abseits;
    }
    public int randomNum(int min, int max){
    	int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    	return randomNum;
    }
}