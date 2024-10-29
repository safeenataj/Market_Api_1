package lexicon.se.market_api.config;



import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource(value = {"classpath:user.properties"})
public class UserProperties {

    @Value("${user.default.role}")
    private String defaultUserRole;

    @Value("${user.max.advertisements}")
    private Integer maxAdvertisements;
}
