package mazurek.it.climbingcompetition.controller.rest;

import lombok.RequiredArgsConstructor;
import mazurek.it.climbingcompetition.model.enums.Gender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/genders")
@RequiredArgsConstructor
public class GenderController {

    @GetMapping()
    public List<String> getGender() {
        return Arrays.stream(Gender.values()).map(Gender::getFullName).collect(Collectors.toList());
    }
}
