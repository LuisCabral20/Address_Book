//Brogan Avery
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BookDetails;

public class BookDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebShoppingList");

	public void insertNewListDetails(BookDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<BookDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<BookDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}

	public void deleteList(BookDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookDetails> typedQuery = em
				.createQuery("select detail from ListDetails detail where detail.id = :selectedId", BookDetails.class);
	
		typedQuery.setParameter("selectedId", toDelete.getId());

		typedQuery.setMaxResults(1);

		BookDetails result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public BookDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		BookDetails found = em.find(BookDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateList(BookDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}