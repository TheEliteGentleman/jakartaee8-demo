/**
 * 
 */
package za.co.sindi.tuts.jakartaee8;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.microshed.testing.SharedContainerConfig;
import org.microshed.testing.jaxrs.RESTClient;
import org.microshed.testing.jupiter.MicroShedTest;

import za.co.sindi.tuts.jakartaee8.rest.entity.Count;
import za.co.sindi.tuts.jakartaee8.rest.resource.UserResource;

/**
 * @author buhake.sindi
 * @since 2020/02/11
 *
 */
@MicroShedTest
@SharedContainerConfig(ApplicationConfig.class)
public class UserResourceIT {

	@RESTClient
	public UserResource userResource;
	
	@Test
	public void shouldHaveAUser() {
		Count count = userResource.countAllUsers();
		assertNotNull(count);
	}
}
