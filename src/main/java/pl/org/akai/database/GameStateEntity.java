package pl.org.akai.database;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.Instant;

@Data
@MongoEntity(collection="GameState")
public class GameStateEntity {
    private ObjectId id;
    private String email;
    private Instant lastLogin;
    private Long treeCount;
    private Long solarPanelCount;
    private Long bicyclePathCount;
    private Long secondHandCount;
    private Long vegeBarCount;
    private Long nuclearPowerPlantCount;
    private Long balance;
    private Long multiplier;

}
