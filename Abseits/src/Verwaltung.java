import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Iterator;

public class Verwaltung {
	private int abseits;
	ArrayList<Spieler> spieler = new ArrayList<Spieler>();
	private String regeln;
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
        
        
        
        in="";
        while (true){
            in = scan.nextLine();
            if (in.equalsIgnoreCase(":q")){
                break;
            } //check if name already exists
            /*else if(spieler.contains(scan)){
                System.out.println("Die Namen muessen eindeutig sein.");
            } *///check if there is a digit
            else if(!in.isEmpty()){
                Spieler s = new Spieler(in);
            	spieler.add(s);
            }
        }
        /*
        this.spieler = new Spieler[spieler.size()];
        for (int i=0; i<=spieler.size()-1;i++){
            this.spieler[i] = new Spieler(spieler.get(i));
        }
        */
        
        System.out.println("Abseitszahl: "+ getAbseits());
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
        	
        	//System.out.println("Spieler:"+ spieler[i].getName());
        	if(tmp.getStatus()==true && spieler.size() > 1) {
        	System.out.println("\nAbseitszahl beträgt:" +abseits);
        	tmp.Spielzug(wuerfel);
        	
        	}
        	//System.out.println(spieler.length);
        	

            if(tmp.getAugensumme()>abseits) {
        		System.out.println("Spieler "+tmp.getName()+" ist ausgeschieden!");
        		tmp.setStatus(false);
        		iterator.remove();
        		//System.out.println(spieler.size());
        		for(Spieler t : spieler) {
        			t.setAugensumme(0);
        		}
            }
        }
}

       /* 
        for(int i=0; i<spieler.length; i++) {
        	System.out.println("\nAbseitszahl beträgt:" +abseits);
        	//System.out.println("Spieler:"+ spieler[i].getName());
        	if(spieler[i].getStatus()==true) {
        	spieler[i].Spielzug(wuerfel);
        	}
        	//System.out.println(spieler.length);
        	

            if(spieler[i].getAugensumme()>abseits) {
        		System.out.println("Spieler "+spieler[i].getName()+" ist ausgeschieden! Es beginnt eine neue Runde.");
        		spieler[i].setStatus(false);
        		spieler = ArrayUtils.remove(spieler, i);
        		for(int k=0; k<spieler.length; k++) {
        			spieler[k].setAugensumme(0);
        		}
        	}
        	if(i==spieler.length-1) {
        		// -1 to get to index 0 (first player) increments i after each loop
        		i=-1;
        	}
        }
        */
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
    public int randomNum(int min, int max){
    	int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    	return randomNum;
    }
}