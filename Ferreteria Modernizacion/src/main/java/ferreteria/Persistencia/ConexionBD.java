package ferreteria.Persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConexionBD {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

            } catch (Exception ex) {
                System.err.println("Error al crear SessionFactory: " + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }
}