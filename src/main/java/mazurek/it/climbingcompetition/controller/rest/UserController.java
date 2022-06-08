package mazurek.it.climbingcompetition.controller.rest;

import lombok.RequiredArgsConstructor;
import mazurek.it.climbingcompetition.dto.UserDTO;
import mazurek.it.climbingcompetition.model.User;
import mazurek.it.climbingcompetition.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }
}

