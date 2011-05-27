package gau.models;

import java.util.TreeSet;

/**
 * @author mateusgm
 *
 */
public class RealTeam {

   /**
    * the teams contained on this RealTeam.
    */
   private TreeSet<Team> teams;

   /**
    * Creates a RealTeam.
    */
   public RealTeam() {
      teams = new TreeSet<Team>();
   }

   /**
    * Create a RealTeam.
    * @param t - team with which the RealTeam will be created.
    */
   public RealTeam(final Team t) {
      teams = new TreeSet<Team>();
      teams.add(t);
   }

   /**
    * Adds a Team to a RealTeam.
    * @param t - the team to be added to the RealTeam.
    * @return true if it was added, false otherwise.
    */
   public final boolean add(final Team t) {
      return teams.add(t);
   }

   /**
    * Checks if a RealTeam contains a Team.
    * @param t - Team to be checked.
    * @return true if it contains, false otherwise.
    */
   public final boolean contains(final Team t) {
      return teams.contains(t);
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public final String toString() {
      String results = null;
      for (Team team : teams) {
         if (results == null) {
            results = team.toString();
         } else {
            results += ", " + team.toString();
         }
      }
      return results;
   }

}
