package com.tweeter.service.domain;

/**
 * Class that handles Setters and Getter
 * for Tweets table
 * 
 * @version 1.3
 * @author srinivasan6
 *
 */

public class Tweets {
  int id;
  String username;
  String timestamp;
  String tweet;
  /**
   * Returns the Id
   *   
   * @return unique-id for every tweet
   */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the Id
	 * 
	 * @param unique-id for every tweet
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	   * Returns the username
	   *   
	   * @return username who posted a tweet
	   */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the user who posts a tweet
	 * 
	 * @param the user who posts a tweet
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	   * Returns the timestamp
	   *   
	   * @return current-timestamp at which tweet got posted
	   */
	public String getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Sets the current timestamp
	 * 
	 * @param the current timestamp at which tweet was posted
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	   * Returns the tweet
	   *   
	   * @return tweet posted by the user
	   */
	public String getTweet() {
		return tweet;
	}
	
	/**
	 * Sets the tweet
	 * 
	 * @param tweet to be posted
	 */
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	@Override
	public String toString() {
		return "Tweets [id=" + id + ", username=" + username+ ", timestamp=" + timestamp+ ", tweet=" + tweet+ "]";
	}
}
