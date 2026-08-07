package com.example.demo.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class basic {
	public static void main(String args[]) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Passport p = new Passport();
		p.setPassportNumber("1234");
		
		Person p1=new Person();
//		p1.setId(1);
		p1.setName("abc");
		p1.setPassport(p);
		
		
		et.begin();
		em.persist(p);
		em.persist(p1);
		et.commit();
	}
}
