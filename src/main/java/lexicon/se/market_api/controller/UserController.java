package lexicon.se.market_api.controller;
import jakarta.validation.Valid;
import lexicon.se.market_api.domain.dto.UserDTOView;
import lexicon.se.market_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody @Valid UserDTOView userDTO) {
        userService.registerUser(userDTO); // You might need to convert DTO to Entity
        return ResponseEntity.noContent().build();
    }

  /*  @GetMapping("/{id}")
    public ResponseEntity<UserDTOView> getUserById(@PathVariable String id) {
        UserDTOView user = userService.getUserById(id); // Retrieve user by ID
        return ResponseEntity.ok(user);
    }*/

    // Additional user-related endpoints can be added here
}
