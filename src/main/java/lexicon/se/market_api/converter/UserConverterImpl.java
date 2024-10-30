package lexicon.se.market_api.converter;



import lexicon.se.market_api.domain.dto.AdvertisementDTOView;
import lexicon.se.market_api.domain.dto.UserDTOForm;
import lexicon.se.market_api.domain.dto.UserDTOView;
import lexicon.se.market_api.domain.entity.Advertisement;
import lexicon.se.market_api.domain.entity.User;
import lexicon.se.market_api.util.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserConverterImpl implements UserConverter {

    AdvertisementConverterImpl advertisementConverter;

    CustomPasswordEncoder customPasswordEncoder;

    @Autowired
    public UserConverterImpl(AdvertisementConverterImpl advertisementConverter, CustomPasswordEncoder customPasswordEncoder) {
        this.advertisementConverter = advertisementConverter;
        this.customPasswordEncoder = customPasswordEncoder;
    }

    @Override
    public User formToEntity(UserDTOForm dto) {
        return User.builder()
                .email(dto.getEmail())
               .password(customPasswordEncoder.encode(dto.getPassword()))
                .build();
    }

    @Override
    public UserDTOView entityToView(User entity) {
        List<Advertisement> advertisementEntities = entity.getAdvertisements();
        List<AdvertisementDTOView> advertisementDTOViews = new ArrayList<>();
        if (advertisementEntities != null) {
            advertisementDTOViews = advertisementEntities
                    .stream()
                    .map(advertisement -> advertisementConverter.entityToView(advertisement))
                    .toList();
        }
        return UserDTOView.builder()
                .email(entity.getEmail())
                .advertisements(advertisementDTOViews)
                .build();
    }


    @Override
    public User viewToEntity(UserDTOView dto) {

        List<AdvertisementDTOView> advertisementDTOViews = dto.getAdvertisements();
        List<Advertisement> advertisementEntities = new ArrayList<>();
        if (advertisementDTOViews != null) {
            advertisementEntities = advertisementDTOViews
                    .stream()
                    .map(advertisement -> advertisementConverter.viewToEntity(advertisement))
                    .toList();
        }
        return User.builder()
                .email(dto.getEmail())
                .advertisements(advertisementEntities)
                .build();
    }


}