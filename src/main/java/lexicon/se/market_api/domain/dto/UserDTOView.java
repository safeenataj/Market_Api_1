package lexicon.se.market_api.domain.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class UserDTOView {
    private String email;
    private List<AdvertisementDTOView> advertisements;
}