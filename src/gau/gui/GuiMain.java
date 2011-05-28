package gau.gui;

import gau.state.State;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JList;

public class GuiMain extends JFrame {

   private static final long serialVersionUID = 1L;
   private JPanel jContentPane = null;
   private JTabbedPane jTabbedPane = null;

   /**
    * This is the default constructor.
    */
   public GuiMain() {
      super();
      initialize();
   }

   /**
    * This method initializes this.
    */
   private void initialize() {
      this.setSize(527, 313);
      this.setContentPane(getJContentPane());
      String title = "Gincana Ativa Urbana";
      if (State.isTest()) {
         title = "Teste " + title;
      }
      this.setTitle(title);
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
         jTabbedPane.addTab("Prova", null, new GameWithPlugs(), null);
         jTabbedPane.addTab("Botoes", null, new Plugs(), null);
      }
      return jTabbedPane;
   }

}  //  @jve:decl-index=0:visual-constraint="10,10"
