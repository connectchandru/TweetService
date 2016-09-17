package com.tweeter.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.tweeter.service.db.DBUtility;
import com.tweeter.service.domain.Follow;

public class FollowService {
	
	private Connection connection;

	public FollowService() {
		connection = DBUtility.getConnection();
	}
	
	/**
	 * Function to retrieve the list of people a
	 * user is following as well as the followers of the user
	 * 
	 * @param username  the current-user 
	 * 					
	 * @return retrieves list of users followed and following
	 * 			         for the current-username           
	 */
	public List<Follow> getFollowerById(String username) {
		List<Follow> followers = new ArrayList<Follow>();
		
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select follower from follow where person = ?  UNION select person from follow where follower = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, username);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Follow follow = new Follow();
				follow.setFollower(rs.getString("follower"));
				followers.add(follow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return followers;
	}
    
	/**
	 * Function that handles following an User
	 * 
	 * @param curruser   the current-user who wants to follow
	 * @param followuser the user being followed
	 * @return           1 if followed successfully
	 * @throws ParseException
	 */
	
	public int updateFollowByUser(String followuser,String curruser) throws ParseException {
		int retVal=0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into follow (follower,person) values (?, ?)");
			// Parameters start with 1			
			preparedStatement.setString(1, followuser);
			preparedStatement.setString(2, curruser);			
			retVal = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	/**
	 * Function that handles UnFollowing an User
	 * 
	 * @param curruser   the current-user who wants to unfollow
	 * @param followuser the user being Unfollowed
	 * @return           1 if Unfollowed successfully
	 * @throws ParseException
	 */
	public int updateUnfollowByUser(String curruser,String followuser) throws ParseException {
		int retVal=0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from follow  where follower = ? and person =  ?");
			// Parameters start with 1			
			preparedStatement.setString(1, curruser);
			preparedStatement.setString(2, followuser);			
			retVal = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
