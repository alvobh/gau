package gau.models;

import java.util.ArrayList;
import java.util.TreeSet;

class Game
{
   private int[] _points;
   private String _name;
   private ArrayList<RealTeam> _podium, _teams;

   public Game (String name, String points, int nteams) {
	   _points = parsePoints(points, nteams);
	   _name = name;
	   _podium = new ArrayList<RealTeam> (nteams);
   }
   
   public int[] parsePoints (String points, int nteams) {

   	int[] p_aux = new int[nteams];
	   String[] aux = points.split ("/");
	   boolean parser = true;
	   int end = 0;

	   for (int i = 0; i < nteams; i++) {
	      if (parser) {
		      if (i == aux.length) { 
		         parser = false;
		         end = 0;
		      } else if (aux[i].equals("...")) {
		         parser = false;
		         end = p_aux[i-1];
		      } else {
		         end = Integer.parseInt(aux[i]);
		      }
	      }
	      p_aux[i] = end;
	   }
   
      return p_aux;
   
   }

   public String results () {
	   String aux = "";
	   for (int i = 0; i < _podium.size(); i++) {
	      aux += (i+1) + ". " + _podium.get(i);
	      aux += " : " + _points[i] + "ptos\n";
	   }
	   return aux;
   }

   public int size () {
	   return _points.length;
   }

   public String toString () {
	   return _name;
   }

   public void startWithPlugs () throws Exception {
   
      PlugBoard plugs = new PlugBoard();
      boolean[] active, podium;
      podium = new boolean[_points.length];
      
      while (_podium.size() < _points.length) {
		   active = plugs.read();
		   int i = 0;
		   while (i < active.length) {
			   if (active[i] && !podium[i]) {
			      podium[i] = true;
			      _podium.add(_teams.get(i));
			   }
			   i++;
		   }
      }

   }

}



