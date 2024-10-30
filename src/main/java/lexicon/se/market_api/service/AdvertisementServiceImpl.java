package lexicon.se.market_api.service;



import lexicon.se.market_api.converter.UserConverterImpl;
import lexicon.se.market_api.domain.entity.Advertisement;
import lexicon.se.market_api.domain.entity.User;
import lexicon.se.market_api.domain.dto.AdvertisementDTOForm;
import lexicon.se.market_api.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final UserConverterImpl userConverter;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository, UserConverterImpl userConverter) {
        this.advertisementRepository = advertisementRepository;
        this.userConverter = userConverter;
    }

    @Override
    public void createAdvertisement(AdvertisementDTOForm advertisementDTO) {
        if (advertisementDTO == null) throw new IllegalArgumentException("Advertisement data is null.");

        // Map AdvertisementDTO to Advertisement entity
        Advertisement advertisement = Advertisement.builder()
                .title(advertisementDTO.getTitle())
                .description(advertisementDTO.getDescription())
                .price(advertisementDTO.getPrice())
                .category(advertisementDTO.getCategory())
                .createdDate(LocalDateTime.now())
                .expiredDate(advertisementDTO.getExpiredDate())
                .user(userConverter.formToEntity(advertisementDTO.getUser()))
                .build();

        // Save and return the created advertisement
        advertisementRepository.save(advertisement);
    }

    @Override
    public List<Advertisement> getAdvertisementsForUser(User user) {
        return advertisementRepository.findByUser(user);
    }

    @Override
    public List<Advertisement> getActiveAdvertisements() {
        return advertisementRepository.findByExpiredDateBefore(LocalDateTime.now());
    }

    @Override
    public AdvertisementDTOForm getAdvertisementById(Long id) {
        return null;
    }
}
