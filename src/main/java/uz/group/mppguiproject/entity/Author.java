package uz.group.mppguiproject.entity;

import java.io.Serializable;

final public class Author extends Person{
	private String bio;
	public String getBio() {
		return bio;
	}
	
	public Author(String firstName, String lastName, String phone, Address address, String bio) {
		super(firstName, lastName, phone, address);
		this.bio = bio;
	}

}
