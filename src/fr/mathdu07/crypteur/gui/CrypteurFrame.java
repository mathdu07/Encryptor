package fr.mathdu07.crypteur.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * The frame of the encryptor
 *
 */
public class CrypteurFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5475275281586317539L;
	private CrypteurPanel mainPanel = new CrypteurPanel();
	
	/**
	 * Default constructor, automatically setting parameters
	 */
	public CrypteurFrame()  {
		super ("BasicCrypteur");
		
		this.setSize(640, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(mainPanel);
		
		this.setVisible(true);
	}
	
	/**
	 * The argument is the look and feel
	 */
	public CrypteurFrame(int lookAndFeel)  {
		super ("BasicCrypteur");
		
		this.setSize(640, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(mainPanel);
		
		try {
			UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[lookAndFeel].getClassName());
			
			SwingUtilities.updateComponentTreeUI(this);
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		this.setVisible(true);
	}

}
