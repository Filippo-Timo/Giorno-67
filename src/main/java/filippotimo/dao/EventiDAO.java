package filippotimo.dao;

import filippotimo.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventiDAO {
    // DAO (Data Access Object) è un Design Pattern. È una classe speciale che ci serve per interagire in maniera semplice con il DB.
    // Le operazioni normali come salvare o leggere dei record, richiedono l'uso dell'EntityManager con una certa complessità. Il DAO quindi
    // si occupa di nascondere questa complessità fornendo a chi ne avrà bisogno dei metodi semplici da usare

    // Innanzitutto dobbiamo avere qui nel DAO l'EntityManager per far si che il DAO possa fare tutte le operaioni
    // quindi creiamo l'attributo entityManager
    private EntityManager entityManager;

    // E qui creiamo il suo costruttore
    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {

        // step 1) Chiediamo all'entityManager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // step 2) Facciamo partire la transazione
        transaction.begin(); // (QUI INIZIA LA TRANSAZIONE)

        // step 3) Aggiungiamo il newEvento al PersistenceContext (in quanto esso è nuovo e non ancora MANAGED)
        // Lo si fa tramite il metodo .persist() dell'entityManager (qui l'oggetto non fa ancora parte del DB)
        entityManager.persist(newEvento);

        // step 4) Per far si che il nuovo oggetto entri nel DB dobbiamo fare il COMMIT
        transaction.commit(); // (QUI FINISCE LA TRANSAZIONE)

        // step 5 facoltativo) Facciamo un LOG (un messaggio in console) per vedere se il save è avvenuto correttamente
        System.out.println("L'evento con titolo " + newEvento.getTitolo() + " è stato salvato correttamente");
    }

    // public Evento findById(long eventoId) {}

    // public void findByIdAndDeleted(long eventoId) {}

}
