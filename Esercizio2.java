import java.util.Scanner;  // Import the Scanner class
class Esercizio2{
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        //inserire il numero
        System.out.println("Inserisci un numero positivo o negativo");
        int num = myObj.nextInt();
        if (num > 0){
            System.out.println("Il  numero è positivo");
        } else if (num < 0){
            System.out.println("Il numero è negativo");
        } else{System.out.println("il numero è zero");}
    }
}