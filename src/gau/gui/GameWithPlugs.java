package gau.gui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GameWithPlugs extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane jTextPane = null;

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
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridy = 22;
		gridBagConstraints.gridx = 42;
		this.setLayout(new GridBagLayout());
		this.setBounds(new Rectangle(0, 0, 640, 480));
		this.add(getJTextPane(), gridBagConstraints);
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					System.out.println("caretUpdate()"); // TODO Auto-generated Event stub caretUpdate()
				}
			});
		}
		return jTextPane;
	}

}  //  @jve:decl-index=0:visual-constraint="26,11"
