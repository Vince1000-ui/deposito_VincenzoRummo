import java.util.Scanner;

public class Eserciziofor {
    public static void main(String[] args) {
        //creazione variabile e arrey vuoto
        Scanner obj = new Scanner(System.in);
       int[] numeri = {0,0,0};
       //ciclo while
       while(true){
        //creazione contatore oer uscire dal'ciclo
        int contatore = 0;

        for ( int i= 0; i<numeri.length;i++){
        System.out.println("inserisci un numero");
        numeri[i]= obj.nextInt();
        if (numeri[i]>100){
            contatore+=1;
            System.out.println("il numero è "+numeri[i]);
            
        }
    
        }
        if (contatore == 3){ break;}
       }
       obj.close();
    }}