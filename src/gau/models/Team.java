package gau.models;

public class Team implements Comparable<Team> {

   private String _name;
   
   public Team (String name) {
	   _name = name;
   }

   public int compareTo (Team t) {
	   return _name.compareTo (t._name);
   }

   public String toString () {
	   return _name;
   }

}
