package mazurek.it.climbingcompetition.service;

import lombok.RequiredArgsConstructor;
import mazurek.it.climbingcompetition.exceptions.MailDuplicationException;
import mazurek.it.climbingcompetition.exceptions.PhoneDuplicatedException;
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
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User addUser(User user) {
        userRepository.findUserByMail(user.getMail()).ifPresent(u -> {
            throw new MailDuplicationException();
        });
        userRepository.findUserByPhone(user.getPhone()).ifPresent(u -> {
            throw new PhoneDuplicatedException();
        });
        return userRepository.save(user);
    }

}
