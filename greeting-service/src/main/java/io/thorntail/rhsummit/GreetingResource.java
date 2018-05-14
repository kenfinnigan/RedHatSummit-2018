package io.thorntail.rhsummit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

/**
 * @author Ken Finnigan
 */
@Path("/")
public class GreetingResource {

    private static final String NAME_SERVICE_URL = "http://localhost:8200";

    @GET
    @Path("/greeting")
    @Produces("application/json")
    @Retry(maxRetries = 2)
    @Fallback(fallbackMethod = "greetingFallback")
    public Response greeting() {
            Client client = ClientBuilder.newBuilder().build();
            WebTarget webTarget = client.target(NAME_SERVICE_URL);
            Invocation.Builder requestBuilder = webTarget.path("/api/name").request();

            String name = requestBuilder.get().readEntity(String.class);

            return Response.ok()
                    .entity(new Greeting(String.format("Hello %s", name)))
                    .build();
    }

    public Response greetingFallback() {
        return Response.ok()
                .entity(new Greeting("Greetings from a fallback")).build();
    }

    static class Greeting {
        private final String content;

        public Greeting(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

}
