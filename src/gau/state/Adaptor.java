package gau.state;

import gau.models.RealTeam;
import gau.models.Team;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Adaptor {
   
   public static ArrayList<RealTeam> getTeams() throws Exception {
      Scanner scanner = new Scanner(new File("times.txt"));
      ArrayList<RealTeam> teams = new ArrayList<RealTeam>();
      RealTeam team = new RealTeam();
      while (scanner.hasNext()) {
          String name = scanner.nextLine();
          if (name.charAt(0) == ' ') {
             Team aux = new Team(name.substring(1));
             team.add(aux);
          } else {
              Team aux = new Team(name);
              team = new RealTeam(aux);
              teams.add(team);
          }
      }
      scanner.close();
      return teams;
   }

}
