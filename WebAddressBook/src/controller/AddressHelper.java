//Brogan Avery
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;
import model.Address;

public class AddressHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebShoppingList");
	
	public void insertItem(Address li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Address> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<Address> allItems	= em.createQuery("SELECT i FROM	ListItem i").getResultList();
		return	allItems;
	}
	
	public void	deleteItem(Address	toDelete){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery	= em.createQuery("select li from	ListItem li	where li.store = :selectedStore	and	li.item	= :selectedItem", Address.class);
	
		//Substitute parameter	with actual	data from the toDelete item
		typedQuery.setParameter("selectedStore", toDelete.getStore());
		typedQuery.setParameter("selectedItem",	toDelete.getItem());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get	the	result	and	save it	into a new list item
		Address result	= typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	
	}

	public Address searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Address found = em.find(Address.class, idToEdit);
		em.close();
		return	found;
	}

	public void updateItem(Address toEdit) {
		EntityManager em =	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Address> searchForItemByStore(String storeName) {
		EntityManager em =	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery	= em.createQuery("select li	from ListItem li where li.store	= :selectedStore", Address.class);
		typedQuery.setParameter("selectedStore", storeName);
		List<Address> foundItems = typedQuery.getResultList();
		em.close();
		return	foundItems;
	}

	public List<Address> searchForItemByItem(String itemName) {
		EntityManager em =	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery	= em.createQuery("select li	from ListItem li where li.item	= :selectedItem", Address.class);
		typedQuery.setParameter("selectedItem",	itemName);
		List<Address> foundItems =	typedQuery.getResultList();
		em.close();
		return	foundItems;
	}
	
	public	void cleanUp(){
		emfactory.close();
		}
}
