/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.service.exception;

/**
 * @author buhake.sindi
 * @since 2020/02/11
 *
 */
public class NoSuchUserException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -923134327890710872L;

	/**
	 * @param message
	 * @param cause
	 */
	public NoSuchUserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NoSuchUserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NoSuchUserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
