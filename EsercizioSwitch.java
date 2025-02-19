import java.util.Scanner;  // Import the Scanner class
public class EsercizioSwitch {
    
        public static void main(String[] args) {
            Scanner myObj = new Scanner(System.in);
            Scanner myobgint= new Scanner(System.in); 
            //andiamo a chiedere le informazioni
            System.out.println("dammi il tuo nome");
            String nome = myObj.nextLine();
            System.out.println("dammi il tuo cognome");
            String cognome = myObj.nextLine();
            System.out.println("dammi la password numerica");
            int pass = myobgint.nextInt();
            //chiediamo cosa vuole modificare
            System.out.println("vuoi modificare 1. nome, 2. cognome, 2.password?");
            int scelta = myobgint.nextInt();
            switch (scelta) {
                case 1: nome = myObj.nextLine();
                break;
                case 2: cognome = myObj.nextLine();
                case 3: pass = myobgint.nextInt();
                default: System.out.println("hai sbagliato numero");
}
System.out.println("il nome è "+ nome + ", il congome è " + cognome + ", la password è "+ pass);
}
}
