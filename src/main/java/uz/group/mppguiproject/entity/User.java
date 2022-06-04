package uz.group.mppguiproject.entity;

import java.io.Serializable;

final public class User extends Person implements Serializable {
	private String memberId;
	private Role role;
	
	public User(String memberId, Role role, String firstName, String lastName, String phone, Address address) {
		super(firstName,lastName, phone, address);
		this.memberId = memberId;
		this.role = role;
	}
	
	
	public String getMemberId() {
		return memberId;
	}

	public Role getRole(){
		return role;
	}
	
	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() + 
				", " + getTelephone() + " " + getAddress();
	}

	private static final long serialVersionUID = -2226197306790714013L;
}
