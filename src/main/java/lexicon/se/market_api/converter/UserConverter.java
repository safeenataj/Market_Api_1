package lexicon.se.market_api.converter;


import lexicon.se.market_api.domain.dto.UserDTOForm;
import lexicon.se.market_api.domain.dto.UserDTOView;
import lexicon.se.market_api.domain.entity.User;

public interface UserConverter {
    User formToEntity(UserDTOForm dto);

    UserDTOView entityToView(User entity);

    User viewToEntity(UserDTOView dto);
}