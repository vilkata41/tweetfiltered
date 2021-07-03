package tweetFilteredPackage;

import java.util.List;

import twitter4j.*;
import twitter4j.conf.*;

public class TwitterInfo {

	public static void main(String[] args) {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder(); 							//Set up the configuration builder
		configurationBuilder.setDebugEnabled(true).setOAuthConsumerKey(ImportantConstants.CONSUMER_KEY) 	//For everything to work properly with Twitter's API
						.setOAuthConsumerSecret(ImportantConstants.CONSUMER_SECRET)							//We'd need the consumer key and secret AND
						.setOAuthAccessToken(ImportantConstants.ACCESS_TOKEN)								//The access token and secret.
						.setOAuthAccessTokenSecret(ImportantConstants.TOKEN_SECRET);
		
		Twitter twitter = new TwitterFactory(configurationBuilder.build()).getInstance(); //Getting the instance for the twitter account
		
		try {
			User user = twitter.verifyCredentials(); //Getting the actual tweetfiltered account on twitter
			List<Status> mentionedStatuses = twitter.getMentionsTimeline(); //Filling a list with the tweets we're menitioned in.
			
			for (Status s: mentionedStatuses) {
				System.out.println(""); 												//Just adding a new line, so the tweets don't blend
				
				System.out.println(s.getUser().getName() + " tweeted: " + s.getText().toString().replaceAll("https://t.co/[a-zA-Z_0-9]*","")); //Removing the link at the end of posts with media
				
				if(s.getMediaEntities().length > 0) {
					System.out.println("Included media: ");
					
					for(int i = 0; i < s.getMediaEntities().length; i++) {
						if(s.getMediaEntities()[i].getType().equals("video")) System.out.println(s.getMediaEntities()[i].getVideoVariants()[0].getUrl());
						else System.out.println(s.getMediaEntities()[i].getMediaURL());
					}
				}
				
			}
			
		}
		catch(TwitterException ex) { //We catch the exception and handle it
			ex.printStackTrace();
			System.out.println("Failed to get tweets.");
			System.exit(-1);
		}
	}

}
