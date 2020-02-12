/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.repository.dao.impl;

import za.co.sindi.tuts.jakartaee8.repository.dao.JPAGenericDAO;
import za.co.sindi.tuts.jakartaee8.repository.dao.UserDAO;
import za.co.sindi.tuts.jakartaee8.repository.entity.User;

/**
 * @author buhake.sindi
 * @since 2017/08/17
 *
 */
public class UserJPADAO extends JPAGenericDAO<User, String> implements UserDAO {

	/**
	 * 
	 */
	public UserJPADAO() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see za.co.sgits.angular.persistence.dao.UserDAO#findByEmailAddress(java.lang.String)
	 */
//	@Override
//	public User findByEmailAddress(String emailAddress) {
//		// TODO Auto-generated method stub
//		return getEntityManager().createNamedQuery("user.findByEmailAddress", User.class).setParameter(1, emailAddress).getSingleResult();
//	}
}
