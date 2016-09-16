<html>
	<body>
		<h1><cite>Welcome to the Tweeter World!</cite></h1>
		    <hr>
			<p>
			
			<h2>Web Services : </h2>
			<h3>
			<p><a href="/TweetServer/tweeter/tweets/connectchandru/">/tweeter/tweets/{username}</a>     - Read the tweets (Self-tweets & Followed User's tweets)   <br/></p>
			<p>/tweeter/followers/{username}  - Followers and Followed users for the current user        <br/></p>
			<p>/tweeter/follow                - Follow a Person (Requires args sent by POST request- POSTMAN)  <br/></p>                               
			<p>/tweeter/unfollow              - UnFollow a Person (Requires args sent by POST request- POSTMAN) <br/></p>
			<p>/tweeter/{username} - Lists details about the specified user <br/></p>
			<p>/tweeter/allUsers    - Lists All users in the repository</p>
			</h3>
			<br><br><br>
			
			<hr>
			<h4><cite>For follow & Unfollow : </cite></h4>
			<h4>
			Under Body(POST)in POSTMAN, Set the below parameters <br/>
			curruser - {username/you}                            <br/>
			followuser - {username/friend}
			</h4>
			
			<h4><cite>Basic Authentication :</cite></h4>
			<h4>Authorization is first for all webservices. User cannot enter without authorization for all Endpoints.<br/>
			Set the below parameters <br/>
			Username - connectchandru     <br/>
			Password - Chand@88       
			</h4>
			
	</body>
</html>
