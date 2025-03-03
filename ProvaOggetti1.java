public class ProvaOggetti1 {
   public static void main(String[] args) {
     Auto auto = new Auto("Ferrari", "Rosso");
     // Utilizzo dei metodi della classe Auto
     System.out.println("Modello: " + auto.modello);
     System.out.println("Colore: " + auto.colore);
     auto.accelera(50);
     auto.accelera(20);
     auto.frena(30);
     auto.frena(50);

   }
}

class Auto{
    public String modello;
    public String colore;
    public int velocita;

     Auto(String modello, String colore){
        this.modello=modello;
        this.colore=colore;
        this.velocita=0;
    }
public void accelera(int incremento){
    velocita += incremento;
    System.out.println("lauto " + modello + " ha accelerato "+ velocita);
}
public void frena(int decremento){
    velocita-=decremento;
    if (velocita<0){
        velocita = 0;
    }
    System.out.println("l'auto " + modello + " ha frenato" + velocita);
}
}