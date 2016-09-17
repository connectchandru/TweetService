package com.tweeter.service.domain;

/**
 * Class that handles Setters and Getter
 * for Users table
 * 
 * @version 1.3
 * @author srinivasan6
 *
 */

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
	
	 /**
	   * Returns the username
	   *   
	   * @return username of tweeter account
	   */

	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username of tweeter account
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
    
	 /**
	   * Returns the firstname
	   *   
	   * @return firstname of tweeter account
	   */
	public String getFirstname() {
		return firstname;
	}
    
	/**
	 * Sets the firstname of tweeter account
	 * 
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	 /**
	   * Returns the lastname
	   *   
	   * @return lastname of tweeter account
	   */
	public String getLastname() {
		return lastname;
	}
    
	/**
	 * Sets the lastname of tweeter account
	 * 
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
    
	 /**
	   * Returns the Date of Birth of User
	   *   
	   * @return dob of current-user
	   */
	public String getDob() {
		return dob;
	}
    
	/**
	 * Sets the date of Birth of User
	 * 
	 * @param dob of the user
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	 /**
	   * Returns the email Id of User
	   *   
	   * @return email of current-user
	   */
	public String getEmail() {
		return email;
	}
    
	/**
	 * Sets the email Id of User
	 * 
	 * @param email Id of the  user
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", dob="	+ dob + ", email="	+ email+ "]";
	}
	
}
