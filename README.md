# TweetService
API endpoint for Mini messaging service like Twitter

The back-end API for a mini messaging service developed using Spring MVC+REST+MySQL DB supports the following basic functionality:

1. An endpoint to read the tweets for a given user (include self-tweets and people being followed by the user). 
   An extra “search=” argument can be used to further filter tweets based on keyword.
2. Endpoints to get the list of people a user is following as well as the followers of the user.
3. An endpoint to start following another user.
4. An endpoint to unfollow another user.
