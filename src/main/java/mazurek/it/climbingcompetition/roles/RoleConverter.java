package mazurek.it.climbingcompetition.roles;

import mazurek.it.climbingcompetition.walls.Wall;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {
    @Override
    public String convertToDatabaseColumn(Role role) {
        if (role == null) {
            return null;
        }
        return role.getCode();
    }

    @Override
    public Role convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(Role.values())
                .filter(g -> g.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
