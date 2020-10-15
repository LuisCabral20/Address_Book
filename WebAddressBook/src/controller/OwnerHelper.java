//Brogan Avery
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;

public class OwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebAddressBook");

	public void insertOwner(Owner li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<Owner> showAllOwners() {
		EntityManager em = emfactory.createEntityManager();
		List<Owner> allOwners = em.createQuery("SELECT o FROM Owner o").getResultList();
		return allOwners;
	}
// can not have multiple people with same name 
	public Owner findOwner(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select o from Owner o where o.ownerName = :selectedName",
				Owner.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Owner foundOwner;
		try {
			foundOwner = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundOwner = new Owner(nameToLookUp);
		}
		em.close();

		return foundOwner;
	}
}

