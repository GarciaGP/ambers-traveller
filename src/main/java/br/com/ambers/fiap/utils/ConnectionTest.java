package br.com.ambers.fiap.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;


public class ConnectionTest {
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFacade.getEntityManager();
		
		//Usuario us = new Usuario();
		
		/*
		 * us.setName("Sql"); us.setEmail("sql@sql.com");
		 * 
		 * em.getTransaction().begin();
		 * 
		 * em.persist(us);
		 * 
		 * em.getTransaction().commit();
		 * 
		 * em.close();
		 */
		
		
	}
}
