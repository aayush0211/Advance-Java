package utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class HibernateUtils {
    private static SessionFactory factory;
    
    static {
    	System.out.println("connection pool ready");
    	factory = new Configuration().configure().buildSessionFactory();
    	
    }
    
    public static SessionFactory getSessionFactory() {
    	return factory;
    }
}
