package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.*;


public class MySQLUsersDao implements Users {

  Connection connection;
  PreparedStatement stmt;
  String searchTerm = null;


// not sure if a driver is needed on every dao file -
  public MySQLUsersDao(Config config){
    try {
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
      connection = DriverManager.getConnection(
              config.getUrl(),
              config.getUser(),
              config.getPassword()
      );
    } catch (SQLException e) {
      throw new RuntimeException("Error connecting to the database!", e);
    }
  }

  @Override
  public User findByUsername(String username) {
    User user = null;
    try {
      String sql = "Select * from users where username = ?";
  // username = "'%" + username + "%'"; <-- don't need this due to only searching for a one user with searched username

      stmt = connection.prepareStatement(sql);
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()) {
        user = new User(
                  rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
      }
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

  private String addUserQuery(User user) throws SQLException {
    String sql = "INSERT INTO users(username, email, password VALUES(?,?,?)";
           stmt.setString(1, user.getUsername());
           stmt.setString(2, user.getEmail());
           stmt.setString(3, user.getPassword());
           return sql;
    }


}
