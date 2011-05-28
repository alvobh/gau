package gau.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Plugs extends JPanel {

   private static final long serialVersionUID = 1L;
   private boolean test = false;
private JToggleButton jToggleButton = null;
/**
    * This is the default constructor.
    */
   public Plugs() {
      super();
      initialize();
   }

   /**
    * This is the default constructor.
    * @param testp
    */
   public Plugs(final boolean testp) {
      super();
      test = testp;
      initialize();
   }

   /**
    * This method initializes this.
    */
   private void initialize() {
      GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
      gridBagConstraints3.gridx = 0;
      gridBagConstraints3.gridy = 0;
      this.setSize(519, 342);
      this.setBackground(new Color(206, 218, 251));
      this.setLayout(new GridBagLayout());
      this.add(getJToggleButton(), gridBagConstraints3);
   }

/**
 * This method initializes jToggleButton	
 * 	
 * @return javax.swing.JToggleButton	
 */
private JToggleButton getJToggleButton() {
	if (jToggleButton == null) {
		jToggleButton = new JToggleButton();
		jToggleButton.setText("Aloha!");
	}
	return jToggleButton;
}

}  //  @jve:decl-index=0:visual-constraint="10,10"
