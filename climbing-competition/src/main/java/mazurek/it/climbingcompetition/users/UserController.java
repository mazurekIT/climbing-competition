package mazurek.it.climbingcompetition.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public List<User> getUsersByName(@RequestParam(value = "name",defaultValue = "Maz") String name) {
        return userRepository.findUsersByLastName(name);
    }

}
