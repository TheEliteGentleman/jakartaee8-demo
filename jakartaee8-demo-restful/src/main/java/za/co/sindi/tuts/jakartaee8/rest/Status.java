/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.rest;

import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.core.Response.Status.Family;

/**
 * These contains HTTP Status codes not included in {@link javax.ws.rs.core.Response.Status} codes.
 * 
 * @author Buhake Sindi
 * @since 2018/06/06
 *
 */
public enum Status implements StatusType {
	
	UNPROCESSABLE_ENTITY(422, "Unprocessable Entity")
	;
	
	final int statusCode;
    private final String reasonPhrase;
    private final Family family;
    
	/**
	 * @param statusCode
	 * @param reasonPhrase
	 */
	private Status(int statusCode, String reasonPhrase) {
		this.statusCode = statusCode;
		this.reasonPhrase = reasonPhrase;
		this.family = Family.familyOf(statusCode);
	}

	/* (non-Javadoc)
	 * @see javax.ws.rs.core.Response.StatusType#getStatusCode()
	 */
	@Override
	public int getStatusCode() {
		// TODO Auto-generated method stub
		return statusCode;
	}


	/* (non-Javadoc)
	 * @see javax.ws.rs.core.Response.StatusType#getReasonPhrase()
	 */
	@Override
	public String getReasonPhrase() {
		// TODO Auto-generated method stub
		return reasonPhrase;
	}

	/**
	 * @return the family
	 */
	public Family getFamily() {
		return family;
	}
}
