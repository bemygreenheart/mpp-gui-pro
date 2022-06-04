package uz.group.mppguiproject.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class Person {

	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private String phone;
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	public Person() {
	}

	public Person(String firstName, String lastName, String phone, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getTelephone() {
		return phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setTelephone(String phone) {
		this.phone = phone;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
