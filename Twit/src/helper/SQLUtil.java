package helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUtil {

    public static void forceCloseConnection(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
				;
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
	            ;            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
	            ;            }
        }

    }

    public static void rollback(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
	            ;
            }
        }

    }

}
