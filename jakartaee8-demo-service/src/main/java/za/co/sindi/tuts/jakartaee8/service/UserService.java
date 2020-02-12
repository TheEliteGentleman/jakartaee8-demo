/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.service;

import java.util.Collection;
import java.util.Date;

import za.co.sindi.tuts.jakartaee8.repository.entity.enums.Gender;
import za.co.sindi.tuts.jakartaee8.service.dto.UserDTO;

/**
 * @author buhake.sindi
 * @since 2017/08/17
 *
 */
public interface UserService {

	public long countAllUsers();
	
	public void createNewUser(final String userId, final String firstName, final String middleName, final String surname, final Date dateOfBirth, final Gender birthGender);
	
	public void deleteUser(final String userId);
	
	public Collection<UserDTO> findAllUsers();
	public Collection<UserDTO> findAllUsers(Integer startPosition, Integer maxResults);

	public UserDTO findUser(final String userId);
	
	public void updateExistingUser(final String userId, final String firstName, final String middleName, final String surname, final Date dateOfBirth, final Gender birthGender);
}
