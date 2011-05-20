package gau.gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Color;

public class GameWithPlugs extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane jTextPane = null;
	private JButton jButton = null;

	/**
	 * This is the default constructor
	 */
	public GameWithPlugs() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 1;
		gridBagConstraints4.gridy = 0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.gridx = 0;
		this.setSize(519, 342);
		this.setLayout(new GridBagLayout());
		this.add(getJTextPane(), gridBagConstraints);
		this.add(getJButton(), gridBagConstraints4);
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setEditable(false);
			jTextPane.setBackground(new Color(238, 238, 238));
		}
		return jTextPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Iniciar");
		}
		return jButton;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
