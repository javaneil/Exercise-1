package edu.matc.persistence;

import edu.matc.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {
    private final Logger logger = Logger.getLogger( this.getClass() );

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM users";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: ", e);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: ", e);
        }
        return users;
    }

    //TODO reduce the redundant code here...

    public List<User> getUsersByLastName( String lastname ) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM users WHERE last_name LIKE '"
                + lastname + "%'" ;

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.info("SearchUser.getAllUsers()...SQL Exception: ", e); // include stacktrace
        } catch (Exception e) {
            logger.info("SearchUser.getAllUsers()...Exception: ", e); // include stacktrace
        }
        return users;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name")); //2017-01-18nkf
        user.setUserid(results.getString("id"));            //2017-01-18nkf
        user.setBirthDate(results.getDate("date_of_birth")) ; //2017-01-21nkf

        return user;
    }
}