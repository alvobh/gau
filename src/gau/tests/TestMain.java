package gau.tests;

import gau.db.State;
import gau.gui.GuiMain;

public class TestMain {

   /**
    * @param args
    */
   public static void main(String[] args) {
      State.init("test");
      GuiMain gui = new GuiMain();
      gui.setVisible(true);
   }

}
