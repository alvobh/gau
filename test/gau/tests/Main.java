package gau.tests;

import gau.gui.GuiMain;
import gau.state.State;

public class Main {

   /**
    * @param args
    */
   public static void main(final String[] args) {
      try {
         State.init("test");
         GuiMain gui = new GuiMain();
         gui.setVisible(true);
      } catch (Exception e) {
         System.out.println(e);
      }
   }

}
