package fr.mathdu07.crypteur;

/**
 * L'objet gerant la version, souvant <code>final</code>
 */
public class Version {
	
	private int major;
	private int minor;
	private int rev;
	private int dev;
	private String extra;
	
	/**
	 * L'objet gerant la version, souvant <code>final</code>, sous forme : <code>"major.minor.rev.dev"</code>.
	 * Exemple : "1.2.3.65"
	 * @param major
	 * @param minor
	 * @param rev
	 * @param dev
	 */
	public Version(int major, int minor, int rev, int dev) {
		this.major = major;
		this.minor = minor;
		this.rev = rev;
		this.dev = dev;
	}
	/**
	 * L'objet gerant la version, souvant <code>final</code>, sous forme : <code>"major.minor.rev"</code>.
	 * Exemple : "1.2.3"
	 * @param major
	 * @param minor
	 * @param rev
	 */
	public Version(int major, int minor, int rev) {
		this (major, minor, rev, 0);
	}
	/**
	 * L'objet gerant la version, souvant <code>final</code>, sous forme : <code>"major.minor"</code>.
	 * Exemple : "1.2"
	 * @param major
	 * @param minor
	 */
	public Version(int major, int minor) {
		this(major, minor, 0, 0);
	}
	
	/**
	 * L'objet gerant la version, souvant <code>final</code>, sous forme : <code>"major.minor.rev.dev extra"</code>.
	 * Exemple : "1.2.3.65 beta#65"
	 * @param major
	 * @param minor
	 * @param rev
	 * @param dev
	 * @param extra
	 */
	public Version(int major, int minor, int rev, int dev, String extra) {
		this(major, minor, rev, dev);
		this.extra = extra;
	}

	@Override
	public String toString() {
		String version = Integer.toString(major);
		version = version + "." +Integer.toString(minor);
		
		if (rev != 0)
			version += "." + Integer.toString(rev);
		if (dev != 0 && rev == 0)
			version += ".0." + Integer.toString(dev);
		else if (dev !=0)
			version += "." + Integer.toString(dev);
		
		if (extra != null)
			version += " " + extra;
			
		
		return version;
	}
	
	

}
