package mazurek.it.climbingcompetition.service;

import lombok.RequiredArgsConstructor;
import mazurek.it.climbingcompetition.exceptions.UserNotFoundException;
import mazurek.it.climbingcompetition.model.User;
import mazurek.it.climbingcompetition.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> addListOfUsers(List<User> users) {
        return (List<User>) userRepository.saveAll(users);
    }
}
