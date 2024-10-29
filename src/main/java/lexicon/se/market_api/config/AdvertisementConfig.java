package lexicon.se.market_api.config;



import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AdvertisementConfig {

    @Value("${advertisement.default.status}")
    private String defaultAdvertisementStatus;

    @Value("${advertisement.max.length}")
    private Integer maxAdvertisementLength;

    @Bean
    public String advertisementStatus() {
        return defaultAdvertisementStatus;  // You can return other properties as needed
    }

    @Bean
    public Integer advertisementMaxLength() {
        return maxAdvertisementLength;  // You can return other properties as needed
    }
}
