//Brogan Avery
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BookDetails;

public class BookDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebAddressBook");

	public void insertNewBookDetails(BookDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<BookDetails> getBooks() {
		EntityManager em = emfactory.createEntityManager();
		List<BookDetails> allBooks = em.createQuery("SELECT b FROM BookDetails b").getResultList();
		return allBooks;
	}

	public void deleteBook(BookDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookDetails> typedQuery = em
				.createQuery("select detail from BookDetails detail where detail.id = :selectedId", BookDetails.class);
	
		typedQuery.setParameter("selectedId", toDelete.getId());

		typedQuery.setMaxResults(1);

		BookDetails result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public BookDetails searchForBookDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		BookDetails found = em.find(BookDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateBook(BookDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}