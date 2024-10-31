package lexicon.se.market_api.converter;


import lexicon.se.market_api.domain.dto.AdvertisementDTOForm;
import lexicon.se.market_api.domain.dto.AdvertisementDTOView;
import lexicon.se.market_api.domain.entity.Advertisement;

public interface AdvertisementConverter {
    Advertisement formToEntitySave(AdvertisementDTOForm dto);

    Advertisement formToEntityUpdate(AdvertisementDTOForm dto);

    AdvertisementDTOView entityToView(Advertisement entity);

    Advertisement viewToEntity(AdvertisementDTOView dto);
}