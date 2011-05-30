package gau.state;

import gau.models.RealTeam;
import gau.models.Team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Abstraction {

   private DB db;

   /**
    * @param file
    * @throws SQLException
    * @throws ClassNotFoundException
    */
   public Abstraction() {
      try {
         db = new DB("2011.db");
         db.migrate();
      } catch (Exception e) {
         System.out.println("Couldn't init db!");
      }
   }

   public final List<AbstractType> get(String type) {
      try {
         ResultSet query = db.get("type", type);
         List<AbstractType> results = new ArrayList<AbstractType>();
         while (query.next()) {
            long id = query.getLong("id");
            RealTeam rteam = new RealTeam(id);
            results.add(rteam);
            get(rteam);
         }
         return results;
      } catch (SQLException e) {
         System.out.println("Couldn't get list of entities!");
         return null;
      }
   }

   public final void get (AbstractType entity) {
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
         System.out.println("Couldn't get entity!");
      }
   }

   public final void create(AbstractType entity) {
      try {
         long id = db.insert("type", entity.getClass().getSimpleName());
         entity.setID(id);
      } catch (SQLException e) {
         System.out.println("Couldn't save entity");
      }
   }

   public final void relate(final AbstractType master,
         final AbstractType thing) {
      try {
         db.insert(master.getID(), thing.getClass().getSimpleName(),
               thing.getID() + "");
      } catch (SQLException e) {
         System.out.println("Couldn't relate entities");
      }
   }

   public final void relate(final AbstractType master,
         final String relation, final String thing) {
      try {
         db.insert(master.getID(), relation, thing);
      } catch (SQLException e) {
         System.out.println("Couldn't create relation");
      }
   }

}
