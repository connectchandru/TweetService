<html>
	<body>
		<h2>Welcome to the Tweeter World!</h2>
			<br>
			<p>
			<h3>
			/twitter/tweets/{username}     - Read the tweets (Self-tweets & Followed User's tweets)   
			/twitter/followers/{username}  - Followers and Followed users for the current user
			/twitter/follow                - Follow a Person (Requires args sent by POST request- POSTMAN)                                 
			/twitter/unfollow              - UnFollow a Person (Requires args sent by POST request- POSTMAN)
			</h3>
			<br>
			
			<h2> Bonus Web Services: </h2>
			<h3>
			/twitter/{username} - Lists details about the specified user
			/twitter/allUser    - Lists All users in the repository
			</h3>
			<br>
			<h2>For follow & Unfollow </h2>
			Under Body(POST)in POSTMAN, Set the below parameters
			curruser - {username/you}
			followuser - {username/friend}
			
			<br>
			
			<h2>Basic Authentication:</h2>
			Under Authorization, Set the below parameters
			Username - connectchandru
			Password - Chand@88
			
			</p>
	</body>
</html>
