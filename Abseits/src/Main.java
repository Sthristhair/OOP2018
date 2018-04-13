import java.util.Scanner;
public class Main {
	private static Scanner scan = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		//Andre ist viel cooler als Pauzii KappaPride
		Verwaltung spiel = new Verwaltung(4);
		
        while(true){
            spiel.spielen();
            System.out.println("\":quit\" um das Spiel zu beenden. Etwas anderes um fortzufahren.");
            if (scan.next().equals(":quit")) break;
        }
        System.out.println("Bye");
	}

}
