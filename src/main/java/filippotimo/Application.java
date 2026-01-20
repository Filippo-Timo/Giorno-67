package filippotimo;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventipu");
    // Per connetterci al DB dobbiamo aggiungere al main un attributo statico di tipo EntityManagerFactory che sfrutterà
    // la Persistence Unit definita in persistence.xml per connettersi al DB (dobbiamo quindi passargli come parametro il nome della PU che in questo caso è "gestioneeventipu")

    // Se runnando la console esce scritto "Hello World!" allora la connsessione al server è andata a buon fine e posso committare e pushare la repo su github!!!

    public static void main(String[] args) {

        System.out.println("Hello World!");
    }
}
