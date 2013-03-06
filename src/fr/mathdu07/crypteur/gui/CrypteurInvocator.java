package fr.mathdu07.crypteur.gui;

public interface CrypteurInvocator {
	
	/**
	 * Set wether the invocator encrypte or decrypte
	 * @param b
	 */
	public abstract void setToggleCrypte(boolean b);
	
	/**
	 * Returns wether the invocator encrypte or decrypte
	 * @return toggleCrypte
	 */
	public abstract boolean getToggleCrypte();

}
