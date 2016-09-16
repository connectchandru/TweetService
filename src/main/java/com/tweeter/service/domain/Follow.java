package com.tweeter.service.domain;

public class Follow {
  private int id;
  private String person;
  private String follower;
  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
 
	@Override
	public String toString() {
		return "Follow [id=" + id + ", Person=" + person+ ", Follower=" + follower+ "]";
	}
		
	
	
}
