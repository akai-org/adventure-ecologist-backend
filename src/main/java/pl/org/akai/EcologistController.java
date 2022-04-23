package pl.org.akai;

import io.quarkus.security.Authenticated;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
class EcologistController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/sec")
    @Produces(MediaType.TEXT_PLAIN)
    @Authenticated
    public String secured() {
        return "Authenticated";
    }

}
