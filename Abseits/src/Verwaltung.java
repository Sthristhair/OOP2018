import java.util.Random;
import java.util.Scanner;

public class Verwaltung {
	private int abseits;
	private Spieler[] spieler;
	private String regeln;
	private int dran;
	private int Spieleranzahl;
	private static Scanner scan = new Scanner (System.in);
	
	public Verwaltung( int Spieleranzahl ) {
		this.Spieleranzahl = Spieleranzahl;
		//((max-min)+1)+min
		//generate random integer between 100 and 999
		this.abseits = new Random().nextInt(((50-30)+1)+30);
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
    }
    public void spielen(){        
        createGame();
        Wuerfel wuerfel1 = new Wuerfel(5);

    }
    
    public void beenden() {
        System.out.println("Spiel beendet");
    }
    public void printRegeln(){
        System.out.println(this.regeln);  
      }
}