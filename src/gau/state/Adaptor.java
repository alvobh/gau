package gau.state;

import gau.models.RealTeam;
import gau.models.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mateusgm
 *
 */
class Adaptor {

   private DB db;

   /**
    * @param file
    * @throws SQLException
    * @throws ClassNotFoundException
    */
   public Adaptor(final String file)
      throws SQLException, ClassNotFoundException, FileNotFoundException {
      db = new DB(file);
      // db.migrate();
      // populate("times.txt");
   }


   private void populate(final String file)
      throws SQLException, FileNotFoundException {
      Scanner scanner = new Scanner(new File(file));
      while (scanner.hasNext()) {
         String name = scanner.nextLine();
         db.insert("team", name, 0);
      }
      scanner.close();
   }

   public final List<RealTeam> getTeams() throws SQLException {
      ResultSet results = db.query("team", 0);
      List<RealTeam> teams = new ArrayList<RealTeam>();
      while (results.next()) {
         String name = results.getString("value");
         teams.add(new RealTeam(new Team(name)));
      }
      return teams;
   }

}
