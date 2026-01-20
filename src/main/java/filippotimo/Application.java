package filippotimo;

import filippotimo.entities.Evento;
import filippotimo.entities.tipoEvento;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventipu");
    // Per connetterci al DB dobbiamo aggiungere al main un attributo statico di tipo EntityManagerFactory che sfrutterà
    // la Persistence Unit definita in persistence.xml per connettersi al DB (dobbiamo quindi passargli come parametro il nome della PU che in questo caso è "gestioneeventipu")

    // Se runnando la console esce scritto "Hello World!" allora la connsessione al server è andata a buon fine e posso committare e pushare la repo su github!!!

    public static void main(String[] args) {

        Evento primoEvento = new Evento("Pupo in concerto", LocalDate.of(2025, 12, 6), "Imperdibile il concerto di pupo", tipoEvento.Pubblico, 5000);
        Evento secondoEvento = new Evento("Inter vs Milan", LocalDate.of(2025, 4, 13), "Il derby di Milano", tipoEvento.Pubblico, 75000);
        Evento terzoEvento = new Evento("Compleanno Pupo", LocalDate.of(2025, 11, 27), "Il compleanno più atteso dell'anno", tipoEvento.Privato, 300);
        System.out.println(primoEvento);
        System.out.println(secondoEvento);
        System.out.println(terzoEvento);
    }
}
