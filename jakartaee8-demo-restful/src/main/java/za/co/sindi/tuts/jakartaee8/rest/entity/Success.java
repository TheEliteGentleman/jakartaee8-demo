/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.rest.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author buhake.sindi
 * @since 2015/08/12
 *
 */
@XmlRootElement(name="result")
public class Success extends Result {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5222707720329298064L;
	
	@XmlElement(name="success")
	private boolean success;

	/**
	 * 
	 */
	public Success() {
		this(false);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param success
	 */
	public Success(boolean success) {
		super();
		this.success = success;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
