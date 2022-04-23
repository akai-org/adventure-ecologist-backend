package pl.org.akai.controller;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.jwt.JsonWebToken;
import pl.org.akai.database.GameStateEntity;
import pl.org.akai.database.GameStateRepository;
import pl.org.akai.service.GameStateService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
class GameStateController {

    private final JsonWebToken token;
    private final GameStateRepository gameStateRepository;
    private final GameStateService gameStateService;


    @POST
    @Path("/state")
    @Authenticated
    public Uni<Response> saveState(GameStateEntity gameStateEntity) {
        String email = token.getClaim("email");
        return gameStateService.updateState(email, gameStateEntity)
                               .map(gameStatus -> Response.ok(gameStatus)
                                                          .status(Response.Status.CREATED)
                                                          .build());
    }

    @GET
    @Path("/state")
    @Authenticated
    public Uni<Response> saveState() {
        return gameStateRepository.findByEmail(token.getClaim("email"))
                                  .onItem().ifNotNull().transform(gameStatus -> Response.ok(gameStatus).build())
                                  .onItem().ifNull().continueWith(Response.status(Response.Status.NOT_FOUND).build());
    }

}
