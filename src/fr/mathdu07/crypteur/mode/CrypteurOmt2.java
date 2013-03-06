package fr.mathdu07.crypteur.mode;

import java.io.StringReader;



/**
 * Crypter herited from {@link fr.mathdu07.crypteur.mode.cypteur.CrypteurOmt CrypteurOmt}.
 * It is just a little more sensitive
 * @see CrypteurOmt
 */
public class CrypteurOmt2 extends CrypteurOmt {
	
	/**
	 * Encryptor OMT_II with a char key
	 * @param key
	 */
	public CrypteurOmt2(char key) {
		super(key);
	}

	@Override
	protected String crypte(StringReader input) {
		char[] crypted = super.crypte(input).toCharArray();
		
		for(int i = 0; i < crypted.length; i++){
			crypted[i] += i;
		}
		
		return new String(crypted);
	}

	@Override
	protected String decrypte(StringReader input) {
		char[] decrypted = super.decrypte(input).toCharArray();
		
		for(int i = 0; i < decrypted.length; i++){
			decrypted[i] -= i;
		}
		
		return new String(decrypted);
	}

	@Override
	public String getName() {
		return super.getName().concat(" II");
	}
	
	

}
