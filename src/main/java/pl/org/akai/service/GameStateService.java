package pl.org.akai.service;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pl.org.akai.database.GameStateEntity;
import pl.org.akai.database.GameStateRepository;

import javax.enterprise.context.ApplicationScoped;
import java.time.Instant;

@ApplicationScoped
@RequiredArgsConstructor
public class GameStateService {

    private final GameStateRepository gameStateRepository;

    public Uni<GameStateEntity> updateState(String email, GameStateEntity newState) {
        newState.setEmail(email);
        newState.setLastLogin(Instant.now());
        return gameStateRepository.findByEmail(email)
                                  .onItem().ifNotNull().transformToUni(oldState -> updateExistingState(oldState, newState))
                                  .onItem().ifNull().switchTo(() -> createState(newState));
    }

    private Uni<GameStateEntity> createState(GameStateEntity newState) {
        return gameStateRepository.persist(newState);
    }

    private Uni<GameStateEntity> updateExistingState(GameStateEntity oldState, GameStateEntity newState) {
        newState.setId(oldState.getId());
        return gameStateRepository.update(newState);
    }

}
