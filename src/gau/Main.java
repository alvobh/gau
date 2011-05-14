package gau;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import gau.models.*;

public class Main {

   public static void main(String[] args) throws Exception{
	   ArrayList<RealTeam> teams = getTeams();
	   System.out.println (teams);
	   Game prova = new Game(teams);
	   prova.startWithPlugs();
	   System.out.println (prova.results());
   }
   
   private static ArrayList<RealTeam> getTeams () throws Exception{
   
      Scanner scanner = new Scanner(new File("times.txt"));  
      ArrayList<RealTeam> teams = new ArrayList<RealTeam>();
      RealTeam team = new RealTeam();
      while ( scanner.hasNext() ) {  
         String name = scanner.nextLine();
         if (name.charAt(0) == ' ') {
            Team aux = new Team (name.substring(1));
            team.add(aux);
         } else {
            Team aux = new Team (name);
            team = new RealTeam(aux);
            teams.add(team);
         }
      }
      scanner.close(); 
      return teams;

   }

}


