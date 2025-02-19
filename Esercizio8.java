import java.util.Scanner;

public class Esercizio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Un solo Scanner per tutto il programma

        String nome;
        int password;
        int eta;

        // Ciclo per ottenere dati validi
        while (true) {
            System.out.println("Dammi il nome:");
            nome = scanner.nextLine().trim(); // Rimuove eventuali spazi inutili

            if (nome.isEmpty()) { // Controlla se il nome è vuoto
                System.out.println("Errore: il nome non può essere vuoto.");
                continue; // Ritorna all'inizio del ciclo
            }

            System.out.println("Inserisci una password numerica:");
            while (!scanner.hasNextInt()) { // Controlla che sia un numero
                System.out.println("Errore: Inserisci un numero valido per la password!");
                scanner.next(); // Scarta l'input errato
            }
            password = scanner.nextInt();

            if (password == 0) { // Controlla che la password non sia 0
                System.out.println("Errore: la password non può essere 0.");
                scanner.nextLine(); // Pulisce il buffer
                continue; // Ritorna all'inizio del ciclo
            }

            System.out.println("Inserisci la tua età:");
            while (!scanner.hasNextInt()) {
                System.out.println("Errore: Inserisci un numero valido per l'età!");
                scanner.next(); // Scarta l'input errato
            }
            eta = scanner.nextInt();
            scanner.nextLine(); // Pulisce il buffer dopo nextInt()

            if (eta <= 0) { // Controlla che l'età sia valida
                System.out.println("Errore: l'età deve essere maggiore di 0.");
                continue; // Ritorna all'inizio del ciclo
            }

            // Se tutti i dati sono validi, esce dal ciclo
            break;
        }

    


        // Verifica con massimo 3 tentativi
        for (int i = 0; i < 3; i++) {
            System.out.println("\nReinserisci i dati per la verifica:");
            System.out.println("Nome:");
            String nome1 = scanner.nextLine();
            
            System.out.println("Password numerica:");
            int password1 = scanner.nextInt();
            
            System.out.println("Età:");
            int eta1 = scanner.nextInt();
            scanner.nextLine(); // Pulisce il buffer

            // Controllo dei dati
            if (nome.equals(nome1) && password == password1 && eta == eta1) {
                System.out.println("Bravo, hai inserito tutto correttamente!");
                scanner.close(); // Chiude lo scanner prima di terminare
                return;
            } else {
                System.out.println("Dati errati. Tentativo " + (i + 1) + " di 3.");
            }
        }

        System.out.println("\nTroppi tentativi. Accesso negato.");
        scanner.close();
    }
}
