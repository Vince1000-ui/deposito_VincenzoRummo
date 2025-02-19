import java.util.Scanner;

public class Esercizio5{

    public static void main(String[] args) {
        
        // qui creo gli scanner
        Scanner Scan_string = new Scanner(System.in);
        Scanner Scan_Num = new Scanner(System.in);
        int somma = 0;
        // inizio ciclo e boolenao di controllo
        boolean controllo = true;
        while (controllo) {

          System.out.println("inserisci un numero da sommare. Inserisci un numero negativo se vuoi terminare");

          int num = Scan_Num.nextInt();  
        //condizione per addizionare o femrare il ciclo
          if (num >0){
            somma = somma + num;
          } else {
        break;}
          }

          //stampa del risultato
        System.out.println("la somma dei numeri inseriti è " + somma);


          
        
        






        // qui chiudo gli scanner
        Scan_Num.close();
        Scan_string.close();
    }
}