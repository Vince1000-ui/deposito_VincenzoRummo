import java.util.ArrayList;
import java.util.Scanner;
public class EsercizioArreyList {
    public static void main(String[] args) {
        int FILE = 3;  // Numero di file della sala
        final int POSTI = 8; // Numero di posti per fila
        // Tre ArrayList per gestire le prenotazioni
        ArrayList<String> nomi = new ArrayList<>();
        ArrayList<Integer> righe = new ArrayList<>();
        ArrayList<Integer> colonne = new ArrayList<>();
        //creazione dello scanner e della variabile booleana
        Scanner obj = new Scanner(System.in);
        boolean running = true;
        // inizio ciclo per la scelta da attuare
        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Prenotare un posto");
            System.out.println("2. Cercare prenotazione per nome");
            System.out.println("3. Visualizzare i posti");
            System.out.println("4. Report prenotazioni");
            System.out.println("5. Esci");
            System.out.print("Scegli un'opzione: ");
            //chiedere all'utente cosa fare
            int scelta = obj.nextInt();
            obj.nextLine(); // Pulizia buffer
            switch (scelta) {
                case 1:
                    // Prenotare un posto
                    System.out.print("Inserisci il nome del cliente: ");
                    String nome = obj.nextLine();
                    System.out.print("Inserisci la riga (1-3): ");
                    int riga = obj.nextInt();
                    // Controllo validità dei dati riga
                    if (riga < 0 || riga >= FILE ) {
                        System.out.println("Errore: Posto non valido.");
                        break;
                    }
                    System.out.print("Inserisci la colonna (1-8): ");
                    int colonna = obj.nextInt();
                    obj.nextLine(); // Pulizia buffer
                    
                    //controllo colonne
                    if (colonna < 0 || colonna >= POSTI) {
                        System.out.println("Errore: Posto non valido.");
                        break;
                    }

                    // Controllo se il posto è già occupato
                    boolean occupato = false;
                    for (int i = 0; i < nomi.size(); i++) {
                        if (righe.get(i) == riga && colonne.get(i) == colonna) {
                            occupato = true;
                            break;
                        }
                    }

                    if (occupato) {
                        System.out.println("Errore: Posto già prenotato!");
                    } else {
                        nomi.add(nome);
                        righe.add(riga);
                        colonne.add(colonna);
                        System.out.println("Prenotazione confermata per " + nome+ " alla riga " + riga + " alla colonna " +colonna);
                    }
                    break;
                    case 2:
                    // Cercare una prenotazione per nome
                    System.out.print("Inserisci il nome da cercare: ");
                    String nomeCerca = obj.nextLine();
                    boolean trovata = false;

                    for (int i = 0; i < nomi.size(); i++) {
                        if (nomi.get(i).equalsIgnoreCase(nomeCerca)) {
                            System.out.println("Nome: " + nomi.get(i) + " - Posto: [" + righe.get(i) + ", " + colonne.get(i) + "]");
                            trovata = true;
                        }
                    }

                    if (!trovata) {
                        System.out.println("Nessuna prenotazione trovata per " + nomeCerca);
                    }
                    break;

    case 3:
                    // Mostra i posti prenotati direttamente dagli ArrayList
                    System.out.println("\nPosti prenotati:");
                    
                    if (nomi.isEmpty()) {
                        System.out.println("Nessuna prenotazione effettuata.");
                    } else {
                        for (int i = 0; i < nomi.size(); i++) {
                            System.out.println("Nome: " + nomi.get(i) + " - Posto: [" + righe.get(i) + ", " + colonne.get(i) + "]");
                        }
                    }
                    break;
case 4:
// Report delle prenotazioni
int totale = FILE * POSTI;
int prenotati = nomi.size();
System.out.println("Posti totali: " + totale);
System.out.println("Posti prenotati: " + prenotati);
System.out.println("Posti disponibili: " + (totale - prenotati));
break;

case 5:
running = false;
System.out.println("Chiusura del sistema...");
break;

default:
System.out.println("Scelta non valida, riprova.");
}
}

    }}