/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.rest.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import za.co.sindi.tuts.jakartaee8.rest.util.Throwables;

/**
 * @author buhake.sindi
 * @since 2015/08/07
 *
 */
@XmlRootElement(name="exception")
@XmlAccessorType(XmlAccessType.FIELD)
public class Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7249046529113083616L;

	@XmlElement(name="error_class")
	private String exceptionClassName;
	
	@XmlElement(name="error_message")
	private String exceptionMessage;
	
	/**
	 * 
	 */
	public Exception() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public Exception(Throwable throwable) {
		Throwable rootCauseThrowable = Throwables.getRootCause(throwable);
		if (rootCauseThrowable != null) {
			this.exceptionClassName = rootCauseThrowable.getClass().getName();
			this.exceptionMessage = rootCauseThrowable.getLocalizedMessage();
		}
	}
	
	/**
	 * @return the exceptionClassName
	 */
	public String getExceptionClassName() {
		return exceptionClassName;
	}

	/**
	 * @param exceptionClassName the exceptionClassName to set
	 */
	public void setExceptionClassName(String exceptionClassName) {
		this.exceptionClassName = exceptionClassName;
	}

	/**
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * @param exceptionMessage the exceptionMessage to set
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exceptionClassName == null) ? 0 : exceptionClassName.hashCode());
		result = prime * result + ((exceptionMessage == null) ? 0 : exceptionMessage.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exception other = (Exception) obj;
		if (exceptionClassName == null) {
			if (other.exceptionClassName != null)
				return false;
		} else if (!exceptionClassName.equals(other.exceptionClassName))
			return false;
		if (exceptionMessage == null) {
			if (other.exceptionMessage != null)
				return false;
		} else if (!exceptionMessage.equals(other.exceptionMessage))
			return false;
		return true;
	}
}
