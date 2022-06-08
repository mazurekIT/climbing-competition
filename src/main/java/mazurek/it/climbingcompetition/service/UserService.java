package mazurek.it.climbingcompetition.service;

import mazurek.it.climbingcompetition.dto.UserDTO;
import mazurek.it.climbingcompetition.exceptions.MailDuplicationException;
import mazurek.it.climbingcompetition.exceptions.PhoneDuplicatedException;
import mazurek.it.climbingcompetition.exceptions.UserNotFoundException;
import mazurek.it.climbingcompetition.model.User;
import mazurek.it.climbingcompetition.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private UserDTO convertEntityToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
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
