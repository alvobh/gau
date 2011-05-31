package gau.state;

import gau.models.RealTeam;
import gau.models.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mateusgm
 *
 */
class Persistence {

   private Abstraction db;

   public Persistence() throws FileNotFoundException {
      db = new Abstraction();
      populate("times.txt");
   }

   // temp methods:

   public List<RealTeam> getTeams() {
      List<AbstractType> query = db.get(RealTeam.class);
      List<RealTeam> results = new ArrayList<RealTeam>();
      for (AbstractType gt : query) {
         RealTeam rteam = (RealTeam) gt;
         results.add(rteam);
      }
      return results;
   }

   private void populate(final String file)
         throws FileNotFoundException {
      Scanner scanner = new Scanner(new File(file));
      RealTeam rteam = new RealTeam();
      while (scanner.hasNext()) {
         String name = scanner.nextLine();
         if (name.charAt(0) == ' ') {
            Team team = new Team(name.substring(1));
            rteam.add(team);
         } else {
             Team team = new Team(name);
             rteam = new RealTeam(team);
             db.save(rteam);
         }
      }
      scanner.close();
   }

}
