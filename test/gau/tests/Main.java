package gau.tests;

import gau.gui.GuiMain;
import gau.models.RealTeam;
import gau.models.Team;
import gau.state.Abstraction;
import gau.state.State;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

   /**
    * @param args
    */
   public static void main(final String[] args) {
      try {
         populateDB("times.txt");
         State.init("test");
         GuiMain gui = new GuiMain();
         gui.setVisible(true);
      } catch (Exception e) {
         System.out.println(e);
      }
   }

   private static void populateDB(final String file)
         throws FileNotFoundException {
      Scanner scanner = new Scanner(new File(file));
      Abstraction db = new Abstraction();
      db.clean();
      db.make();
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
      db.close();
      scanner.close();
   }

}
