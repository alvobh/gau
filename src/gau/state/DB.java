package gau.state;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

   /**
    * SQLite connection.
    */
   private Connection db;

   /**
    * SQLite query handler.
    */
   private Statement query;

   public DB(final String file)
      throws SQLException, ClassNotFoundException {
      Class.forName("org.sqlite.JDBC");
      db = DriverManager.getConnection("jdbc:sqlite:" + file);
      query = db.createStatement();
   }

   /**
    * @throws SQLException
    */
   public void migrate() throws SQLException {
      query.executeUpdate("DROP TABLE IF EXISTS things");
      query.executeUpdate("CREATE TABLE things ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "key VARCHAR(50) NOT NULL,"
            + "value VARCHAR(50) NOT NULL,"
            + "id_holder INTEGER NOT NULL)");
   }


   public final ResultSet query(final String key, final int holder)
      throws SQLException {
      String statement = "SELECT id,value "
                          + "FROM things "
                          + "WHERE key = '" + key + "' "
                          + "AND id_holder = " + holder;
      return query.executeQuery(statement);
   }

   public final void insert(final String key, final String value,
         final int holder) throws SQLException {
      String statement = "INSERT into things (key, value, id_holder) "
                          + "VALUES ('" + key    + "', "
                                  + "'" + value  + "', "
                                        + holder + ")";
      query.executeUpdate(statement);
   }

   private void update(final int id, final String value,
         final int holder) throws SQLException {
      String statement = "UPDATE things "
                          + "SET value = '" + value + "' "
                          + "AND id_holder = " + holder + " "
                          + "WHERE id = " + id;
      query.executeUpdate(statement);
   }

}
