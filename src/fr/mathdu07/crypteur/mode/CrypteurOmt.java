package fr.mathdu07.crypteur.mode;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Own encryptor method, but it may already exists
 * <p>
 * Need a char key which will parsed to a byte
 */
public class CrypteurOmt extends CrypteurMode {
	
	private byte key;
	
	/**
	 * Encryptor OMT with a char key
	 * @param key
	 */
	public CrypteurOmt(char key) {
		this.key = (byte) key;
	}
	@Override
	protected String crypte(StringReader input) {
		List<Integer> list = new ArrayList<Integer>();
		
		try {
			int i;
			while ((i = input.read()) != -1){
				i += key;
				list.add(i);
			}
		} catch (IOException e) {e.printStackTrace();}
		
		char[] crypted = new char[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			crypted[i] = (char) list.get(i).intValue();
		}
			
		
		return new String(crypted);
	}

	@Override
	protected String decrypte(StringReader input) {
		List<Integer> list = new ArrayList<Integer>();
		
		try {
			int i;
			while ((i = input.read()) != -1){
				i -= key;
				list.add(i);
			}
		} catch (IOException e) {e.printStackTrace();}
		
		char[] decrypted = new char[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			decrypted[i] = (char) list.get(i).intValue();
		}
		return new String(decrypted);
	}
		
		@Override
		public String getName() {
			return "O.M.T";
		}

}
