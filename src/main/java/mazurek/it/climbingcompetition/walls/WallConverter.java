package mazurek.it.climbingcompetition.walls;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class WallConverter implements AttributeConverter<Wall, String> {
    @Override
    public String convertToDatabaseColumn(Wall wall) {
        if (wall == null) {
            return null;
        }
        return wall.getCode();
    }

    @Override
    public Wall convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(Wall.values())
                .filter(g -> g.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
