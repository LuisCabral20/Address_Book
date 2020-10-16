//Brogan Avery
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addresses")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
//constructors
	public Address(){
		super();
		
	}
	
	public	Address(String name, String address){
		this.name = name;
		this.address = address;
	}
	
//getters

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

//setters
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String returnAddressDetails(){
		
		return name + ": "	+address;
	}
	
}
