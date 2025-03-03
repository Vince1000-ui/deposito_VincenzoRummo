import java.util.ArrayList;
import java.util.Scanner;

public class Totale_giocatori {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        // Creazione di un oggetto Squadra chiamato "Roma"
        Squadra Roma = new Squadra();

        // Ciclo per aggiungere 13 calciatori alla squadra (dovrebbe essere < 12 per 11 giocatori + 1 riserva)
        for (int i = 0; i < 12; i++) { 
            System.out.println("Inserisci nome calciatore:");
            String nome_cal = obj.nextLine();
            
            System.out.println("Inserisci ruolo calciatore:");
            String ruolo_cal = obj.nextLine();
            
            // Creazione dell'oggetto Calciatore con nome e ruolo
            Calciatore calciatore = new Calciatore(nome_cal, ruolo_cal);
            //aggiungere i canciatori allìarreylist
            Roma.squadra.add(calciatore);
        }
        // stampa dei calciatori
        System.out.println("Lista calciatori della squadra:");
        for (Calciatore calciatore : Roma.squadra) {
            System.out.println(calciatore.nome + " - " + calciatore.ruolo);
    }
    
    
}
class Calciatore{
String nome;
String ruolo;
Calciatore(String nome, String ruolo){
    this.nome=nome;
    this.ruolo=ruolo;
}}
class Squadra{
    ArrayList<Calciatore> squadra = new ArrayList<Calciatore>();
}



