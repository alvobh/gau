package gau.models;

import java.util.TreeSet;

class RealTeam {

   private TreeSet<Team> _teams;
   private int _plugID;

   public RealTeam (Team t, int plugID) {
	   _teams = new TreeSet<Team> ();
	   _teams.add (t);
	   _plugID = plugID;
   }

   public boolean add (Team t) {
	   return _teams.add (t);
   }

   public boolean contains (Team t) {
	   return _teams.contains (t);
   }

   public String toString () {
	   return "[" + _plugID + "] " + _teams.toString ();
   }

}
