package client;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Message;

public class MessageClient {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Message msg = null;

		try {
			txn.begin();

			msg = new Message("Hello World with Hibernate as JPA Provider");
			em.persist(msg);

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		msg.setText("Hi"); // modifying the detached state of message

		EntityManager em2 = emf.createEntityManager();
		EntityTransaction txn2 = em2.getTransaction();
		txn2.begin();

		// the returned mergedMessage is a persistent object
		// any changes to mergedMessage will be dirty checked when the txn2 will be
		// committed and updated in the database
		Message mergedMessage = em2.merge(msg);

		txn2.commit();
		em2.close();

		// Detaching objects explicitly
		/*
		 * EntityManager em3 = emf.createEntityManager(); EntityTransaction txn3 =
		 * em3.getTransaction(); txn3.begin();
		 * 
		 * Message msg = new Message("Howdy"); //transient state em3.persist(msg);
		 * //persistent state
		 * 
		 * em3.detach(msg); //detaching the message object explicitly txn3.commit();
		 * em3.close();
		 */

	}

}
