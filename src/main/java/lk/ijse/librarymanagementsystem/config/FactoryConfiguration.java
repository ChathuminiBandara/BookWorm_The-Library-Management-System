package lk.ijse.librarymanagementsystem.config;

import lk.ijse.librarymanagementsystem.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Admin.class).addAnnotatedClass(User.class).addAnnotatedClass(Book.class).addAnnotatedClass(BorrowingDetails.class).addAnnotatedClass(Branches.class);
        sessionFactory = configuration.buildSessionFactory();
    }
     public static FactoryConfiguration getFactoryConfiguration(){
         return factoryConfiguration==null ? factoryConfiguration=new FactoryConfiguration() : factoryConfiguration;

     }
     public Session getSession(){
        return sessionFactory.openSession();
     }
}
