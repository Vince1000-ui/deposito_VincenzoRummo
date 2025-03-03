public class Blioteca {
    public static void main(String[] args) {
        Libro  Dune = new Libro("Frank Herbert",640);
        System.out.println("Il libro Dune è stato scritto da "+ Dune.nomeAutore + "pagine:" + Dune.nrPagine);
    }
    

}   
class Libro{
    String nomeAutore;
    int nrPagine;
    Libro(String nomeAutore, int nrPagine){
        this.nomeAutore=nomeAutore;
        this.nrPagine=nrPagine;
    }
}