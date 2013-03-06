package fr.mathdu07.crypteur.mode;

public enum CrypteurEnum {
	
	CESAR("cesar"),
	OMT("OMT"),
	OMT_II("OMT II");

	private String name;
	
	private CrypteurEnum (String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static CrypteurEnum byName(String str){
		if (str.equalsIgnoreCase("cesar"))
			return CESAR;
		else if (str.equalsIgnoreCase("omt"))
			return OMT;
		else if (str.equalsIgnoreCase("omt II"))
			return OMT_II;
		else
			return null;
	}
	

	
	

}
