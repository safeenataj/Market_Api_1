package lexicon.se.market_api.repository;





import lexicon.se.market_api.domain.Advertisement;
import lexicon.se.market_api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findByUser(User user);
    List<Advertisement> findByExpiredDateBefore(LocalDateTime now);
}
