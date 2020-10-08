//Brogan Avery
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="STORE")
	private String store;
	
	@Column(name="ITEM")
	private String item;
	
//constructors
	public Address(){
		super();
		
	}
	
	public	Address(String store, String item){
		this.store = store;
		this.item = item;
	}
	
//getters

	public int getId() {
		return id;
	}

	public String getStore() {
		return store;
	}

	public String getItem() {
		return item;
	}

//setters
	public void setId(int id) {
		this.id = id;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
//otra methods
	public String returnItemDetails(){
		
		return store + ": "	+item;
	}
	
}
