package gau.state;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DB {

   /**
    * SQLite connection.
    */
   private Connection db;

   public DB(final String file)
         throws SQLException, ClassNotFoundException {
      Class.forName("org.sqlite.JDBC");
      db = DriverManager.getConnection("jdbc:sqlite:" + file);
   }

   public final ResultSet get(final long id) throws SQLException {
      String query = "SELECT key,value "
                       + "FROM data "
                       + "WHERE id = " + id + " "
                       + "ORDER BY id ASC";
      Statement stm = db.createStatement();
      return stm.executeQuery(query);
   }

   public final ResultSet get(final String key, final String value)
         throws SQLException {
      String query = "SELECT id "
                       + "FROM data "
                       + "WHERE key= '" + key + "' "
                       + "AND value= '" + value + "' "
                       + "ORDER BY id ASC";
      Statement stm = db.createStatement();
      return stm.executeQuery(query);
   }

   public final long insert(final String key, final String value)
         throws SQLException {
      String query = "INSERT into data (id,key,value) "
                          + "VALUES (last_insert_rowid()+1, "
                                  + "'" + key    + "', "
                                  + "'" + value  + "')";
      Statement stm = db.createStatement();
      stm.executeUpdate(query);
      ResultSet results = stm.getGeneratedKeys();
      return results.getLong(1);
   }

   public final void insert(final long id, final String key,
         final String value) throws SQLException {
      String query = "INSERT into data (id,key,value) "
                          + "VALUES (" + id      + ", "
                                  + "'" + key    + "', "
                                  + "'" + value  + "')";
      Statement stm = db.createStatement();
      stm.executeUpdate(query);
   }

   public final void update(final long id, final String key,
         final String value) throws SQLException {
      String query = "UPDATE data "
                          + "SET value = '" + value + "' "
                          + "WHERE id = " + id + " "
                          + "AND key = '" + key + "'";
      Statement stm = db.createStatement();
      stm.executeUpdate(query);
   }

   public final void remove(final long id) throws SQLException {
      String query = "REMOVE FROM data "
                          + "WHERE id = " + id + " ";
      Statement stm = db.createStatement();
      stm.executeUpdate(query);
   }

   public final ResultSet debug() throws SQLException {
      String query = "SELECT * FROM data ORDER BY id ASC";
      Statement stm = db.createStatement();
      return stm.executeQuery(query);
   }

   public final void clean() throws SQLException {
      Statement stm = db.createStatement();
      stm.executeUpdate("DROP TABLE IF EXISTS data");
   }

   public final void make() throws SQLException {
      Statement stm = db.createStatement();
      stm.executeUpdate("CREATE TABLE data ("
            + "id INTEGER NOT NULL,"
            + "key VARCHAR(50) NOT NULL,"
            + "value VARCHAR(50) NOT NULL)");
   }

   public final void close() throws SQLException {
      db.close();
      db = null;
   }

}
