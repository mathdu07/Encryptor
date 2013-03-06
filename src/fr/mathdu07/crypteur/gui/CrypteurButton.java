package fr.mathdu07.crypteur.gui;

import javax.swing.JButton;

public class CrypteurButton extends JButton implements CrypteurInvocator {

	private boolean toggleCrypte;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5356402061890170766L;

	public CrypteurButton(String string) {
		super(string);
	}

	@Override
	public void setToggleCrypte(boolean b) {
		toggleCrypte = b;
	}

	@Override
	public boolean getToggleCrypte() {
		return toggleCrypte;
	}

}
