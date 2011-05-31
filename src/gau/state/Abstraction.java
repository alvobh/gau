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

   public final List<AbstractType> get(Class<? extends AbstractType> type) {
      try {
         ResultSet query = db.get("type", name(type));
         List<AbstractType> results = new ArrayList<AbstractType>();
         while (query.next()) {
            AbstractType entity = type.newInstance();
            long id = query.getLong("id");
            entity.setID(id);
            results.add(entity);
            complete(entity);
         }
         return results;
      } catch (Exception e) {
         System.out.println("Couldn't get list of entities! " + e);
         return null;
      }
   }

   @SuppressWarnings("unchecked")
   public final void complete(final AbstractType entity) {
      try {
         ResultSet results = db.get(entity.getID());
         results.next();
         while (results.next()) {
            String key = results.getString("key");
            try {
               Class<AbstractType> stype =
                  (Class<AbstractType>) Class.forName(key);
               AbstractType slave = stype.newInstance();
               long id = results.getLong("value");
               slave.setID(id);
               entity.set(slave);
               complete(slave);
            } catch (ClassNotFoundException e) {
               String value = results.getString("value");
               entity.set(key, value);
            }
         }
      } catch (Exception e) {
         System.out.println("Couldn't get entity!");
      }
   }

   public final void create(final AbstractType entity) {
      try {
         long id = db.insert("type", name(entity));
         entity.setID(id);
      } catch (SQLException e) {
         System.out.println("Couldn't save entity");
      }
   }

   public final void relate(final AbstractType master,
         final AbstractType slave) {
      try {
         db.insert(master.getID(), name(slave),
               slave.getID() + "");
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

   private String name(final Class<? extends AbstractType> type) {
      return type.getName();
   }

   private String name(final AbstractType entity) {
      return name(entity.getClass());
   }

}
