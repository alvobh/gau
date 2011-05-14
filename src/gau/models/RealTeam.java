package gau.models;

import java.util.TreeSet;

public class RealTeam {

   private TreeSet<Team> _teams;

   public RealTeam () {
	   _teams = new TreeSet<Team> ();
	}

   public RealTeam (Team t) {
	   _teams = new TreeSet<Team> ();
	   _teams.add (t);
   }

   public boolean add (Team t) {
	   return _teams.add (t);
   }

   public boolean contains (Team t) {
	   return _teams.contains (t);
   }

   public String toString () {
	   return _teams.toString ();
   }

}
