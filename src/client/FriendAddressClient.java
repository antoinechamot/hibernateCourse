package client;

import org.hibernate.Session;

import util.HibernateUtil;
import domain.Address;
import domain.Friend;


public class FriendAddressClient {
public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//persisting		
		Friend friend = new Friend("Mark Anderson", "markanderson@pluswhere.com");
		
		friend.getNicknames().add("Marky");
		friend.getNicknames().add("Marco");
		friend.getNicknames().add("Markster");

		session.persist(friend);		
		
		//collection of embeddable Address object 
		
		Friend friend2 = new Friend("Mark Anderson 2", "markanderson2@pluswhere.com");
		
		friend2.getAddresses().add(new Address("street1", "city1", "zipcode1"));
		friend2.getAddresses().add(new Address("street2", "city2", "zipcode2"));
		friend2.getAddresses().add(new Address("street3", "city3", "zipcode3"));

		session.persist(friend2);
		
		
		//retrieving		
		/*Friend friend = (Friend) session.get(Friend.class, 1L);
		System.out.println(friend);		*/
		
		session.getTransaction().commit();
		session.close();
		
	}
}
