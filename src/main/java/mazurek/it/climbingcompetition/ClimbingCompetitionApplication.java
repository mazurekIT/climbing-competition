package mazurek.it.climbingcompetition;

import mazurek.it.climbingcompetition.dto.UserDTO;
import mazurek.it.climbingcompetition.model.User;
import mazurek.it.climbingcompetition.model.enums.Gender;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClimbingCompetitionApplication {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<Gender, String> genderStringConverter = en -> en.getSource() == null ? null : en.getSource().getFullName();

        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
                map().setRole(source.getRole().getName());
                using(genderStringConverter).map(source.getGender()).setGender(null);
                map().setWallsName(source.getWallNames());
            }
        });
        return modelMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClimbingCompetitionApplication.class, args);
    }

}
