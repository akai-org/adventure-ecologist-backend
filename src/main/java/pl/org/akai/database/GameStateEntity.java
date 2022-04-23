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
    private Integer treeCount;
    private Integer solarPanelCount;
    private Integer bicyclePathCount;
    private Integer secondHandCount;
    private Integer vegeBarCount;
    private Integer nuclearPowerPlantCount;

}
