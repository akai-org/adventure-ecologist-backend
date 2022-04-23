package pl.org.akai;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.jwt.JsonWebToken;
import pl.org.akai.database.GameStateEntity;
import pl.org.akai.database.GameStateRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

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
    @POST
    @Path("/state")
    @Authenticated
    public void saveState(GameStateEntity gameStateEntity) {
        gameStateEntity.setEmail(token.getClaim("email"));
        gameStateRepository.persist(gameStateEntity);
    }

    @GET
    @Path("/state")
    @Authenticated
    public Uni<GameStateEntity> saveState() {
        return gameStateRepository.findByEmail(token.getClaim("email"));
    }

}
