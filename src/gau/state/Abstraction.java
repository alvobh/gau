package gau.state;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
      } catch (Exception e) {
         System.out.println("Couldn't init db!");
      }
   }

   @SuppressWarnings("unchecked")
   public final void save(final AbstractType entity) {
      try {
         create(entity);
         Field[] fields = entity.getClass().getFields();
         for (Field field : fields) {
            String name = field.getName();
            Class<?> type = field.getType();
            if (type.isAssignableFrom(AbstractType.class)) {
               AbstractType slave = (AbstractType) field.get(entity);
               save(slave);
               relate(entity, name, slave);
            } else if (type.isAssignableFrom(Set.class)) {
               Set<AbstractType> slaves = (Set<AbstractType>) field.get(entity);
               for (AbstractType slave : slaves) {
                  save(slave);
                  relate(entity, name, slave);
               }
            } else if (type.isAssignableFrom(String.class)
                        || type.isPrimitive()) {
               String slave = (String) field.get(entity);
               relate(entity, name, slave);
            }
         }
      } catch (Exception e) {
         System.out.println("Couldn't save entity! " + e);
      }
   }

   public final List<AbstractType> get(
         final Class<? extends AbstractType> type) {
      try {
         ResultSet query = db.get("type", name(type));
         List<AbstractType> results = new ArrayList<AbstractType>();
         while (query.next()) {
            AbstractType entity = type.newInstance();
            long id = query.getLong("id");
            entity.setID(id);
            results.add(entity);
            fill(entity);
         }
         return results;
      } catch (Exception e) {
         System.out.println("Couldn't get list of entities!");
         return null;
      }
   }

   @SuppressWarnings("unchecked")
   public final void fill(final AbstractType entity) {
      try {
         ResultSet results = db.get(entity.getID());
         results.next();
         while (results.next()) {
            String[] key = results.getString("key").split(":");
            if (key.length > 1) {
               Class<AbstractType> stype =
                  (Class<AbstractType>) Class.forName(key[0]);
               AbstractType slave = stype.newInstance();
               long id = results.getLong("value");
               slave.setID(id);
               entity.set(key[1], slave);
               fill(slave);
            } else {
               String value = results.getString("value");
               entity.set(key[0], value);
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
         final String relation, final AbstractType thing) {
      relate(master.getID(), name(thing) + ":" + relation, thing.getID() + "");
   }

   public final void relate(final AbstractType master,
         final String relation, final String thing) {
      relate(master.getID(), relation , thing);
   }

   public final void relate(final long id, final String key,
         final String value) {
      try {
         db.insert(id, key, value);
      } catch (SQLException e) {
         System.out.println("Couldn't create relation");
      }
   }

   public final void debug() {
      try {
         ResultSet results = db.debug();
         while (results.next()) {
            long id = results.getLong("id");
            String key = results.getString("key");
            String value = results.getString("value");
            System.out.println(id + ", '" + key + "', '" + value + "'");
         }
      } catch (SQLException e) {
         System.out.println("Couldn't debug");
      }
   }

   private String name(final Class<? extends AbstractType> type) {
      return type.getName();
   }

   private String name(final AbstractType entity) {
      return name(entity.getClass());
   }

   public final void clean() {
      try {
         db.clean();
      } catch (SQLException e) {
         System.out.println("Couldn't clean DB");
      }
   }

   public final void make() {
      try {
         db.make();
      } catch (SQLException e) {
         System.out.println("Couldn't make DB (create tables)");
      }
   }

   public final void close() {
      try {
         db.close();
         db = null;
      } catch (SQLException e) {
         System.out.println("Couldn't close connection");
      }
   }

}
