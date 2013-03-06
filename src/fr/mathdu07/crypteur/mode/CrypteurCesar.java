package fr.mathdu07.crypteur.mode;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import fr.mathdu07.crypteur.Crypteur;

/**
 * The encryptor Cesar used by Jules Cesar
 * <p>
 * Need an int key from 1 to 25 (higher is useless)
 */
public class CrypteurCesar extends CrypteurMode {
	
	private int key;
	
	/**
	 * A new cesar encryptor with a key betwen 1 and 25
	 * @param key
	 */
	public CrypteurCesar(int key) {
		this.key = key;
	}

	@Override
	public String transform(String str, boolean toggleCrypte) {
		str = str.toUpperCase();
		
		return super.transform(str, toggleCrypte);
	}

	@Override
	protected String crypte(StringReader input) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		try {
			int i;
			while ((i = input.read()) != -1){
					if (Crypteur.isUpLetter((char) i)){
						i += key;
						i = (i > 'Z' ? i - 26 : i);
					}
					
					list.add(i);
			}
		} catch (IOException e) {e.printStackTrace();}
		
		char[] crypted = new char[list.size()];
		
		for(int j = 0; j < list.size(); j++){
			crypted[j] = (char) list.get(j).intValue();
		}
		
		return new String(crypted);
	}

	@Override
	protected String decrypte(StringReader input) {
		List<Integer> list = new ArrayList<Integer>();
		
		try {
			int i;
			while ((i = input.read()) != -1){		
				if (Crypteur.isUpLetter((char) i)){
					i -= key;
					i = (i < 'A' ? i + 26 : i);
				}
				list.add(i);
			}
		} catch (IOException e) {e.printStackTrace();}
		
		char[] decrypted = new char[list.size()];
		
		for (int i = 0; i < list.size(); i++){		
			decrypted[i] = (char) list.get(i).intValue();
		}
		
		return new String(decrypted);
	}

	@Override
	public String getName() {
		return "Cesar";
	}

}
