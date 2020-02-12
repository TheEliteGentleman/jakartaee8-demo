/**
 * 
 */
package za.co.sindi.tuts.jakartaee8;

import org.microshed.testing.SharedContainerConfiguration;
import org.microshed.testing.testcontainers.ApplicationContainer;
import org.testcontainers.junit.jupiter.Container;

/**
 * @author buhake.sindi
 * @since 2020/02/11
 *
 */
public class ApplicationConfig implements SharedContainerConfiguration {

	@Container
	public static ApplicationContainer app = new ApplicationContainer()
		.withAppContextRoot("/")
		.withReadinessPath("/health/ready");
}
