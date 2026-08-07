package bi_directional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class logic {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Bank bank = new Bank();
		bank.setName("SBI");
	
		Customer c1= new Customer();
		c1.setName("Keshav");
		Customer c2 = new Customer();
		c2.setName("Rahul");
		c1.setBank(bank);
		c2.setBank(bank);
		
		bank.getCustomer().add(c1);
		bank.getCustomer().add(c2);
		
		et.begin();
		em.persist(bank);
		em.persist(c1);
		em.persist(c2);
		et.commit();
	}

}
