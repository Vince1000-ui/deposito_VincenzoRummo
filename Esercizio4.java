import java.util.Scanner;

public class Esercizio4 {
    public static void main(String[] args) {
        Scanner ogj = new Scanner(System.in);
        //printare un anno
        System.out.print("Inserisci un anno: ");
        int year = ogj.nextInt();
        //calcolo dell'anno
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("Anno bisestile");
        } else {
            System.out.println("Anno non bisestile");
        }
    }}
        
