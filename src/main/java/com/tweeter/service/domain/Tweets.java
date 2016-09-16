package com.tweeter.service.domain;

public class Tweets {
  int id;
  String username;
  String timestamp;
  String tweet;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	@Override
	public String toString() {
		return "Tweets [id=" + id + ", username=" + username+ ", timestamp=" + timestamp+ ", tweet=" + tweet+ "]";
	}
}
