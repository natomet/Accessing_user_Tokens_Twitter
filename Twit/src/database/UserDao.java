package database;

import helper.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import database.ConnPool;

import twitter4j.*;
import org.apache.log4j.Logger;

import org.joda.time.DateTime;

import com.google.gson.Gson;

public class UserDao {

	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(UserDao.class);

	private static final String INSERT_PERSONAL_INFORMATION = "INSERT INTO TWITTER_USER_INFORMATION (user_id,friends_count,followers_count,NAME,SCREEN_NAME,LOCATION,DESCRIPTION,URL,LANG,UTC_OFFSET,TIME_ZONE,LISTED_COUNT,STATUES_COUNT,FAVOURITES_COUNT,CREATED_AT,INSERT_TIME) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static void insertinfo(User usersManager) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			logger.info("AAAAAAAAA");
			ConnPool.getInstance().init();
			con = ConnPool.getInstance().getConnection();
			logger.info("AAAAAAAAA");
			// Class.forName("oracle.jdbc.driver.OracleDriver");

			logger.info("AAAAAAAAA");
			// DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

			/*
			 * con= DriverManager.getConnection(
			 * "jdbc:oracle:thin:@localhost:1521:xe", "social", "social");
			 * logger.info("AAAAAAAAA");
			 */
			stmt = con.prepareStatement(INSERT_PERSONAL_INFORMATION);

			logger.info("AAAAAAAAA");
			stmt.setLong(1, usersManager.getId());
			stmt.setLong(2, usersManager.getFriendsCount());
			stmt.setLong(3, usersManager.getFollowersCount());

			stmt.setString(4, usersManager.getName());
			stmt.setString(5, usersManager.getScreenName());
			stmt.setString(6, usersManager.getLocation());

			stmt.setString(7, usersManager.getDescription());
			stmt.setString(8, usersManager.getURL());
			stmt.setString(9, usersManager.getLang());
			stmt.setLong(10, usersManager.getUtcOffset());
			stmt.setString(11, usersManager.getTimeZone());
			// stmt.setBoolean(12, usersManager.isGeoEnabled());

			logger.info("AAAAAAAAA");
			// stmt.setBoolean(13, usersManager.isVerified());
			// stmt.setBoolean(14, usersManager.isProtected());

			stmt.setLong(12, usersManager.getListedCount());
			stmt.setLong(13, usersManager.getStatusesCount());
			stmt.setLong(14, usersManager.getFavouritesCount());
			// stmt.setObject(15, usersManager.getCreatedAt());

			DateTime dt = new DateTime(usersManager.getCreatedAt());
			stmt.setTimestamp(15, new Timestamp(dt.getMillis()));

			Long d = System.currentTimeMillis();
			stmt.setTimestamp(16, new Timestamp(d / 1000));

			stmt.executeUpdate();
			con.commit();

		} catch (Exception e) {
			logger.error("Couldn't insert user info to database : " + e);
		} finally {
			SQLUtil.forceCloseConnection(con, stmt, rs);
		}

	}
}
