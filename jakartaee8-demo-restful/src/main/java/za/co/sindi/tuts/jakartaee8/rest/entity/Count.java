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
public class Count extends Result {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1809566927191442923L;
	
	@XmlElement(name="total")
	private long total;

	/**
	 * 
	 */
	public Count() {
		this(0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param total
	 */
	public Count(long total) {
		super();
		this.total = total;
	}

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
}
