package tweetFilteredPackage;

import twitter4j.*;
import twitter4j.conf.*;

public class TwitterInfo {

	public static void main(String[] args) {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder(); 							//Set up the configuration builder
		configurationBuilder.setDebugEnabled(true).setOAuthConsumerKey(ImportantConstants.CONSUMER_KEY) 	//For everything to work properly with Twitter's API
						.setOAuthConsumerSecret(ImportantConstants.CONSUMER_SECRET)							//We'd need the consumer key and secret AND
						.setOAuthAccessToken(ImportantConstants.ACCESS_TOKEN)								//The access token and secret.
						.setOAuthAccessTokenSecret(ImportantConstants.TOKEN_SECRET);	
	}

}
