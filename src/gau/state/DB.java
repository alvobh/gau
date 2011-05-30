package gau.state;

import java.io.FileNotFoundException;
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
      query.executeUpdate("DROP TABLE IF EXISTS data");
      query.executeUpdate("CREATE TABLE data ("
            + "id INTEGER NOT NULL,"
            + "key VARCHAR(50) NOT NULL,"
            + "value VARCHAR(50) NOT NULL)");
   }

   public final ResultSet get(final int id) throws SQLException {
      String statement = "SELECT key,value "
                       + "FROM data "
                       + "WHERE id = " + id + " "
                       + "ORDER BY key ASC";
      return query.executeQuery(statement);
   }

   public final ResultSet get(final String key) throws SQLException {
      String statement = "SELECT id,value "
                       + "FROM data "
                       + "WHERE key = '" + key + "' "
                       + "ORDER BY id ASC";
      return query.executeQuery(statement);
   }

   public final long insert(final String key, final String value)
         throws SQLException {
      String statement = "INSERT into data (id,key,value) "
                          + "VALUES (last_insert_rowid()+1, "
                                  + "'" + key    + "', "
                                  + "'" + value  + "')";
      query.executeUpdate(statement);
      ResultSet results = query.getGeneratedKeys();
      return results.getLong(1);
   }

   public final void insert(final long id, final String key,
         final String value) throws SQLException {
      String statement = "INSERT into data (id,key,value) "
                          + "VALUES (" + id      + ", "
                                  + "'" + key    + "', "
                                  + "'" + value  + "')";
      query.executeUpdate(statement);
   }

   public final void update(final int id, final String key,
         final String value) throws SQLException {
      String statement = "UPDATE data "
                          + "SET value = '" + value + "' "
                          + "WHERE id = " + id + " "
                          + "AND key = '" + key + "'";
      query.executeUpdate(statement);
   }

   public final void remove(final int id) throws SQLException {
      String statement = "REMOVE FROM data "
                          + "WHERE id = " + id + " ";
      query.executeUpdate(statement);
   }

}
