
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class BuyerManager {

        protected SessionFactory sessionFactory;

        protected void setup() {
            // De aici pornim o sesiune de Hibernate


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
            // aici inchidem sesiunea de hibernate

            sessionFactory.close();
        }

        protected void create() {
            // aici vom crea un buyer (cumparator)

            Buyer buyer = new Buyer();

            buyer.setBuyername("Ion Ionescu");
            buyer.setValue(19191919);
            buyer.setDateRegistered(new java.util.Date());
            buyer.setBuyerPersonalIdentification("Ion Ionescu din Cluj");
            buyer.setTransactions(); // aici m-am incurcat, nu imi merge sa creez un buyer, pentru ca nu reusesc sa aduc date
                                     //Tabelul este facut corect
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(buyer);

            session.getTransaction().commit();
            session.close();
        }

        protected void read() {
            // citim un cumparator - am facut deja la transactions
        }

        protected void update() {
            // modificam un cumparator - vezi la transactions
        }

        protected void delete() {
            // stergem un cumparator - vezi la transactions
        }

        public static void main(String[] args) {

            //aici are loc executia programului

            BuyerManager manager = new BuyerManager();

            manager.setup();

            manager.create();

            manager.exit();
        }
    }

