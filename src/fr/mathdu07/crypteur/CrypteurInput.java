package fr.mathdu07.crypteur;

import fr.mathdu07.crypteur.mode.CrypteurEnum;

public interface CrypteurInput {
	
	/**
	 * Return the encryption's key
	 * <p>
	 * May be cast in char
	 * @return key
	 */
	public abstract int getKey();
	
	/**
	 * Returns the crypter engine which user chose
	 * @return crypteurEngine
	 */
	public abstract CrypteurEnum getCrypteurMode();
	
	/**
	 * Return the string to be encrypted
	 * @return strToEncrypted
	 */
	public abstract String getStringToEncrypted();
	/**
	 * Return the string to be decrypted
	 * @return strToDecrypted
	 */
	public abstract String getStringToDecrypted();

}
