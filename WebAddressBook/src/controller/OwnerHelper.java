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
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebShoppingList");

	public void insertShopper(Owner li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<Owner> showAllShoppers() {
		EntityManager em = emfactory.createEntityManager();
		List<Owner> allShoppers = em.createQuery("SELECT s FROM Shopper s").getResultList();
		return allShoppers;
	}
// can not have multiple people with same name 
	public Owner findShopper(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select sh from Shopper sh where sh.shopperName = :selectedName",
				Owner.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Owner foundShopper;
		try {
			foundShopper = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundShopper = new Owner(nameToLookUp);
		}
		em.close();

		return foundShopper;
	}
}

