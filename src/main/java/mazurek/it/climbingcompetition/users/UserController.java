package mazurek.it.climbingcompetition.users;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/users")
    public Iterable<User> createListUsers(@RequestBody Iterable<User> users) {
        return userRepository.saveAll(users);
    }


}
