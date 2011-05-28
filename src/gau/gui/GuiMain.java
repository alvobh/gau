package gau.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JList;

public class GuiMain extends JFrame {

   private static final long serialVersionUID = 1L;
   private JPanel jContentPane = null;
   private JTabbedPane jTabbedPane = null;
   private boolean test = false;

   /**
    * This is the default constructor.
    */
   public GuiMain() {
      super();
      initialize();
   }

   /**
    * This is the default constructor.
    */
   public GuiMain(boolean testp) {
      super();
      test = testp;
      initialize();
   }

   /**
    * This method initializes this.
    */
   private void initialize() {
      this.setSize(527, 313);
      this.setContentPane(getJContentPane());
      this.setTitle("Gincana Ativa Urbana");
   }

   /**
    * This method initializes jContentPane.
    *
    * @return javax.swing.JPanel
    */
   private JPanel getJContentPane() {
      if (jContentPane == null) {
         jContentPane = new JPanel();
         jContentPane.setLayout(new BorderLayout());
         jContentPane.add(getJTabbedPane(), BorderLayout.CENTER);
      }
      return jContentPane;
   }

   /**
    * This method initializes jTabbedPane.
    *
    * @return javax.swing.JTabbedPane
    */
   private JTabbedPane getJTabbedPane() {
      if (jTabbedPane == null) {
         jTabbedPane = new JTabbedPane();
         jTabbedPane.addTab("Prova", null, new GameWithPlugs(test), null);
         jTabbedPane.addTab("Botoes", null, new Plugs(test), null);
      }
      return jTabbedPane;
   }

}  //  @jve:decl-index=0:visual-constraint="10,10"
