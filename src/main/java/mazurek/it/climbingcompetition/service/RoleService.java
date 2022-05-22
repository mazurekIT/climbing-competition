package mazurek.it.climbingcompetition.service;

import mazurek.it.climbingcompetition.exceptions.RoleDuplicationException;
import mazurek.it.climbingcompetition.model.Role;
import mazurek.it.climbingcompetition.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record RoleService(RoleRepository roleRepository) {

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role addRole(Role role) {
        roleRepository.findRoleByName(role.getName()).ifPresent(r -> {
            throw new RoleDuplicationException();
        });
        return roleRepository.save(role);
    }
}
