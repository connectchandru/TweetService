# TweetService
API endpoint for Mini messaging service like Twitter

The back-end API for a mini messaging service developed using Spring MVC+REST+MySQL DB supports the following basic functionality:

1. An endpoint to read the tweets for a given user (include self-tweets and people being followed by the user). 
   An extra “search=” argument can be used to further filter tweets based on keyword.
2. Endpoints to get the list of people a user is following as well as the followers of the user.
3. An endpoint to start following another user.
4. An endpoint to unfollow another user.

/tweeter/tweets/{username}                    Read the tweets (Self-tweets & Followed User's tweets)
/tweeter/followers/{username}                 Followers and Followed users for the current user
/tweeter/{username1}/follows/{username2}      Follow a Person (Requires args sent by POST request- POSTMAN)                            
/tweeter/{username1}/unfollows/{username2}    UnFollow a Person (Requires args sent by POST request- POSTMAN)
/tweeter/{username}            		            Lists details about the specified user
/tweeter/allUsers                             Lists All users in the repository
