//Brogan Avery
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;
import model.Address;

public class AddressHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebAddressBook");
	
	public void insertAddress(Address row) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(row);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Address> showAllAddresses(){
		EntityManager em = emfactory.createEntityManager();
		List<Address> allAddresses	= em.createQuery("SELECT i FROM	Address i").getResultList();
		return	allAddresses;
	}
	
	public void	deleteAddress(Address toDelete){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery	= em.createQuery("select row from Address row where row.name = :selectedName	and	row.address	= :selectedAddress", Address.class);
	
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAddress", toDelete.getAddress());
		
		typedQuery.setMaxResults(1);
		
		Address result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	
	}

	public Address searchForAddressById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Address found = em.find(Address.class, idToEdit);
		em.close();
		return	found;
	}

	public void updateAddress(Address toEdit) {
		EntityManager em =	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Address> searchForAddressByName(String name) {
		EntityManager em =	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery	= em.createQuery("select row from Address row where row.name = :selectedName", Address.class);
		typedQuery.setParameter("selectedName", name);
		List<Address> foundAddresses = typedQuery.getResultList();
		em.close();
		return	foundAddresses;
	}

	public List<Address> searchForAddressByAddress(String itemName) {
		EntityManager em =	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery	= em.createQuery("select row from Address row where row.address = :selectedAddress", Address.class);
		typedQuery.setParameter("selectedAddress",	itemName);
		List<Address> foundAddresses =	typedQuery.getResultList();
		em.close();
		return	foundAddresses;
	}
	
	public	void cleanUp(){
		emfactory.close();
		}
}
