package data_fetch;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuth2Authorization;
import twitter4j.auth.RequestToken;
import twitter4j.examples.tweets.GetRetweets;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Consumer;

import props.Access_property;
import props.Properties_assign;
import props.Property_validate;
import database.UserDao;

public class fetching {

	private static Logger logger = Logger.getLogger(fetching.class);

	public static void main(String[] args) {

		logger.debug("Starting");

		TwitterFactory twitterFactory = new TwitterFactory();
		Twitter twitter3 = twitterFactory.getInstance();

		try {
			Property_validate.initialize("conf/twitter4j.properties");
		} catch (Exception e) {
			logger.error("Couldn't load property file, please check your configuration.");

		}

		logger.error("asdasd");
		twitter3.setOAuthConsumer(
				Access_property.getProperty(Properties_assign.consumerKey2),
				Access_property.getProperty(Properties_assign.consumerSecret2));
		logger.error("asdas");
		AccessToken accessToken = null;
		// RequestToken
		try {
			RequestToken requestToken = twitter3.getOAuthRequestToken();

			System.out.println("Got request token.");
			System.out.println("Request token: " + requestToken.getToken());
			System.out.println("Request token secret: "
					+ requestToken.getTokenSecret());
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			while (null == accessToken) {
				logger.debug("Open the following URL and grant access to your account:");
				logger.debug(requestToken.getAuthorizationURL());

				logger.debug("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
				String pin = br.readLine();
				try {

					if (pin.length() > 0) {
						accessToken = twitter3.getOAuthAccessToken(
								requestToken, pin);
					} else {
						accessToken = twitter3.getOAuthAccessToken();
					}
				} catch (TwitterException te) {
					if (401 == te.getStatusCode()) {
						System.out.println("Unable to get the access token.");
					} else {
						te.printStackTrace();
					}
				}
			}
			// persist to the accessToken for future reference.
			System.out.println(twitter3.verifyCredentials().getId());
			System.out.println("token : " + accessToken.getToken());
			System.out.println("tokenSecret : " + accessToken.getTokenSecret());
            
		} catch (Exception e) {
			logger.error("cannot get tokens");
		}
		// //hey hey

		// setup OAuth Access Token
		// twitter1.setOAuthAccessToken(new
		// AccessToken(Access_property.getProperty(Properties_assign.accessToken),
		// Access_property.getProperty(Properties_assign.accessTokenSecret)));

		twitter3.setOAuthAccessToken(new AccessToken(accessToken.getToken(),accessToken.getTokenSecret()));
		
		
		long id_me;
		try {
			id_me = twitter3.getId();
			User me = twitter3.showUser(id_me);
			twitter3.showUser(id_me);
			System.out.println(id_me);
			logger.debug("hey");
			 UserDao.insertinfo(me);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
