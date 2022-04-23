package pl.org.akai.database;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameStateRepository implements ReactivePanacheMongoRepository<GameStateEntity> {

    public Uni<GameStateEntity> findByEmail(String email) {
        return find("email", email).firstResult();
    }
}
