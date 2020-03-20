
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class TransactionManager {

    protected SessionFactory sessionFactory;

    protected void setup() {
        // pregatim sesiunea de hibernate

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }

    }

    protected void exit() {

        sessionFactory.close();
    }

    protected void createTransaction() {
        // asa arata

        Transactions transaction = new Transactions();
        transaction.setTransaction_number(1234);
        transaction.setValue(999);
        transaction.setDescription("book");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(transaction);

        session.getTransaction().commit();
        session.close();

    }

    protected void readTransaction() {

        // asa arata un read

        Session session = sessionFactory.openSession();

        long transactionID = 1;

        Transactions transaction = session.get(Transactions.class, transactionID);

        System.out.println("Number: " + transaction.getTransaction_number());
        System.out.println("Value: " + transaction.getValue());
        System.out.println("Description: " + transaction.getDescription());

        session.close();
    }

    protected void updateTransaction() {
        // asa ar trebui sa arate un update

        Transactions transaction = new Transactions();

        transaction.setValue(888);
        transaction.setDescription("almanah");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(transaction);

        session.getTransaction().commit();
        session.close();


    }

    protected void deleteTransaction() {

        //Asa ar trb sa arate un delete


        Transactions transaction = new Transactions();
        transaction.setID(1);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(transaction);

        session.getTransaction().commit();
        session.close();


    }

    public static void main(String[] args) {
        // de aici rulam aplicatia noastra

        TransactionManager manager = new TransactionManager();

        manager.setup();

        manager.createTransaction();

        manager.exit();
    }

}
