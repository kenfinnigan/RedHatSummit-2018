package io.thorntail.rhsummit;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

/**
 * @author Ken Finnigan
 */
@Health
@ApplicationScoped
public class GoodHealthCheck implements HealthCheck {
    public HealthCheckResponse call() {
        return HealthCheckResponse
                .named("MyHealthCheck")
                .withData("someKey", "aValue")
                .up()
                .build();
    }
}