
package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import domain.Address;
import domain.Person;


public class HelloWorldClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		/*Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			Address address = new Address("200 E Main St2", "Seattle", "85123");
        			Person person = new Person("Ruby3", address);
        	
        			session.save(person);
	        
	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
        		*/
        		Person person = session.get(Person.class, 2L);
        		System.out.println("City : " + person.getAddress().getCity());
	
	}
}












