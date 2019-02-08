import com.mysql.cj.jdbc.Driver;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

  private Connection connection = null;

  public MySQLAdsDao(Config config) {
    try {
      DriverManager.registerDriver(new Driver());
       connection = DriverManager.getConnection(
              config.getUrl(),
              config.getUsername(),
              config.getPassword()
      );
    } catch (SQLException e) {
      throw new RuntimeException("Error connecting to the database!", e);
    }
  }

  @Override
  public List<Ad> all() {
    List<Ad> ads = new ArrayList<>();

    try {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
      while (rs.next()) {
        ads.add(new Ad(
                rs.getLong("id"),
                rs.getString("user_id"),
                rs.getString("title"),
                rs.getString("description")
        ));
      }
      return ads;
    }catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Long insert(Ad ad) {
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(adInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);

    } catch (SQLException e){
      throw new RuntimeException("Error creating new ad.", e);
    }
    return null;
  }

  private String adInsertQuery(Ad ad){
    return "INSERT INTO ads(user_id, title, description) VALUES" +
            "(" + ad.getUserId() + "," +
            "'" + ad.getTitle() + "'," +
            "'" + ad.getDescription() + "'";
  }


  public static void main(String[] args) {
    Config config = new Config();
    MySQLAdsDao dao = new MySQLAdsDao(config);
  }
}
