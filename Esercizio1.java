import java.util.Scanner;  // Import the Scanner class
class Esercizio1{
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        //inserire il primo numero
        System.out.println("Inserisci il primo numero");
        int num1 = myObj.nextInt();
        //inserire il secondo numero
        System.out.println("Inserisci il secondo numero");
        int num2 = myObj.nextInt();
        if (num1 > num2){
            System.out.println("Il primo numero è maggiore del secondo");
        } else if (num1 < num2){
            System.out.println("Il secondo numero è maggiore del primo");
        } else{System.out.println("i numeri sono uguali");}

    }
}