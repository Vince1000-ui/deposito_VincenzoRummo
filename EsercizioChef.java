import java.util.List;

public class EsercizioChef {
    public static void main(String[] args) {
        Chef chef1 = new Chef("Gordon Ramsay", "Italiano", "Pasta");
        Chef chef2 = new Chef("Massimo Bottura", "Giapponese", "Pesce");
        Chef chef3 = new Chef("Jamie Oliver", "Messicano", "Carne");

        System.out.println(chef1.preparaPiatto());
        System.out.println(chef2.preparaPiatto());
        System.out.println(chef3.preparaPiatto());
    }
}

class Chef {
    private String nome;
    private String tipo;
    private String ingrediente;

    public Chef(String nome, String tipo, String ingrediente) {
        this.nome = nome;
        this.tipo = tipo;
        this.ingrediente = ingrediente;
    }

    public String preparaPiatto() {
        String piatto;
        switch (ingrediente.toLowerCase()) {
            case "pasta":
                piatto = "Carbonara";
                break;
            case "pesce":
                piatto = "Sushi";
                break;
            case "carne":
                piatto = "Bistecca alla fiorentina";
                break;
            case "verdure":
                piatto = "Insalata mista";
                break;
            case "riso":
                piatto = "Risotto ai funghi";
                break;
            default:
                piatto = "Piatto non disponibile";
                break;
        }
        return nome + " ha preparato: " + piatto;
    }
}
