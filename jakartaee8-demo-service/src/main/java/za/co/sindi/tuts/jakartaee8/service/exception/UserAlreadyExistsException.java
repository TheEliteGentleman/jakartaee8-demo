/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.service.exception;

/**
 * @author buhake.sindi
 * @since 2020/02/11
 *
 */
public class UserAlreadyExistsException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4513331334984655582L;

	/**
	 * @param message
	 * @param cause
	 */
	public UserAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public UserAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public UserAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
