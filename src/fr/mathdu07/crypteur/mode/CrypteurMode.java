package fr.mathdu07.crypteur.mode;

import java.io.StringReader;

public abstract class CrypteurMode {

	public CrypteurMode() {}
	
	/**
	 * Trasform the given String 
	 * <p>
	 * If boolean is true, the string is encrypted, else it's decrypted
	 * @param str
	 * @param toggleCrypte
	 * @return
	 */
	public String transform(String str, boolean toggleCrypte){
		StringReader sr = new StringReader(str);
		
		return toggleCrypte ? crypte(sr) : decrypte(sr);
	}
	
	/**
	 * Called by <code>transform(str, toggleCrypte)</code> .
	 * Returns a crypted String
	 * @param input
	 * @return cryptedString
	 */
	protected abstract String crypte(StringReader input);
	
	/**
	 * Called by <code>transform(str, toggleCrypte)</code> .
	 * Returns a decrypted String
	 * @param input
	 * @return decryptedString
	 */
	protected abstract String decrypte(StringReader input);
	
	/**
	 * Returns the name of crypter
	 * @return nameOfCrypter
	 */
	public abstract  String getName();

}
