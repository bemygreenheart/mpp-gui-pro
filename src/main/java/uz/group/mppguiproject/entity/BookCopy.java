package uz.group.mppguiproject.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Immutable class
 */

@Entity
@Table(name = "book_copy")
final public class BookCopy{

	@Id
	private int copyNum;
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book originalBook;
	private boolean isAvailable;

	public BookCopy() {
	}

	BookCopy(Book book, int copyNum, boolean isAvailable) {
		this.originalBook = book;
		this.copyNum = copyNum;
		this.isAvailable = isAvailable;
	}
	
	BookCopy(Book book, int copyNum) {
		this(book, copyNum, true);
	}
	
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public int getCopyNum() {
		return copyNum;
	}
	
	public Book getBook() {
		return originalBook;
	}
	
	public void changeAvailability() {
		isAvailable = !isAvailable;
	}
	
	@Override
	public boolean equals(Object ob) {
		if(!(ob instanceof BookCopy)) return false;
		BookCopy copy = (BookCopy)ob;
		return copy.originalBook.getIsbn().equals(originalBook.getIsbn()) && copy.copyNum == copyNum;
	}
	
}
