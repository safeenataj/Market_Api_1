package lexicon.se.market_api.service;



import com.marketplace.entity.Advertisement;
import com.marketplace.entity.User;
import com.marketplace.dto.AdvertisementDTO;
import com.marketplace.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    public Advertisement createAdvertisement(AdvertisementDTO advertisementDTO, User user) {
        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(advertisementDTO.getTitle());
        advertisement.setDescription(advertisementDTO.getDescription());
        advertisement.setPrice(advertisementDTO.getPrice());
        advertisement.setCategory(advertisementDTO.getCategory());
        advertisement.setCreatedDate(LocalDateTime.now());
        advertisement.setExpiredDate(advertisementDTO.getExpiredDate());
        advertisement.setUser(user);
        return advertisementRepository.save(advertisement);
    }

    public List<Advertisement> getAdvertisementsForUser(User user) {
        return advertisementRepository.findByUser(user);
    }

    public List<Advertisement> getActiveAdvertisements() {
        return advertisementRepository.findByExpiredDateBefore(LocalDateTime.now());
    }
}
