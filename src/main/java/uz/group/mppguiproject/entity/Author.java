package uz.group.mppguiproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "author")
final public class Author{

	@Id
	private Long id;
	private String bio;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@OneToOne
	@JoinColumn(name = "person_id")
	private Person person;

	public Author() {
	}

	public Author(String firstName, String lastName, String phone, Address address, String bio) {
		person = new Person(firstName, lastName, phone, address);
		this.bio = bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getBio() {
		return bio;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}


}
