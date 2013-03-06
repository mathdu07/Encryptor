package fr.mathdu07.crypteur;

public interface CrypteurOutput {
	
	/**
	 * Set the result decrypted string
	 * @param str
	 */
	public abstract void setDecryptedStr(String str);
	/**
	 * Set the result encrypted string
	 * @param str
	 */
	public abstract void setCryptedStr(String str);
	
	/**
	 * Force user to enter an integer as key with maximum value
	 * @param max
	 */
	public abstract void setKeyAsInteger(int max);
	/**
	 * Force user to enter a character as key
	 */
	public abstract void setKeyAsCharacter();

}
