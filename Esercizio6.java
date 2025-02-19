import java.util.Scanner;

public class Esercizio6{

    public static void main(String[] args) {
        
        // qui creo gli scanner
        Scanner Scan_Num = new Scanner(System.in);
        System.out.println("dammi un numero");
        int numero = Scan_Num.nextInt();
        //creazione variabili necessarie
        int i = 0;
        int moltiplicatore = 0;
        // inizio ciclo per la moltiplicazione
        while (i <10) {
          i=i + 1;
            moltiplicatore = numero*i;
          System.out.println(numero +  "X" +  i + " è " + moltiplicatore);
          }
        
        }}