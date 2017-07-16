package hibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * Created by SO on 03.07.2017.
 */
public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            File file = new File("C:\\Users\\SO\\IdeaProjects\\PetProject\\Hibernate\\src\\main\\resources\\hibernate.cfg.xml");
            Configuration configuration = new Configuration();
            configuration.configure(file);

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void shutDown() {

        ourSessionFactory.close();
    }

}
