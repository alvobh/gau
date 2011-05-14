package gau.models;

class Team implements Comparable {

   private String _name;
   
   public Team (String name) {
	   _name = name;
   }

   public int compareTo (Object obj) {
	   return _name.compareTo (((Team) obj)._name);
   }

   public String toString () {
	   return _name;
   }

}
