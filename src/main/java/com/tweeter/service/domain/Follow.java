package com.tweeter.service.domain;

/**
 * Class that handles Setters and Getter
 * for Follow Table
 * 
 * @version 1.3
 * @author srinivasan6
 *
 */

public class Follow {
  private int id;
  private String person;
  private String follower;
  
    /**
     * Returns the Id
     *   
     * @return unique-id for every follow action
     */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the Id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
    /**
     * Returns the Followed Person
     *   
     * @return the username that is being followed
     */
	public String getPerson() {
		return person;
	}
	
	/**
	 * Sets the Followed Person
	 * 
	 * @param the user who is being followed
	 */
	public void setPerson(String person) {
		this.person = person;
	}
	
    /**
     * Returns the follower
     *   
     * @return the username of the follower
     */
	public String getFollower() {
		return follower;
	}
	
	/**
	 * Sets the Follower
	 * 
	 * @param the user who follows
	 */
	public void setFollower(String follower) {
		this.follower = follower;
	}
 
	@Override
	public String toString() {
		return "Follow [id=" + id + ", Person=" + person+ ", Follower=" + follower+ "]";
	}
	
}
