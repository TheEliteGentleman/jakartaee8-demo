/**
 * 
 */
package io.openliberty.system;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Provider;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import za.co.sindi.tuts.jakartaee8.rest.resource.UserResource;

/**
 * @author buhake.sindi
 * @since 10/02/2020
 *
 */
@Readiness
@ApplicationScoped
public class SystemReadinessCheck implements HealthCheck {
	
	@Inject
	@ConfigProperty(name = "io_openliberty_guides_system_inMaintenance")
	Provider<String> inMaintenance;

	@Override
	public HealthCheckResponse call() {
		// TODO Auto-generated method stub
		HealthCheckResponseBuilder builder = HealthCheckResponse.named(
				UserResource.class.getSimpleName() + " readiness check");
        if (inMaintenance != null && inMaintenance.get().equalsIgnoreCase("true")) {
            return builder.withData("services", "not available").down().build();
        }
        return builder.withData("services", "available").up().build();
	}
}
