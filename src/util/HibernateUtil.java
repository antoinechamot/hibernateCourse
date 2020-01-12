
package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {        	
        	// Create the SessionFactory from hibernate.cfg.xml
        	//Configuration configuration = new Configuration().configure("hibernate.cfg.xml");     
            //return configuration.buildSessionFactory( new StandardServiceRegistryBuilder().applySettings( configuration.getProperties() ).build() );
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
        		    configure().loadProperties("hibernate.cfg.xml").build();
        		return new Configuration().buildSessionFactory(serviceRegistry);  
        
        
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	
}







