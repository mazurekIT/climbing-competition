package mazurek.it.climbingcompetition.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> addListOfRole(List<Role> roles) {
        return (List<Role>) roleRepository.saveAll(roles);
    }

    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }
}
