package com.tweeter.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tweeter.service.db.DBUtility;
import com.tweeter.service.domain.Tweets;

public class TweetService {

	
	private Connection connection;

	public TweetService() {
		connection = DBUtility.getConnection();
	}
	
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
	
}
