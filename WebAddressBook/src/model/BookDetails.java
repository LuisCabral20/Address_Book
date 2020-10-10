//Brogan Avery
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class BookDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="TRIP_DATE")
	private LocalDate tripDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="SHOPPER_ID")
	private Owner shopper;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	  (
	      name="ITEMS_ON_LIST",
	      joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
	      inverseJoinColumns={ @JoinColumn(name="ITEM_ID", referencedColumnName="ID", unique=true) }
	  )
    
	private List<Address> listOfItems;

	
	public BookDetails() {
		super();
	}
	

	public BookDetails(int id, String listName, LocalDate tripDate, Owner shopper, List<Address> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
		this.listOfItems = listOfItems;
	}

	public BookDetails(String listName, LocalDate tripDate, Owner shopper, List<Address> listOfItems) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
		this.listOfItems = listOfItems;
	}

	public BookDetails(String listName, LocalDate tripDate, Owner shopper) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getTripDate() {
		return tripDate;
	}
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	public Owner getShopper() {
		return shopper;
	}
	public void setShopper(Owner shopper) {
		this.shopper = shopper;
	}


	public List<Address> getListOfItems() {
		return listOfItems;
	}


	public void setListOfItems(List<Address> listOfItems) {
		this.listOfItems = listOfItems;
	}


	@Override
	public String toString() {
		return "ShoppingListDetails [id=" + id + ", ListName=" + listName + ", tripDate=" + tripDate + ", shopper="
				+ shopper + ", listOfItems=" + listOfItems + "]";
	}


	

	
}
