package gau.models;

/**
 * Entity that models a team.
 * @author mateusgm
 *
 */
public class Team implements Comparable<Team> {

   /**
    * Name of the team.
    */
   private String name;

   /**
    * Name of the team.
    */
   private long id;

   /**
    * @param namep - name of the team.
    */
   public Team(final String namep) {
      name = namep;
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

   public final void setID(long idp) {
      id = idp;      
   }
   
   public final long getID() {
      return id;   
   }

   public final String getName() {
      return name;
   }

}