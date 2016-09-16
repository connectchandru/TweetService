package com.tweeter.service.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tweeter.service.dao.FollowService;
import com.tweeter.service.dao.TweetService;
import com.tweeter.service.dao.UserService;
import com.tweeter.service.domain.Tweets;
import com.tweeter.service.domain.User;
import com.tweeter.service.domain.Follow;


@RestController
@RequestMapping("/tweeter/")
public class SpringServiceController {
	
	UserService userService=new UserService();
	FollowService followService=new FollowService();
	TweetService tweetService=new TweetService();
	
	@RequestMapping(value = "/follow", method = RequestMethod.POST )
	public int setFollowUser(String curruser, String followuser) throws ParseException {
		int changed =followService.updateFollowByUser(followuser, curruser);
		return changed;
	}
	
	@RequestMapping(value = "/unfollow", method = RequestMethod.DELETE )
	public int setUnfollowUser(String curruser, String followuser) throws ParseException {
		int changed =followService.updateUnfollowByUser(followuser, curruser);
		return changed;
	}
	
	
	@RequestMapping(value = "/followers/{username}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Follow> getFollowers(@PathVariable String username) {
		List<Follow> followers=followService.getFollowerById(username);
		return followers;
	} 
	
	@RequestMapping(value = "/tweets/{username}", method = RequestMethod.GET)
	public List<Tweets> getTweets(@PathVariable String username) {
		List<Tweets> tweets=tweetService.getTweetsById(username);
		return tweets;
	}
	//-------------------Retrieve Single User--------------------------------------------------------
	
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

	@RequestMapping(value = "/allUsers",method = RequestMethod.GET,headers="Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<User> getAllUsers() {
		List<User> users=userService.getAllUsers();
		return users;
	}
	
	
	
}
	
