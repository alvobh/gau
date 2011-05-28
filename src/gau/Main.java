package gau;

import gau.gui.GuiMain;
import gau.state.State;

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


