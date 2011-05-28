package gau;

import gau.db.State;
import gau.gui.GuiMain;

public class Main {

   public static void main(final String[] args) {
      try {
         State.init("production");
         GuiMain gui = new GuiMain();
         gui.setVisible(true);
      } catch (Exception e) {
         System.out.println(e);
      }
   }

}


