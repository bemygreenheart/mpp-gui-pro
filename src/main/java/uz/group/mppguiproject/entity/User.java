package uz.group.mppguiproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
final public class User{
	@Id
	@Column(name = "member_id")
	private Long memberId;

	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "user")
	private List<CheckoutEntry> checkouts;

	@OneToOne
	@JoinColumn(name = "person_id")
	private Person person;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(Long memberId, Role role, String firstName, String lastName, String phone, Address address) {
		this.person = new Person(firstName, lastName, phone, address);
		this.memberId = memberId;
		this.role = role;
		this.checkouts = new ArrayList<>();
	}

	public User() {
	}


	public Long getMemberId() {
		return memberId;
	}

	public Role getRole(){
		return role;
	}
	
	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + person.getFirstName() + " " + person.getLastName() +
				", " + person.getTelephone() + " " + person.getAddress();
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<CheckoutEntry> getCheckouts() {
		return checkouts;
	}

	public void addCheckouts(CheckoutEntry checkout) {
		this.checkouts.add(checkout);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
