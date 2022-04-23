package pl.org.akai.database;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameStateRepository implements PanacheMongoRepository<GameStateEntity> {
}
