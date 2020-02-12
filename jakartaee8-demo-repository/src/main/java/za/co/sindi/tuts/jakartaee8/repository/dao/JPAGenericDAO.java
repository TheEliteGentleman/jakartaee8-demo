/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.repository.dao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import za.co.sindi.tuts.jakartaee8.repository.entity.Entity;
import za.co.sindi.tuts.jakartaee8.repository.exception.DAOException;

/**
 * The JPA specific Generic DAO. All the methods are implemented, only specify the {@link EntityManager}.
 * 
 * @author buhake.sindi
 * @since 2017/07/27
 *
 */
public abstract class JPAGenericDAO<T extends Entity<ID>, ID extends Serializable> implements GenericDAO<T, ID> {

	@PersistenceContext(unitName="jakartaee8Demo_PU")
	private EntityManager entityManager;
	
	private Class<T> entityClass;

	/**
	 * @param entityClass
	 */
	protected JPAGenericDAO(Class<T> entityClass) {
		super();
		this.entityClass = Objects.requireNonNull(entityClass, "Entity class type may not be null.");;
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#countAll()
	 */
	public long countAll() {
		// TODO Auto-generated method stub
//		TypedQuery<Long> query = getEntityManager().createQuery("SELECT COUNT(e.id) FROM " + entityClass.getSimpleName() + " e", Long.class);
//		return query.getSingleResult();
		long count = 0;
		try {
			EntityManager entityManager = getEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Long> query = builder.createQuery(Long.class);
			query.select(builder.count(query.from(entityClass)));
			count = entityManager.createQuery(query).getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			if (e instanceof NoResultException) {
				count = 0;
			} else {
				throw new DAOException(e);
			}
		}
		
		return count;
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#delete(java.io.Serializable)
	 */
	public void delete(ID id) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		entityManager.remove(entityManager.getReference(entityClass, id));
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#delete(za.co.supergroup.persistence.entity.Entity)
	 */
	public void delete(T entity) {
		// TODO Auto-generated method stub
		final EntityManager entityManager = getEntityManager();
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		Query query = getEntityManager().createQuery("DELETE FROM " + entityClass.getSimpleName() + " e");
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#deleteInBatch(za.co.supergroup.persistence.entity.Entity[])
	 */
	@Override
	public void deleteInBatch(T[] entities) {
		// TODO Auto-generated method stub
		if (entities == null) {
			throw new IllegalArgumentException("No entities were specified of type " + entityClass.getName());
		}
		if (entities.length == 1) {
			delete(entities[0]);
			return ;
		}
		
		final EntityManager entityManager = getEntityManager();
		for (T entity : entities) {
			entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
		}
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#exists(java.io.Serializable)
	 */
	public boolean exists(ID id) {
		// TODO Auto-generated method stub
		if (id == null) {
			throw new IllegalArgumentException("No Entity ID was specified (of class " + entityClass.getName() + ").");
		}
		@SuppressWarnings("unchecked")
		TypedQuery<ID> query = (TypedQuery<ID>) getEntityManager().createQuery("SELECT e.id FROM " + entityClass.getSimpleName() + " e WHERE e.id = ?1", id.getClass());
		query.setParameter(1, id);
		query.setMaxResults(1);
		return query.getResultList().size() == 1;
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#findAll()
	 */
	public Collection<T> findAll() {
		// TODO Auto-generated method stub
		return findAll(null, null);
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#findAll(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Collection<T> findAll(Integer startPosition, Integer size) {
		// TODO Auto-generated method stub
		TypedQuery<T> query = getEntityManager().createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
		if (startPosition != null) {
			if (startPosition < 0) {
				throw new IllegalArgumentException("Start position must be a positive number.");
			}
			query.setFirstResult(startPosition);
		}
		
		if (size != null) {
			if (size < 0) {
				throw new IllegalArgumentException("Maximum result size must be a positive number.");
			}
			query.setMaxResults(size);
		}
		
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#find(java.io.Serializable)
	 */
	public T find(ID id) {
		// TODO Auto-generated method stub
		return getEntityManager().find(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#findByIds(java.io.Serializable[])
	 */
	@Override
	public Collection<T> findByIds(@SuppressWarnings("unchecked") ID... ids) {
		// TODO Auto-generated method stub
		if (ids == null || ids.length > 0) {
			throw new IllegalArgumentException("No Entity IDs (of class " + entityClass.getName() + ") was specified.");
		}
		TypedQuery<T> query = getEntityManager().createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e.id IN :ids", entityClass);
		query.setParameter("ids", Arrays.asList(ids));
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#save(za.co.supergroup.persistence.entity.Entity)
	 */
	public void save(T entity) {
		// TODO Auto-generated method stub
		try {
			getEntityManager().persist(entity);
		} catch (EntityExistsException e) {
			throw new DAOException(entityClass.getSimpleName() + " already exists.", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#saveInBatch(za.co.supergroup.persistence.entity.Entity[])
	 */
	@Override
	public void saveInBatch(T[] entities) {
		// TODO Auto-generated method stub
		if (entities == null) {
			throw new IllegalArgumentException("No entities were specified of type " + entityClass.getName());
		}
		if (entities.length == 1) {
			save(entities[0]);
			return ;
		}
		
		final EntityManager entityManager = getEntityManager();
		for (T entity : entities) {
			if (entity == null) continue;
			entityManager.persist(entity);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#update(za.co.supergroup.persistence.entity.Entity)
	 */
	public void update(T entity) {
		// TODO Auto-generated method stub
		if (entity.isNew()) {
			throw new IllegalArgumentException("Entity is new. Please call the save() method in order to save this entity.");
		}
		getEntityManager().merge(entity);
	}

	/* (non-Javadoc)
	 * @see za.co.supergroup.persistence.dao.GenericDAO#updateInBatch(za.co.supergroup.persistence.entity.Entity[])
	 */
	@Override
	public void updateInBatch(T[] entities) {
		// TODO Auto-generated method stub
		if (entities == null) {
			throw new IllegalArgumentException("No entities were specified of type " + entityClass.getName());
		}
		if (entities.length == 1) {
			update(entities[0]);
			return ;
		}
		
		final EntityManager entityManager = getEntityManager();
		for (T entity : entities) {
			if (entity == null) continue;
			entityManager.merge(entity);
		}
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
