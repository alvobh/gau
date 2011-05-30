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

   public final List<GauType> get(String type) {
      try {
         ResultSet query = db.get("type", type);
         List<GauType> results = new ArrayList<GauType>();
         while (query.next()) {
            long id = query.getLong("id");
            RealTeam rteam = new RealTeam(id);
            results.add(rteam);
            get(rteam);
         }
         return results;
      } catch (SQLException e) {
         System.out.println("Couldnt get list of entities!");
         return null;
      }
   }

   public final void get (GauType entity) {
      try {
         ResultSet results = db.get(entity.getID());
         String type = "";
         while (results.next()) {
            String key = results.getString("key");
            if (key.equals("type")) {
               type = results.getString("value");
            }
            break;
         }
         if (type.equals("RealTeam")) {
            RealTeam rteam = (RealTeam) entity;
            while (results.next()) {
               String key = results.getString("key");
               if (key.equals("Team")) {
                  long id = results.getLong("value");
                  Team team = new Team(id);
                  rteam.add(team);
                  get(team);
               }
            }
         } else if (type.equals("Team")) {
            Team team = (Team) entity;
            while (results.next()) {
               String key = results.getString("key");
               if (key.equals("name")) {
                  String name = results.getString("value");
                  team.setName(name);
               }
            }
         }
      } catch (SQLException e) {
         System.out.println("Couldnt get entity!");
      }
   }
   
   private void create(GauType entity) {
      try {
         long id = db.insert("type", entity.getClass().getSimpleName());
         entity.setID(id);
      } catch (SQLException e) {
         System.out.println("Couldnt save GauType");
      }
   }

   private void relate(final GauType master, final GauType thing) {
      try {
         db.insert(master.getID(), thing.getClass().getSimpleName(),
               thing.getID() + "");
      } catch (SQLException e) {
         System.out.println("Couldn't relate GauType");
      }
   }

   private void relate(final GauType master, final String relation,
         final String thing) {
      try {
         db.insert(master.getID(), relation, thing);
      } catch (SQLException e) {
         System.out.println("Couldn't relate GauType");
      }
   }
   
   // temp methods:

   public List<RealTeam> getTeams() {
      List<GauType> query = get(RealTeam.class.getSimpleName());
      List<RealTeam> results = new ArrayList<RealTeam>();
      for (GauType gt : query) {
         RealTeam rteam = (RealTeam) gt;
         results.add(rteam);
      }
      return results;
   }   

   private void populate(final String file)
         throws FileNotFoundException {
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

}
