/**
 * 
 */
package io.openliberty.system;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import za.co.sindi.tuts.jakartaee8.rest.resource.UserResource;

/**
 * @author buhake.sindi
 * @since 10/02/2020
 *
 */
@Liveness
@ApplicationScoped
public class SystemLivenessCheck implements HealthCheck {
	
	@Override
	public HealthCheckResponse call() {
		// TODO Auto-generated method stub
		MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
        long memUsed = memBean.getHeapMemoryUsage().getUsed();
        long memMax = memBean.getHeapMemoryUsage().getMax();

        return HealthCheckResponse.named(
        		UserResource.class.getSimpleName() + " liveness check")
                                  .withData("memory used", memUsed)
                                  .withData("memory max", memMax)
                                  .state(memUsed < memMax * 0.9).build();
	}
}
