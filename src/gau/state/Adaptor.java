package gau.state;

import gau.models.RealTeam;
import gau.models.Team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mateusgm
 *
 */
class Adaptor {

   /**
    * SQLite connection.
    */
   private Connection db;

   /**
    * SQLite query handler.
    */
   private Statement query;

   /**
    * @param file
    * @throws SQLException
    * @throws ClassNotFoundException
    */
   public Adaptor(final String file)
      throws SQLException, ClassNotFoundException {
      init(file);
      migrate();
      System.out.println ("migrated!");
      populate();
   }

   /**
    * @param file
    * @throws SQLException
    * @throws ClassNotFoundException
    */
   private void init(final String file)
      throws SQLException, ClassNotFoundException {
      Class.forName("org.sqlite.JDBC");
      db = DriverManager.getConnection("jdbc:sqlite:" + file);
      query = db.createStatement();
   }

   /**
    * @throws SQLException
    */
   private void migrate() throws SQLException {
      query.executeUpdate("DROP TABLE IF EXISTS teams");
      query.executeUpdate("CREATE TABLE teams ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name VARCHAR(50) NOT NULL)");
   }

   private void populate() throws SQLException {
      query.executeUpdate("INSERT into teams (name) VALUES ('FlashBack')");
      query.executeUpdate("INSERT into teams (name) VALUES ('Bakon')");
   }

   public final List<RealTeam> getTeams() throws SQLException {
      ResultSet results = query.executeQuery(
            "SELECT * FROM teams ORDER BY id");
      ArrayList<RealTeam> teams = new ArrayList<RealTeam>();
      while (results.next()) {
         System.out.println (results.getInt("id"));
         String name = results.getString("name");
         teams.add(new RealTeam(new Team(name)));
      }
      return teams;
   }




}
