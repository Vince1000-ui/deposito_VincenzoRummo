import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GestioneSpedizioni {

    // Lista delle spedizioni
    private static ArrayList<int[]> spedizioni = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    Random random = new Random();


    public static void main(String[] args) {
        boolean continua = true;

        while (continua) {
            mostraMenu();
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Pulizia buffer

            switch (scelta) {
                case 1:
                    aggiungiSpedizione();
                    break;
                case 2:
                    visualizzaSpedizioni();
                    break;
                case 3:
                    PenneperColore();
                    break;
                case 4:
                    RicercaColore();
                    break;
                case 5:
                    SpedizioneCasuale();
                    break;
                case 6:
                    continua = false;
                    System.out.println("Chiusura del programma...");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
    }

    // Metodo per visualizzare il menu
    private static void mostraMenu() {
        System.out.println("1. Aggiungere una spedizione");
        System.out.println("2. Visualizzare tutte le spedizioni");
        System.out.println("3. Calcolare il totale di penne per colore");
        System.out.println("4. Cercare spedizioni con un colore specifico");
        System.out.println("5. Generare spedizioni automatiche giornaliere");
        System.out.println("6. Esci");
        System.out.print("Scegli un'opzione: ");
    }

    // Metodo per aggiungere una spedizione
    private static void aggiungiSpedizione() {
        int[] nuovaSpedizione = new int[4]; // Indici: 0 = Rosso, 1 = Blu, 2 = Verde, 3 = Nero
        String[] colori = {"Rosso", "Blu", "Verde", "Nero"};

        // Richiesta delle quantità per ciascun colore
        for (int i = 0; i < 4; i++) {
            System.out.print("Inserisci la quantità di penne " + colori[i] + ": ");
            nuovaSpedizione[i] = scanner.nextInt();
        }

        // Aggiungi la spedizione alla lista
        spedizioni.add(nuovaSpedizione);
        System.out.println("Spedizione aggiunta con successo!");
    }

    // Metodo per visualizzare tutte le spedizioni
    private static void visualizzaSpedizioni() {

        if (spedizioni.isEmpty()) {
            System.out.println("Nessuna spedizione registrata.");
        } else {
            System.out.println("\n=== Elenco Spedizioni ===");
            int index = 1;
            for (int[] spedizione : spedizioni) {
                System.out.println("Spedizione #" + index++ + " -> Rosso: " + spedizione[0] +
                        ", Blu: " + spedizione[1] + ", Verde: " + spedizione[2] + ", Nero: " + spedizione[3]);
            }
        }
    }

    private static void PenneperColore(){
        int[] totali = new int[4]; // Totale per ogni colore

        for (int[] spedizione : spedizioni) {
            for (int i = 0; i < 4; i++) {
                totali[i] += spedizione[i];
            }
        }

        System.out.println("\n=== Totale Penne Spedite ===");
        System.out.println("Rosso: " + totali[0]);
        System.out.println("Blu: " + totali[1]);
        System.out.println("Verde: " + totali[2]);
        System.out.println("Nero: " + totali[3]);

    }
    public static void RicercaColore(){
        System.out.print("Inserisci il colore da cercare (Rosso, Blu, Verde, Nero): ");
        String coloreCercato = scanner.nextLine().toLowerCase();
        int coloreIndex = getColorIndex(coloreCercato);

        if (coloreIndex == -1) {
            System.out.println("Colore non valido.");
        } else {
            boolean trovato = false;
            for (int[] spedizione : spedizioni) {
                if (spedizione[coloreIndex] > 0) {
                    System.out.println("Spedizione trovata: Rosso: " + spedizione[0] +
                            ", Blu: " + spedizione[1] + ", Verde: " + spedizione[2] + ", Nero: " + spedizione[3]);
                    trovato = true;
                }
            }
            if (!trovato) {
                System.out.println("Nessuna spedizione contiene penne di colore " + coloreCercato);
            }
        }
    }
     // Metodo per ottenere l'indice di un colore
     public static int getColorIndex(String colore) {
        switch (colore) {
            case "rosso":
                return 0;
            case "blu":
                return 1;
            case "verde":
                return 2;
            case "nero":
                return 3;
            default:
                return -1; // Indica errore
        }
    }
    public static void SpedizioneCasuale(){
         // Genera una spedizione casuale
         Random random = new Random();

         int[] spedizioneCasuale = new int[4];
         for (int i = 0; i < 4; i++) {
             spedizioneCasuale[i] = random.nextInt(21); // Genera un numero casuale tra 0 e 20
         }
         spedizioni.add(spedizioneCasuale);
         System.out.println("Spedizione generata automaticamente!");
    }
}
