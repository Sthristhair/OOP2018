import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Verwaltung {
	private int abseits;
	private Spieler[] spieler;
	private String regeln;
	private int dran;
	private static Scanner scan = new Scanner (System.in);
	
	public Verwaltung() {
		
		this.abseits = randomNum(30,50);
		this.regeln = "REGELN: ABSEITS \n"
				+ "Jeder Spieler würfelts hintereinander. Ziel des Spiels ist es, als Augensumme eine festgelegte Zahl (Abseits) nicht zu überschreiten.\n"
				+ "Die gewürfelten Augenzahlen werden auf die aktuelle Augensumme des Spielers addiert.\n"
				+ "Der Spieler der die Abseitszahl überschreitet scheidet aus und es beginnt eine neue Runde wobei die bisher erreichten Augensummen der Spieler auf 0 gesetzt werden.\n"
				+ "Der Spieler der als letztes übrig geblieben ist hat das Spiel gewonnen.\n";
		
	}
	
    public void createGame(){
        String in = "-";
        while (!in.equals("y") && !in.equals("n")){
            System.out.println("Regeln anzeigen? (y oder n)");
            in=scan.next();
        }
        if (in.equals("y")){
            printRegeln();
        }
        
        System.out.println("Bitte gib die Namen der Mitspieler ein. \n(Name{Enter} Name{Enter} usw. \":q\"{Enter} beendet die Eingabe):");
        
        ArrayList<String> spieler = new ArrayList<String>();
        in="";
        while (true){
            in = scan.nextLine();
            if (in.equalsIgnoreCase(":q")){
                break;
            } //check if name already exists
            else if(spieler.contains(in)){
                System.out.println("Die Namen muessen eindeutig sein.");
            } //check if there is a digit
            else if(!in.isEmpty()){
                spieler.add(in);
            }
        }
        
        this.spieler = new Spieler[spieler.size()];
        for (int i=0; i<=spieler.size()-1;i++){
            this.spieler[i] = new Spieler(spieler.get(i));
        }
        
        System.out.println("Abseitszahl: "+ getAbseits());
    }
    
    public void spielen(){        
        createGame();
        System.out.println("Mit was für einen Würfel soll gespielt werden?");
        int number;
        number = scan.nextInt();
        Wuerfel wuerfel = new Wuerfel(number-1);
        
        for(int i=0; i<spieler.length-1; i++) {
        	//System.out.println("Spieler:"+ spieler[i].getName());
        	spieler[i].Spielzug(wuerfel);
        }
        
        beenden();
    }
    
    public void beenden() {
        System.out.println("Spiel beendet");
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