package gau.state;

public interface AbstractType {

   long getID();
   void setID(final long id);
   void set(final AbstractType slave);
   void set(final String key, final String value);

}
