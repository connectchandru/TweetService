package com.tweeter.service.controller;

import java.text.ParseException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tweeter.service.dao.FollowService;
import com.tweeter.service.dao.TweetService;
import com.tweeter.service.dao.UserService;
import com.tweeter.service.domain.Tweets;
import com.tweeter.service.domain.User;
import com.tweeter.service.domain.Follow;


/**
 * Class that handles RESTful Services
 * for Follow, Tweets & User
 * 
 * @version 1.3
 * @author srinivasan6
 *
 */

@RestController
@RequestMapping("/tweeter/")
public class SpringServiceController {
	
	UserService userService=new UserService();
	FollowService followService=new FollowService();
	TweetService tweetService=new TweetService();
	
	//-----------------------------Follow an user--------------------------------------------------
	/**
	 * POST RESTful Service to Follow an User
	 * 
	 * @param curruser   the current-user who wants to follow
	 * @param followuser the user being followed
	 * @return           1 if followed successfully
	 * @throws ParseException
	 */
	@RequestMapping(value = "/{curruser}/follows/{followuser}", method = RequestMethod.POST )
	public String setFollowUser(@PathVariable String curruser, @PathVariable String followuser) throws ParseException {
		int changed =followService.updateFollowByUser(followuser, curruser);
		if (changed != 1) {
            System.out.println("Follow failed");
            return "Follow Failed";
        }
		return "Following User: " + followuser;
	}
	
	//-----------------------------Unfollow an user--------------------------------------------------
	/**
	 * POST RESTful Service to UnFollow an User
	 * 
	 * @param curruser   the current-user who wants to unfollow
	 * @param followuser the user being Unfollowed
	 * @return           1 if Unfollowed successfully
	 * @throws ParseException
	 */
	@RequestMapping(value = "/{curruser}/unfollows/{followuser}", method = RequestMethod.DELETE )
	public String setUnfollowUser(@PathVariable String curruser, @PathVariable String followuser ) throws ParseException {
		//System.out.println("fuser: " +followuser);
		//System.out.println("curruser: " +curruser);
		int changed =followService.updateUnfollowByUser(curruser, followuser);
		if (changed != 1) {
            System.out.println("UnFollow failed");
            return "UnFollow Failed";
        }
		return "UnFollowed User: " + followuser;
	}
	
	//-------------------Retrieve followers and following users---------------------------------------
	/**
	 * GET RESTful Service to retrieve the list of people a
	 * user is following as well as the followers of the user
	 * 
	 * @param username  the current-user 
	 * 					
	 * @return retrieves list of users followed and following
	 * 			         for the current-username           
	 */
	@RequestMapping(value = "/followers/{username}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<Follow>> getFollowers(@PathVariable String username) {
		List<Follow> followers=followService.getFollowerById(username);
		if (followers == null) {
            System.out.println("No followers found");
            return new ResponseEntity<List<Follow>>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<List<Follow>>(followers, HttpStatus.OK);
	} 
	
	//-------------------Retrieve Self-tweets & tweets from followed Users---------------------------
	
	/**
	 * GET RESTful Service to read Self-tweets and 
	 * tweets from followed user
	 * 
	 * @param username  the current-username
	 * @return list of tweets form followed & following users
	 */
	@RequestMapping(value = "/tweets/{username}", method = RequestMethod.GET)
	public ResponseEntity<List<Tweets>> getTweets(@PathVariable String username) {
		List<Tweets> tweets=tweetService.getTweetsById(username);
		if (tweets == null) {
            System.out.println("No tweets found");
            return new ResponseEntity<List<Tweets>>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<List<Tweets>>(tweets, HttpStatus.OK);
	}
	
	
	//-------------------Based on Search-Retrieve Self-tweets & tweets from followed Users------------------
	
	/**
	 * GET RESTful Service to read Self-tweets and 
	 * tweets from followed user
	 * 
	 * @param username  the current-username
	 * @return list of tweets form followed & following users
	 */
	@RequestMapping(value = "/tweets/{username}/search{searchval}", method = RequestMethod.GET)
	public ResponseEntity<List<Tweets>> getTweets(@PathVariable String username, @PathVariable String searchval) {
		List<Tweets> tweets=tweetService.getSearchTweetsById(username, searchval);
		if (tweets == null) {
            System.out.println("No tweets found");
            return new ResponseEntity<List<Tweets>>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<List<Tweets>>(tweets, HttpStatus.OK);
	}
	
	//-------------------Retrieve Single User--------------------------------------------------------
	
	/**
	 * GET RESTful Service to fetch a specific user information
	 * 
	 * @param username the user for which info is required
	 * @return  information about the user
	 */
	@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable String username) {
		System.out.println("Fetching User with username " + username);
		User user=userService.getUserById(username);
		if (user == null) {
            System.out.println("User with username " + username + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}    	    

	//-------------------Retrieve All Users Info------------------------------------------------------
	/**
	 * GET RESTful Service to fetch a specific user information
	 * 
	 * @return  information about all the user in repository
	 */
	@RequestMapping(value = "/allUsers",method = RequestMethod.GET,headers="Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users=userService.getAllUsers();
		if (users == null) {
            System.out.println("No Users found");
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	
	
}
	
