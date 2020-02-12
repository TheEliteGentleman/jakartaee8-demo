/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.repository.entity.enums;

/**
 * @author Bienfait Sindi
 * @since 02 January 2013
 *
 */
public enum Gender {
	M("M"),
	F("F");
	
	private final String text;

	/**
	 * @param text
	 */
	private Gender(final String text) {
		this.text = text;
	}
	
	public static Gender of(final String gender) {
		if (Gender.M.text.equals(gender)) {
			return Gender.M;
		}
		
		if (Gender.F.text.equals(gender)) {
			return Gender.F;
		}
		
		throw new IllegalArgumentException("Unknown Gender with value of '" + gender + "'.");
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return text;
	}
}
