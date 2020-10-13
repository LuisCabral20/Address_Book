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
@Table(name="book_details")
public class BookDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BOOK_ID")
	private int id;
	@Column(name="BOOK_NAME")
	private String bookName;
	@Column(name="BOOK_STARTED_DATE")
	private LocalDate bookStartedDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="OWNER_ID")
	private Owner owner;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	  (
	      name="ADDRESSES_IN_BOOK",
	      joinColumns={ @JoinColumn(name="BOOK_ID", referencedColumnName="BOOK_ID") },
	      inverseJoinColumns={ @JoinColumn(name="ADDRESS_ID", referencedColumnName="ID", unique=true) }
	  )
    
	private List<Address> bookOfAddresses;

	
	public BookDetails() {
		super();
	}
	

	public BookDetails(int id, String bookName, LocalDate bookStartedDate, Owner owner, List<Address> bookOfAddresses) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookStartedDate = bookStartedDate;
		this.owner = owner;
		this.bookOfAddresses = bookOfAddresses;
	}

	public BookDetails(String bookName, LocalDate bookStartedDate, Owner owner, List<Address> bookOfAddresses) {
		super();
		this.bookName = bookName;
		this.bookStartedDate = bookStartedDate;
		this.owner = owner;
		this.bookOfAddresses = bookOfAddresses;
	}

	public BookDetails(String bookName, LocalDate bookStartedDate, Owner owner) {
		super();
		this.bookName = bookName;
		this.bookStartedDate = bookStartedDate;
		this.owner = owner;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public LocalDate getBookStartedDate() {
		return bookStartedDate;
	}
	public void setBookStartedDate(LocalDate bookStartedDate) {
		this.bookStartedDate = bookStartedDate;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	public List<Address> getBookOfAddresses() {
		return bookOfAddresses;
	}


	public void setBookOfAddresses(List<Address> bookOfAddresses) {
		this.bookOfAddresses = bookOfAddresses;
	}


	@Override
	public String toString() {
		return "BookDetails [id=" + id + ", BookName=" + bookName + ", bookStartedDate=" + bookStartedDate + ", owner="
				+ owner + ", bookOfAddresses=" + bookOfAddresses + "]";
	}


	

	
}
