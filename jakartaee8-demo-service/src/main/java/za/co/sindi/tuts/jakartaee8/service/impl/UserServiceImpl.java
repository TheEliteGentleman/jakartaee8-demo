/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import za.co.sindi.tuts.jakartaee8.repository.dao.UserDAO;
import za.co.sindi.tuts.jakartaee8.repository.entity.User;
import za.co.sindi.tuts.jakartaee8.repository.entity.enums.Gender;
import za.co.sindi.tuts.jakartaee8.service.UserService;
import za.co.sindi.tuts.jakartaee8.service.dto.UserDTO;
import za.co.sindi.tuts.jakartaee8.service.exception.NoSuchUserException;
import za.co.sindi.tuts.jakartaee8.service.exception.UserAlreadyExistsException;

/**
 * @author buhake.sindi
 * @since 2017/08/17
 *
 */
@Stateless
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO userDAO;
	
	private Function<User, UserDTO> mapToUserDTO() {
		
		return new Function<User, UserDTO>() {

			/* (non-Javadoc)
			 * @see java.util.function.Function#apply(java.lang.Object)
			 */
			@Override
			public UserDTO apply(User user) {
				// TODO Auto-generated method stub
				UserDTO userDTO = new UserDTO();
//				userDTO.setEmailAddress(user.getEmailAddress());
				userDTO.setFirstName(user.getFirstName());
				userDTO.setSurname(user.getSurname());
				userDTO.setId(user.getId());
				userDTO.setBirthDate(user.getBirthDate());
				userDTO.setBirthGender(user.getBirthGender());
//				userDTO.setCreatedBy(user.getCreatedBy().getId());
				userDTO.setCreationTimestamp(user.getCreationTimestamp());
//				if (user.getDeletedBy() != null)
//					userDTO.setDeletedBy(user.getDeletedBy().getId());
				userDTO.setDeletionTimestamp(user.getDeletionTimestamp());
				userDTO.setLastModificationTimestamp(user.getLastModificationTimestamp());
//				if (user.getLastModifiedBy() != null)
//					userDTO.setLastModifiedBy(user.getLastModifiedBy().getId());
				
				return userDTO;
			}
		};
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.tuts.jakartaee8.service.UserService#countAllUsers()
	 */
	@Override
	public long countAllUsers() {
		// TODO Auto-generated method stub
		return userDAO.countAll();
	}

	@Override
	public void createNewUser(String userId, String firstName, String middleName, String surname, Date dateOfBirth,	Gender birthGender) {
		// TODO Auto-generated method stub
		if (userDAO.exists(userId)) {
			throw new UserAlreadyExistsException("User '" + userId + "' already exists.");
		}
		
		User user = new User();
		user.setBirthDate(dateOfBirth);
		user.setBirthGender(birthGender);
		user.setFirstName(firstName);
		user.setId(userId);
		user.setSecondName(middleName);
		user.setSurname(surname);
		
		//Save
		userDAO.save(user);
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		if (!userDAO.exists(userId)) {
			throw new NoSuchUserException("Invalid user ID: '" + userId + "'.");
		}
		
		//Delete
		userDAO.delete(userId);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.tuts.jakartaee8.service.UserService#findAllUsers()
	 */
	@Override
	public Collection<UserDTO> findAllUsers() {
		// TODO Auto-generated method stub
		Collection<User> users = userDAO.findAll();
		if (users == null) {
			return null;
		}
		
		return users.stream().map(mapToUserDTO()).collect(Collectors.toList());
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.tuts.jakartaee8.service.UserService#findAllUsers(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Collection<UserDTO> findAllUsers(Integer startPosition, Integer maxResults) {
		// TODO Auto-generated method stub
		Collection<User> users = userDAO.findAll(startPosition, maxResults);
		if (users == null) {
			return null;
		}
		
		return users.stream().map(mapToUserDTO()).collect(Collectors.toList());
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.tuts.jakartaee8.service.UserService#findUser(java.lang.String)
	 */
	@Override
	public UserDTO findUser(String userId) {
		// TODO Auto-generated method stub
		if (!userDAO.exists(userId)) {
			throw new NoSuchUserException("Invalid user ID: '" + userId + "'.");
		}
		
		return mapToUserDTO().apply(userDAO.find(userId));
	}

	@Override
	public void updateExistingUser(String userId, String firstName, String middleName, String surname, Date dateOfBirth, Gender birthGender) {
		// TODO Auto-generated method stub
		if (!userDAO.exists(userId)) {
			throw new NoSuchUserException("Invalid user ID: '" + userId + "'.");
		}
		
		User user = userDAO.find(userId);
		user.setBirthDate(dateOfBirth);
		user.setBirthGender(birthGender);
		user.setFirstName(firstName);
		user.setSecondName(middleName);
		user.setSurname(surname);
		
		//Update
		userDAO.update(user);
	}
}
