package lexicon.se.market_api.config;



import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource(value = {"classpath:advertisement.properties"})
public class AdvertisementProperties {

    @Value("${advertisement.default.status}")
    private String defaultAdvertisementStatus;

    @Value("${advertisement.max.length}")
    private Integer maxAdvertisementLength;
}
