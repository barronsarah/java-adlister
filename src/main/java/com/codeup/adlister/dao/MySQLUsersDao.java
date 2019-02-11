package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.*;


public class MySQLUsersDao implements Users {

  Connection connection;
  PreparedStatement stmt;
  String searchTerm = null;

  @Override
  public User findByUsername(String username) {
    try {
      String sql = "Select * from users where username like ?";
      username = "%" + username + "%";

      stmt = connection.prepareStatement(sql);
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();

      rs.next();
        User user = new User(
                  rs.getLong("id"),
                  rs.getString("username"),
                  rs.getString("email"),
                  rs.getString("password")
                  );

      return user;
    } catch (SQLException e) {
      throw new RuntimeException("Error with user search!", e);
        }
    }


  @Override
  public Long insert(User user) {

    try {
      stmt = connection.prepareStatement(addUserQuery(user), Statement.RETURN_GENERATED_KEYS);
      stmt.executeUpdate();
      ResultSet rs = stmt.getGeneratedKeys();
      rs.next();
      return rs.getLong(1);
    } catch (SQLException e) {
      throw new RuntimeException("Error creating new user.", e);
        }
  }

  public String addUserQuery(User user) throws SQLException {
    String sql = "INSERT INTO users(username, email, password VALUES(?,?,?)";
           stmt.setString(1, user.getUsername());
           stmt.setString(2, user.getEmail());
           stmt.setString(3, user.getPassword());
           return sql;
    }


}
