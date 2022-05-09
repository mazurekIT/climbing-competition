package mazurek.it.climbingcompetition.roles;

import lombok.RequiredArgsConstructor;
import mazurek.it.climbingcompetition.BasicController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
public class RoleController extends BasicController {
    private final RoleService roleService;

    @GetMapping
    public List<Role> getRoles() {
        return roleService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role addRole(@Valid @RequestBody Role role) {
        return roleService.addRole(role);
    }
}
