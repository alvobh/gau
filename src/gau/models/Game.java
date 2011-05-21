package gau.models;

import java.util.ArrayList;
import java.lang.Thread;

public class Game {

   private int[] _points;
   private String _name;
   private ArrayList<RealTeam> _podium, _teams;
   
   PlugBoard _plugs;
   boolean[] _podiumCheck;
   int _place;

   public Game (ArrayList<RealTeam> teams) {
	   _teams  = teams;
	   _podium = new ArrayList<RealTeam> ();
   }

   public Game (String name, int[] points, ArrayList<RealTeam> teams) {
	   _name   = name;
	   _points = points;
	   _teams  = teams;
	   _podium = new ArrayList<RealTeam> ();
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
	   String aux = "-----------\n";
	   for (int i = 0; i < _podium.size(); i++) {
	      aux += (i+1) + ". " + _podium.get(i);
	      if (_points != null)
	         aux += " : " + _points[i] + "ptos";
	      aux += "\n";
	   }
	   return aux;
   }

   public int size () {
	   return _points.length;
   }

   public String toString () {
	   return _name;
   }

   public boolean start (){

      try {
        //  _plugs = new PlugBoard();
         _podiumCheck = new boolean[_teams.size()];
         _place = 1;
      } catch (UnsatisfiedLinkError e) {
         System.out.println ("Driver do EasyLab não encontrado!");
         return false;
      } catch (Exception e) {
         System.out.println (e);
         return false; 
      }
      
      return true;

   }
   
   public String resume () throws Exception{
       boolean changed = false;
       String update = "";
       while (!changed && _podium.size() < _teams.size()) {
    	  boolean[] active = _plugs.read();
		  int i = 0;
		  while (i < active.length) {
			 if (active[i] && !_podiumCheck[i]) {
				_podiumCheck[i] = true;
			    _podium.add(_teams.get(i));
			    update += (_place++) + ". " +  _teams.get(i) + "\n";
			    changed = true;
			 }
			 i++;
		  }
       }
       return update;
   }
   
   public String test () {
	   try {Thread.sleep(2000);} catch(Exception e){}
	   _podiumCheck[_place-1] = true;
	   _podium.add(_teams.get(_place-1));
	   return _place  + ". " +  _teams.get((_place++)-1) + "\n";
   }
 
    public boolean isActive() {
    	return _podium.size() < _teams.size();
    }

	public String finish() {
	  int i = 0;
      String update = "";
	  while (i < _podiumCheck.length) {
		 if (!_podiumCheck[i]) {
			 _podium.add(_teams.get(i));
			 update += (_place++) + ". " +  _teams.get(i) + "\n";
		 }
		 i++;
      }
	  return update;	
	}

}



