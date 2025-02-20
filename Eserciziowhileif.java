import java.util.Scanner;

public class Eserciziowhileif {
    public static void main(String[] args) {
     Scanner obj = new Scanner(System.in);
     int numero = 0;
     while (numero >= 0){
        numero= obj.nextInt();
        if(numero<0){System.out.println("hai terminato il ciclo");
    break;
}else if (numero%2==0){
            System.out.println("il numero "+ numero +" è positivo");

        }else {System.out.println("il numero "+ numero + " è negativo");}
     }
     System.out.println("sei uscito");
}

}