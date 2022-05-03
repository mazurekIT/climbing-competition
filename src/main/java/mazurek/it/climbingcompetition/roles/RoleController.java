package mazurek.it.climbingcompetition.roles;

import mazurek.it.climbingcompetition.BasicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RoleController extends BasicController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/role")
    public List<Role> getAll() {
        return roleService.findAll();
    }

    @PostMapping("/role")
    public Role addRole(@Valid @RequestBody Role role) {
        return roleService.addRole(role);
    }

    @PostMapping("/roles")
    public List<Role> addListOfRoles(@Valid @RequestBody List<Role> roles) {
        return roleService.addListOfRole(roles);
    }
}
