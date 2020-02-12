/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.repository.entity;

import java.io.Serializable;

/**
 * @author buhake.sindi
 * @since 2017/06/17
 *
 */
public interface Entity<ID extends Serializable> extends Serializable {

	public ID getId();
	public void setId(ID id);
	public boolean isNew();
}
