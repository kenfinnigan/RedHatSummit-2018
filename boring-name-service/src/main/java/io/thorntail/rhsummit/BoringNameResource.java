package io.thorntail.rhsummit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * @author Ken Finnigan
 */
@Path("/")
public class BoringNameResource {

    @Inject
    @ConfigProperty(name = "myapp.default-name", defaultValue = "John")
    private String defaultName;

    @GET
    @Path("/name")
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "hCount",
            absolute = true,
            description = "# calls to /boring",
            monotonic = true)
    @Operation(
            operationId = "getBoringName",
            summary = "Retrieve a boring name"
    )
    public String boring() {
        return defaultName;
    }
}
