package lexicon.se.market_api.service;



import lexicon.se.market_api.domain.entity.User;
import lexicon.se.market_api.domain.dto.UserDTOView;
import lexicon.se.market_api.exception.UserNotFoundException;
import lexicon.se.market_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserDTOView userDTO) {
        if (userDTO == null) throw new IllegalArgumentException("User data is null.");

        // Map UserDTO to User entity
        User user = User.builder()
                .email(userDTO.getEmail())

                .isActive(true) // Setting default active status to true
                .build();

        // Save and return the created user
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found."));
    }

    @Override
    public User authenticateUser(String email, String password) {
        User user = findUserByEmail(email);
        if (!user.getPassword().equals(password)) {
            throw new UserNotFoundException("Invalid credentials.");
        }
        return user;
    }

    @Override
    public void registerUser(UserDTOView userDTO) {

    }
}

