import java.util.ArrayList;
import java.util.Scanner;

// Classe PiattoSpeciale con incapsulamento
class PiattoSpeciale {
    private static final double BASE_PREZZO = 1.0; // Prezzo fisso
    private ArrayList<String> ingredientiSelezionati;
    private String[] ingredientiDisponibili = {"Panino integrale","Panino bianco","Prosciutto","Polpette", "Zucchine", "Melanzane"};
    private double[] prezziIngredienti = {1.5,1.0,1.5,2.0, 1.5, 1.8};
    private int[] quantitaDisponibile = {3,2,6,5, 5, 5};

    // Costruttore
    public PiattoSpeciale() {
        this.ingredientiSelezionati = new ArrayList<>();
    }
    
    // Metodo per aggiungere un ingrediente se disponibile
    public boolean aggiungiIngrediente(String ingrediente) {
        for (int i = 0; i < ingredientiDisponibili.length; i++) {
            if (ingredientiDisponibili[i].equalsIgnoreCase(ingrediente) && quantitaDisponibile[i] > 0) {
                ingredientiSelezionati.add(ingredientiDisponibili[i]);
                quantitaDisponibile[i]--;
                return true;
            }
        }
        return false;
    }
    
    // Metodo per calcolare il prezzo totale del piatto
    public double calcolaPrezzo() {
        double totale = BASE_PREZZO;
        for (String ingrediente : ingredientiSelezionati) {
            for (int i = 0; i < ingredientiDisponibili.length; i++) {
                if (ingredientiDisponibili[i].equalsIgnoreCase(ingrediente)) {
                    totale += prezziIngredienti[i];
                }
            }
        }
        return totale;
    }
    
    // Metodo per mostrare gli ingredienti disponibili con quantità rimanente
    public void mostraIngredientiDisponibili() {
        System.out.println("Ingredienti disponibili con prezzi e quantità rimanente:");
        for (int i = 0; i < ingredientiDisponibili.length; i++) {
            System.out.println("- " + ingredientiDisponibili[i] + " (€" + prezziIngredienti[i] + ") Quantità: " + quantitaDisponibile[i]);
        }
    }
    
    // Metodo per mostrare il riepilogo del piatto
    public void mostraPiatto() {
        System.out.println("Piatto Speciale selezionato:");
        for (String ingrediente : ingredientiSelezionati) {
            for (int i = 0; i < ingredientiDisponibili.length; i++) {
                if (ingredientiDisponibili[i].equalsIgnoreCase(ingrediente)) {
                    System.out.println("- " + ingrediente + " (€" + prezziIngredienti[i] + ")");
                }
            }
        }
        System.out.println("Prezzo totale: €" + calcolaPrezzo());
    }
}

// Classe Menu per gestire gli ordini
class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        
        while (continua) {
            PiattoSpeciale piatto = new PiattoSpeciale();
            System.out.println("\nBenvenuto nel nostro menu!");
            piatto.mostraIngredientiDisponibili();
            
            // Selezione degli ingredienti controllando la disponibilità
            while (true) {
                System.out.print("Scegli un ingrediente (oppure digita 'fine' per completare l'ordine): ");
                String scelta = scanner.nextLine().trim().toLowerCase();
                
                if (scelta.equalsIgnoreCase("fine")) {
                    break;
                }
                
                boolean ingredienteAggiunto = false;
                while (!ingredienteAggiunto) {
                    if (piatto.aggiungiIngrediente(scelta)) {
                        ingredienteAggiunto = true;
                    } else {
                        System.out.println("Ingrediente non disponibile o esaurito. Inserisci un ingrediente valido:");
                        scelta = scanner.nextLine().trim().toLowerCase();
                    }
                }
            }
            
            // Mostrare il riepilogo
            piatto.mostraPiatto();
            
            // Chiedere se vuole ordinare di nuovo
            System.out.print("Vuoi ordinare ancora? (si/no): ");
            String risposta = scanner.nextLine().trim().toLowerCase();
            if (!risposta.equals("si")) {
                continua = false;
            }
        }
        scanner.close();
        System.out.println("Grazie per aver ordinato da noi!");
    }
}
