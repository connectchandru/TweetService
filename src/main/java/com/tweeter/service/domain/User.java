package com.tweeter.service.domain;
public class User {
	
	private String username;
	private String firstname;
	private String lastname; 
	private String dob;
	private String email; 
    
	public User()
	{
		
	}
	
	public User(String username, String firstname, String lastname, String dob,
			String email) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", dob="	+ dob + ", email="	+ email+ "]";
	}
	
}
