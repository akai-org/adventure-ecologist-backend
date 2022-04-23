package pl.org.akai.database;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.Instant;

@Data
@MongoEntity(collection="ThePerson")
public class GameStateEntity {
    private ObjectId id;
    private String email;
    private Instant lastLogin;
    private Integer a;
    private Integer b;
    private Integer c;
    private Integer d;
    private Integer e;
    private Integer f;

}
