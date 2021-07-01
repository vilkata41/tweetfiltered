package tweetFilteredPackage;

import java.util.*;
import twitter4j.*;
import twitter4j.conf.*;

public class TwitterInfo {

	public static void main(String[] args) {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true).setOAuthConsumerKey(ImportantConstants.CONSUMER_KEY) 
						.setOAuthConsumerSecret(ImportantConstants.CONSUMER_SECRET)
						.setOAuthAccessToken(ImportantConstants.ACCESS_TOKEN)
						.setOAuthAccessTokenSecret(ImportantConstants.TOKEN_SECRET);	
	}

}
