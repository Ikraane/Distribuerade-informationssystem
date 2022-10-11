package com.test.dao;

import com.test.beans.User;

import java.sql.*;

public class DBUser extends User {


	protected DBUser(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}

	public static boolean validateUser(String username, String password) {
		boolean isValidUser = false;
		try {

			// get the connection for the database
			Connection connection = DBConnection.getConnectionToDatabase();

			// write the select query
			String sql = "select * from fruit.users where username=? and password=?";

			// set parameters with PreparedStatement
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);

			// execute the statement and check whether user exists

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				isValidUser = true;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return isValidUser;
	}


}