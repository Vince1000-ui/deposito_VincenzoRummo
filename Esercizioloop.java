import java.util.Scanner;
public class Esercizioloop {
    public static void main(String[] args) {
    Scanner obj = new Scanner(System.in);
     int[] giorni ={1,2,3,4,5,6,7};
     int num =0;
     for(int i =0; i<3; i++){
 System.out.println("dammi un numero da 1 a 7");
    num=obj.nextInt();
    
    switch(num) {
        case 1: System.out.println("il giorno del numero 1 lunedì");
      break;
      case 2: System.out.println("il numero 2 è martedì");
      break;
      case 3: System.out.println("il numero 3 è mercoledì");
      break;
      case 4: System.out.println("il numero 4 è giovedì");
      break;
      case 5: System.out.println("il numero 5 è venerdì");
      break;
      case 6: System.out.println("il numero 6 è sabato");
      break;
      case 7: System.out.println("il numero 7 è domenica");
      break;
}}}}