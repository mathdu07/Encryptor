package fr.mathdu07.crypteur;

import fr.mathdu07.crypteur.gui.CrypteurFrame;
import fr.mathdu07.crypteur.mode.*;

public class Crypteur {
	
	/**
	 * All the different method of this encryptor
	 */
	public static final String[] list = new String[]{
		CrypteurEnum.CESAR.toString(), CrypteurEnum.OMT.toString(), CrypteurEnum.OMT_II.toString()
	};
	/**
	 * Object representing version of this software
	 */
	public static final Version version = new Version(1, 0);

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int lookAndFeel = 0;
		
		if (args.length >= 2){
			if (args[0].equalsIgnoreCase("--lookandfeel")) {
				try{
					lookAndFeel = Integer.parseInt(args[1]);
				} catch(NumberFormatException e){
					System.out.println("The string given isn't a number for --lookandfeel " + args[1]);
				}
			}
		}
		
		if (lookAndFeel >= 0)
			new CrypteurFrame(lookAndFeel);
		else
			new CrypteurFrame();
		
		System.out.println("+---------------------------------+");
		System.out.println("|      Crypteur by mathdu07       |");
		System.out.println("|             v" + version + "\t            |");
		System.out.println("+---------------------------------+");
		
	}
	
	/**
	 * Returns the selected encryptor using inputs
	 * @param in
	 * @return encryptor
	 */
	private static CrypteurMode getCrypteurMode(CrypteurInput in){
		CrypteurEnum mode = in.getCrypteurMode();
		CrypteurMode encryptor;
		
		switch (mode){
		case CESAR:
			encryptor = new CrypteurCesar(in.getKey());
			break;
			
		case OMT:
			encryptor = new CrypteurOmt((char) in.getKey());
			break;
		
		case OMT_II:
			encryptor = new CrypteurOmt2((char) in.getKey());
			break;
			
		default:
			encryptor = null;
		}
		
		return encryptor;
	}
	
	public static void encrypte (CrypteurInput in, CrypteurOutput out){
		CrypteurMode encryptor = getCrypteurMode(in);
		
		if (encryptor instanceof CrypteurOmt2){
			String[] str = in.getStringToEncrypted().split("\n");
			StringBuilder build = new StringBuilder();
			
			for (String s : str){
				build.append(encryptor.transform(s, true) + '\n');
			}
			out.setCryptedStr(build.toString());
		}else
			out.setCryptedStr(encryptor.transform(in.getStringToEncrypted(), true));
		
	}
	
	public static void decrypte (CrypteurInput in, CrypteurOutput out){
		CrypteurMode encryptor = getCrypteurMode(in);
		
		if (encryptor instanceof CrypteurOmt2){
			String[] str = in.getStringToDecrypted().split("\n");
			StringBuilder build = new StringBuilder();
			
			for (String s : str){
				build.append(encryptor.transform(s, false) + '\n');
			}
			out.setDecryptedStr(build.toString());
		}else
			out.setDecryptedStr(encryptor.transform(in.getStringToDecrypted(), false));
		
		
	}

	
	public static boolean isUpLetter (char c){
		switch (c){
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
			return true;
		default:
			return false;
		
		}
	}
	
}
