package lexicon.se.market_api.service;




import lexicon.se.market_api.domain.entity.Advertisement;
import lexicon.se.market_api.domain.entity.User;
import lexicon.se.market_api.domain.dto.AdvertisementDTOForm;

import java.util.List;

public interface AdvertisementService {
    void createAdvertisement(AdvertisementDTOForm advertisementDTO); // Method to create an advertisement
    List<Advertisement> getAdvertisementsForUser(User user); // Method to retrieve ads by user
    List<Advertisement> getActiveAdvertisements(); // Method to retrieve active ads

    AdvertisementDTOForm getAdvertisementById(Long id);
}
