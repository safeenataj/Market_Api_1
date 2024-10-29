package lexicon.se.market_api.service;


import jakarta.validation.Valid;
import lexicon.se.market_api.domain.entity.User;
import lexicon.se.market_api.domain.dto.UserDTOView;

public interface UserService {
    User createUser(UserDTOView userDTO);  // Method to create a new user
    User findUserByEmail(String email); // Method to find a user by email
    User authenticateUser(String email, String password); // Method for user authentication

    void registerUser(@Valid UserDTOView userDTO);

    UserDTOView getUserById(Long id);
}
