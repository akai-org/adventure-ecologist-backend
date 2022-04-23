package pl.org.akai;

import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
class EcologistController {

    private final JsonWebToken token;

    EcologistController(JsonWebToken token) {
        this.token = token;
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/sec")
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated
    public String secured() {
        return "Authenticated to " + token.getClaim("email");
    }

}
