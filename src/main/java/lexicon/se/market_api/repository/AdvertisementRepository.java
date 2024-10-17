package lexicon.se.market_api.repository;





import lexicon.se.market_api.domain.Advertisement;
import lexicon.se.market_api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findByUser(User user);
    List<Advertisement> findByExpiredDateBefore(LocalDateTime now);
}

