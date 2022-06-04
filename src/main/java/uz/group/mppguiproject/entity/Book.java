package uz.group.mppguiproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

/**
 *
 */
@Entity
@Table(name = "book")
final public class Book {

	@Id
	private Long id;
	@OneToMany(mappedBy = "originalBook")
	private List<BookCopy> copies;
	@OneToMany(mappedBy = "book")
	private List<Author> authors;
	private String isbn;
	private String title;
	private CheckoutLength maxCheckoutLength;

	public Book() {
	}

	public Book(String isbn, String title, CheckoutLength maxCheckoutLength, List<Author> authors) {
		this.isbn = isbn;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		this.authors = Collections.unmodifiableList(authors);
		copies = new ArrayList<>();
	}

	public List<Integer> getCopyNums() {
		List<Integer> retVal = new ArrayList<>();
		for(BookCopy c : copies) {
			retVal.add(c.getCopyNum());
		}
		return retVal;
		
	}
	
	public void addCopy(BookCopy copy) {
		copies.add(copy);
	}
	
	
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass() != getClass()) return false;
		Book b = (Book)ob;
		return b.isbn.equals(isbn);
	}
	
	
	public boolean isAvailable() {
		if(copies == null) {
			return false;
		}
		return copies.stream()
				     .map(l -> l.isAvailable())
				     .reduce(false, (x,y) -> x || y);
	}
	@Override
	public String toString() {
		return "isbn: " + isbn + ", maxLength: " + maxCheckoutLength + ", available: " + isAvailable();
	}
	
	public int getNumCopies() {
		return copies.size();
	}
	
	public String getTitle() {
		return title;
	}
	public List<BookCopy> getCopies() {
		return copies;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public BookCopy getNextAvailableCopy() {	
		Optional<BookCopy> optional 
			= copies.stream()
			        .filter(x -> x.isAvailable()).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public Optional<BookCopy> getCopy(int copyNum) {
		return copies.stream().filter(c -> c.getCopyNum() == copyNum).findFirst();
	}

	public CheckoutLength getMaxCheckoutLength() {
		return maxCheckoutLength;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCopies(List<BookCopy> copies) {
		this.copies = copies;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMaxCheckoutLength(CheckoutLength maxCheckoutLength) {
		this.maxCheckoutLength = maxCheckoutLength;
	}
}
