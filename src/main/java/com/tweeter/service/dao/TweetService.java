package com.tweeter.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tweeter.service.db.DBUtility;
import com.tweeter.service.domain.Tweets;

/**
 * Class that handles Tweet Services like
 * Self-tweets & tweets posted by followers
 * 
 * @version 1.3
 * @author srinivasan6
 *
 */

public class TweetService {
	private Connection connection;

	public TweetService() {
		connection = DBUtility.getConnection();
	}
	
	/**
	 * Method to read Self-tweets and tweets 
	 * from followed user
	 * 
	 * @param username  the current-username
	 * @return list of tweets form followed & following users
	 */
	
	public List<Tweets> getTweetsById(String username) {
		List<Tweets> tweets = new ArrayList<Tweets>();
		
		try {
			String Query = "select * from tweets where username = ? UNION select * from tweets where username IN(select person from follow where follower = ?)";
			PreparedStatement preparedStatement = connection.
					prepareStatement(Query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, username);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Tweets tweet = new Tweets();
				tweet.setTweet(rs.getString("tweet"));
				tweet.setUsername(rs.getString("username"));
				tweet.setTimestamp(rs.getString("timestamp"));
				tweet.setId(rs.getInt("id"));
				tweets.add(tweet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tweets;
	}
	
	
	public List<Tweets> getSearchTweetsById(String username, String SearchVal) {
		List<Tweets> tweets = new ArrayList<Tweets>();
		
		try {
			String Query = "select * from tweets where username = ? and tweet LIKE ? UNION select * from tweets where username IN(select person from follow where follower = ?) and tweet LIKE ?";
			PreparedStatement preparedStatement = connection.
					prepareStatement(Query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2,"%"+ SearchVal+"%");
			preparedStatement.setString(3, username);
			preparedStatement.setString(4,"%"+ SearchVal+"%");
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Tweets tweet = new Tweets();
				tweet.setTweet(rs.getString("tweet"));
				tweet.setUsername(rs.getString("username"));
				tweet.setTimestamp(rs.getString("timestamp"));
				tweet.setId(rs.getInt("id"));
				tweets.add(tweet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tweets;
	}
}
