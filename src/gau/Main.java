package gau;

import gau.db.State;
import gau.gui.GuiMain;

public class Main {

   public static void main(final String[] args) throws Exception {
      State.init("production");
       GuiMain gui = new GuiMain();
       gui.setVisible(true);
   }

}


