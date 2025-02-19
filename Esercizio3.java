import java.util.Scanner;  // Import the Scanner class
public class Esercizio3 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  
   //inserire se maggiorenne o minorenne
   System.out.println("sei maggiorenne o minorenne");
   String maggiorenne = myObj.nextLine().trim().toLowerCase();;
   //if per maggiorenne o minorenne  
   if (maggiorenne.equals("maggiorenne")) {
    System.out.println("Sei maggiorenne");
} else if (maggiorenne.equals("minorenne")) {
    System.out.println("Sei minorenne");
} else {
    System.out.println("Input non riconosciuto.");
}

myObj.close();
}
}
