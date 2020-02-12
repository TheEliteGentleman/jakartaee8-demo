/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.rest.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @author buhake.sindi
 * @since 2015/08/07
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Count.class, Success.class})
public abstract class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9006263472025196054L;
}
