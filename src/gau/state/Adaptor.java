package gau.state;

import gau.models.RealTeam;
import gau.models.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
      db.migrate();
      populate("times.txt");
   }


   private void populate(final String file)
      throws SQLException, FileNotFoundException {
      Scanner scanner = new Scanner(new File(file));
      RealTeam rteam = new RealTeam();
      while (scanner.hasNext()) {
         String name = scanner.nextLine();
         if (name.charAt(0) == ' ') {
            Team team = new Team(name.substring(1));
            rteam.add(team);
         } else {
             Team team = new Team(name);
             rteam = new RealTeam(team);
             save(rteam);
         }
      }
      scanner.close();
   }

   public final void save (Team team) {
      create(team);
      relate (team, "name", team.getName());
   }

   public final void save (RealTeam rteam) {
      create(rteam);
      Set<Team> teams = rteam.getTeams();
      for (Team team : teams) {
         save (team);
         relate(rteam, team);
      }

   }

   private void create (GauType entity) {
      try {
         long id = db.insert("type", entity.getClass().getSimpleName());
         entity.setID(id);
      } catch (SQLException e) {
         System.out.println ("Couldnt save team");
      }
   }

   private void relate (GauType master, GauType thing) {
      try {
         db.insert(master.getID(), thing.getClass().getSimpleName(),
               thing.getID() + "");
      } catch (SQLException e) {
         System.out.println ("Couldn't relate GauType");
      }
   }

   private void relate (GauType master, String relation, String thing) {
      try {
         db.insert(master.getID(), relation, thing);
      } catch (SQLException e) {
         System.out.println ("Couldn't relate GauType");
      }
   }

   public final List<RealTeam> getTeams() throws SQLException {
      ResultSet results = db.get(Team.class.getSimpleName());
      List<RealTeam> teams = new ArrayList<RealTeam>();
      while (results.next()) {
         String name = results.getString("value");
         teams.add(new RealTeam(new Team(name)));
      }
      return teams;
   }

}
