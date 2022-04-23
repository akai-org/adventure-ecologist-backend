package pl.org.akai;

import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.jwt.JsonWebToken;
import pl.org.akai.database.GameStateEntity;
import pl.org.akai.database.GameStateRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class EcologistController {

    private final JsonWebToken token;
    private final GameStateRepository gameStateRepository;

    EcologistController(JsonWebToken token, GameStateRepository gameStateRepository) {
        this.token = token;
        this.gameStateRepository = gameStateRepository;
    }


    @GET
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/sec")
    @Authenticated
    public String secured() {
        return "Authenticated to " + token.getClaim("email");
    }

    @POST
    @Path("/state")
    @Authenticated
    public void saveState(GameStateEntity gameStateEntity) {
        gameStateRepository.persist(gameStateEntity);
    }

}
