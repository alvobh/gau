package gau.models;

import gau.state.AbstractType;

/**
 * Entity that models a team.
 * @author mateusgm
 *
 */
public class Team implements Comparable<Team>, AbstractType {

   /**
    * Name of the team.
    */
   public String name;

   /**
    * Name of the team.
    */
   private long id;

   public Team() {
      setID(0);
      setName(null);
   }

   public Team(final long idp) {
      setID(idp);
   }

   /**
    * @param namep - name of the team.
    */
   public Team(final String namep) {
      setName(namep);
   }

   public final String getName() {
      return name;
   }

   public final void setName(final String namep) {
      name = namep;
   }

   @Override
   public final void setID(final long idp) {
      id = idp;
   }

   @Override
   public final long getID() {
      return id;
   }

   @Override
   public final void set(final String key, final AbstractType slave) {
      return;
   }

   @Override
   public final void set(final String key, final String value) {
      if (key.equals("name")) {
         setName(value);
      }
   }

   /* (non-Javadoc)
    * @see java.lang.Comparable#compareTo(java.lang.Object)
    */
   @Override
   public final int compareTo(final Team t) {
      return name.compareTo(t.name);
   }

   @Override
   public final String toString() {
      return name;
   }

}