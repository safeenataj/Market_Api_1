package lexicon.se.market_api.repository;



import com.marketplace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<lexicon.se.market_api.repository.User> findByEmail(String email);
}
