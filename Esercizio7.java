import java.util.Random;
import java.util.Scanner;

public class Esercizio7 {
    public static void main(String[] args) {
        // Genera un numero tra 1 e 100
    Random random = new Random();
        int numeroCasuale = random.nextInt(100) + 1; 
        
        // qui creo gli scanner
        Scanner Scan_string = new Scanner(System.in);
        Scanner Scan_Num = new Scanner(System.in);

        // inizio ciclo e boolenao di controllo
        System.out.println("E' stato generato un numero casuale, prova a indovinarlo");
        int numero= Scan_Num.nextInt();
        while (numeroCasuale != numero ) {

        //condizione if per vedere il numero corretto
          if (numero > numeroCasuale){
            System.out.println("troppo alto, prova di nuovo");
            numero= Scan_Num.nextInt();
          } else if (numero < numeroCasuale){
            System.out.println("troppo basso, prova di nuovo");
            numero= Scan_Num.nextInt();
        }else{break;}

        }

        System.out.println("Bravo, hai indovinato");




        // qui chiudo gli scanner
        Scan_Num.close();
        Scan_string.close();
    }
}

