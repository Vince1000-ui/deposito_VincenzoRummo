import java.util.ArrayList;
import java.util.Scanner;

// Classe Film
class Film {
    private String titolo;
    private int anno;

    // Costruttore
    public Film(String titolo, int anno) {
        this.titolo = titolo;
        this.anno = anno;
    }

    // Getter per il titolo
    public String getTitolo() {
        return titolo;
    }

    // Getter per l'anno di uscita
    public int getAnno() {
        return anno;
    }

    // Metodo toString per rappresentare il film
    @Override
    public String toString() {
        return titolo + " (" + anno + ")";
    }
}

// Classe Utente
class Utente {
    private static int idCounter = 1; // Contatore statico per ID univoci
    private int idUtente;
    private String nome;
    private ArrayList<Film> filmNoleggiati;
    private static final int LIMITE_NOLEGGI = 3;

    // Costruttore
    public Utente(String nome) {
        this.idUtente = idCounter++;
        this.nome = nome;
        this.filmNoleggiati = new ArrayList<>();
    }

    // Metodo per noleggiare un film
    public void noleggiaFilm(Film film) {
        if (filmNoleggiati.size() < LIMITE_NOLEGGI) {
            filmNoleggiati.add(film);
            System.out.println(nome + " ha noleggiato " + film);
        } else {
            System.out.println("Limite di noleggio raggiunto per " + nome);
        }
    }

    // Metodo per stampare l'elenco dei film noleggiati
    public void elencoNoleggi() {
        System.out.println("Film noleggiati da " + nome + ":");
        for (Film film : filmNoleggiati) {
            System.out.println("- " + film);
        }
    }

    // Getter per il nome dell'utente
    public String getNome() {
        return nome;
    }

    // Getter per l'ID dell'utente
    public int getIdUtente() {
        return idUtente;
    }

    // Getter per i film noleggiati
    public ArrayList<Film> getFilmNoleggiati() {
        return filmNoleggiati;
    }
}

// Classe Videoteca per gestire i film e gli utenti
class Videoteca {
    private ArrayList<Film> collezione;
    private ArrayList<Utente> utenti;

    // Costruttore
    public Videoteca() {
        this.collezione = new ArrayList<>();
        this.utenti = new ArrayList<>();
    }

    // Metodo per aggiungere un film alla videoteca
    public void aggiungiFilm(Film film) {
        collezione.add(film);
        System.out.println(film + " aggiunto alla videoteca.");
    }

    // Metodo per registrare un nuovo utente
    public void registraUtente(Utente utente) {
        utenti.add(utente);
        System.out.println("Utente " + utente.getNome() + " (ID: " + utente.getIdUtente() + ") registrato.");
    }

    // Metodo per cercare un film per titolo
    public Film cercaFilm(String titolo) {
        for (Film film : collezione) {
            if (film.getTitolo().equalsIgnoreCase(titolo)) {
                return film;
            }
        }
        return null;
    }

    // Metodo per cercare un utente per nome
    public Utente cercaUtente(String nome) {
        for (Utente utente : utenti) {
            if (utente.getNome().equalsIgnoreCase(nome)) {
                return utente;
            }
        }
        return null;
    }

    // Metodo per visualizzare i film disponibili
    public void mostraFilmDisponibili() {
        if (collezione.isEmpty()) {
            System.out.println("Nessun film disponibile nella videoteca.");
        } else {
            System.out.println("Film disponibili nella videoteca:");
            for (Film film : collezione) {
                System.out.println("- " + film);
            }
        }
    }

    // Metodo per visualizzare i film noleggiati e da chi
    public void mostraFilmNoleggiati() {
        boolean noleggiEsistenti = false;
        for (Utente utente : utenti) {
            if (!utente.getFilmNoleggiati().isEmpty()) {
                System.out.println("Film noleggiati da " + utente.getNome() + ":");
                for (Film film : utente.getFilmNoleggiati()) {
                    System.out.println("- " + film);
                }
                noleggiEsistenti = true;
            }
        }
        if (!noleggiEsistenti) {
            System.out.println("Nessun film è stato noleggiato.");
        }
    }
}

// Classe principale con metodo per gestire il menu
public class GestioneVideoteca {
    public static void main(String[] args) {
        Videoteca videoteca = new Videoteca();
        Scanner scanner = new Scanner(System.in);
        mostraMenu(videoteca, scanner);
        scanner.close();
    }

    // Metodo per mostrare il menu e gestire le operazioni
    public static void mostraMenu(Videoteca videoteca, Scanner scanner) {
        int scelta;
        do {
            System.out.println("\n--- Menu Videoteca ---");
            System.out.println("1. Aggiungi utente");
            System.out.println("2. Aggiungi film alla videoteca");
            System.out.println("3. Noleggia film");
            System.out.println("4. Mostra film disponibili");
            System.out.println("5. Mostra film noleggiati e da chi");
            System.out.println("6. Esci");
            System.out.print("Scegli un'opzione: ");
            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci nome utente: ");
                    String nomeUtente = scanner.nextLine();
                    videoteca.registraUtente(new Utente(nomeUtente));
                    break;
                case 2:
                    System.out.print("Inserisci titolo del film: ");
                    String titoloFilm = scanner.nextLine();
                    System.out.print("Inserisci anno di uscita: ");
                    int annoFilm = scanner.nextInt();
                    scanner.nextLine();
                    videoteca.aggiungiFilm(new Film(titoloFilm, annoFilm));
                    break;
                case 3:
                    System.out.print("Inserisci nome utente: ");
                    String nomeNoleggio = scanner.nextLine();
                    Utente utente = videoteca.cercaUtente(nomeNoleggio);
                    if (utente != null) {
                        System.out.print("Inserisci titolo del film da noleggiare: ");
                        String titoloNoleggio = scanner.nextLine();
                        Film film = videoteca.cercaFilm(titoloNoleggio);
                        if (film != null) {
                            utente.noleggiaFilm(film);
                        } else {
                            System.out.println("Film non trovato.");
                        }
                    } else {
                        System.out.println("Utente non trovato.");
                    }
                    break;
                case 4:
                    videoteca.mostraFilmDisponibili();
                    break;
                case 5:
                    videoteca.mostraFilmNoleggiati();
                    break;
                case 6:
                    System.out.println("Uscita dal sistema.");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        } while (scelta != 6);
    }
}
