package io.thorntail.rhsummit;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.thorntail.Thorntail;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

/**
 * @author Ken Finnigan
 */
@ApplicationPath("/api")
@OpenAPIDefinition(info = @Info(
        title = "My REST Application",
        version = "1.0"
)) public class RestApplication extends Application {
    public static void main(String... args) throws Exception {
        Thorntail.main(args);
    }
}
