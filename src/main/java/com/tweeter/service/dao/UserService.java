package com.tweeter.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tweeter.service.db.DBUtility;
import com.tweeter.service.domain.User;

/**
 * Class that handles User Services like
 * User details & All Users
 * 
 * @version 1.3
 * @author srinivasan6
 *
 */
public class UserService {
	
	private Connection connection;

	public UserService() {
		connection = DBUtility.getConnection();
	}
	
	/**
	 * Method to fetch a specific user information
	 * 
	 * @return  list of all Users
	 */
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user limit 15");
			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));				
				user.setDob(rs.getString("dob"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	/**
	 * Method to fetch a specific user information
	 * 
	 * @param username the user for which info is required
	 * @return  information about the user
	 */
	
	public User getUserById(String username) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from User where username=?");
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setDob(rs.getString("dob"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	}
	

