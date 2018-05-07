package io.thorntail.rhsummit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Ken Finnigan
 */
@Path("/")
public class BoringNameResource {

    @GET
    @Path("/name")
    @Produces(MediaType.TEXT_PLAIN)
    public String boring() {
        return "John";
    }
}
