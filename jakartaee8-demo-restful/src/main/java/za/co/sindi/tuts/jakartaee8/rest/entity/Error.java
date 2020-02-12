/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.rest.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Buhake Sindi
 * @since 2018/08/02
 *
 */
@XmlRootElement(name="error")
@XmlAccessorType(XmlAccessType.FIELD)
public class Error implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7024587139731523588L;

	@XmlElement
	private String message;
	
	@XmlElement(name="root-cause-exception")
	private Exception rootCauseException;

	/**
	 * 
	 */
	public Error() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public Error(String message) {
		this(message, null);
	}

	/**
	 * @param message
	 * @param rootCauseException
	 */
	public Error(String message, Exception rootCauseException) {
		super();
		this.message = message;
		this.rootCauseException = rootCauseException;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the rootCauseException
	 */
	public Exception getRootCauseException() {
		return rootCauseException;
	}

	/**
	 * @param rootCauseException the rootCauseException to set
	 */
	public void setRootCauseException(Exception rootCauseException) {
		this.rootCauseException = rootCauseException;
	}
}
