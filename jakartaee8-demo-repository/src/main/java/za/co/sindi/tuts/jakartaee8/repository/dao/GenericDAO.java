/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.repository.dao;

import java.io.Serializable;
import java.util.Collection;

import za.co.sindi.tuts.jakartaee8.repository.entity.Entity;

/**
 * @author buhake.sindi
 * @since 2017/06/17
 *
 */
public interface GenericDAO<T extends Entity<ID>, ID extends Serializable> {

	public long countAll();
	public void delete(ID id);
	public void delete(T entity);
	public void deleteAll();
	public void deleteInBatch(T[] entities);
	public boolean exists(ID id);
	public Collection<T> findAll();
	public Collection<T> findAll(Integer startPosition, Integer size);
	public T find(ID id);
	public Collection<T> findByIds(@SuppressWarnings("unchecked") ID... ids);
	public void save(T entity);
	public void saveInBatch(T[] entities);
	public void update(T entity);
	public void updateInBatch(T[] entities);
}