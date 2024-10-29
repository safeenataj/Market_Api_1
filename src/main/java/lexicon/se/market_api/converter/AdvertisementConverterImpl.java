package lexicon.se.market_api.converter;

import lexicon.se.market_api.domain.dto.AdvertisementDTOForm;
import lexicon.se.market_api.domain.dto.AdvertisementDTOView;
import lexicon.se.market_api.domain.entity.Advertisement;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementConverterImpl implements AdvertisementConverter {
    @Override
    public Advertisement formToEntitySave(AdvertisementDTOForm dto) {
        return Advertisement.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .build();
    }

    @Override
    public Advertisement formToEntityUpdate(AdvertisementDTOForm dto) {
        return Advertisement.builder()
          //      .AdvertisementId(dto.getAdvertisementId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .createdDate(dto.getCreatedDate())
                .expiredDate(dto.getExpiredDate())
                .category(dto.getCategory())

                .build();
    }

    @Override
    public AdvertisementDTOView entityToView(Advertisement entity) {
        return AdvertisementDTOView.builder()
              //  .advertisementId(entity.getAdvertisementId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .createdDate(entity.getCreatedDate())
                .expiredDate(entity.getExpiredDate())
                .category(entity.getCategory())
                .build();
    }

    @Override
    public Advertisement viewToEntity(AdvertisementDTOView dto) {
        return Advertisement.builder()
              //  .advertisementId(dto.getAdvertisementId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .createdDate(dto.getCreatedDate())
                .expiredDate(dto.getExpiredDate())
                .category(dto.getCategory())
                .build();
    }
}