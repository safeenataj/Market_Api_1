package lexicon.se.market_api.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class UserConfig {

    @Value("${user.default.role}")
    private String defaultUserRole;

    @Value("${user.max.advertisements}")
    private Integer maxAdvertisements;

    @Bean
    public String userRole() {
        return defaultUserRole;  // You can return other properties as needed
    }

    @Bean
    public Integer userMaxAdvertisements() {
        return maxAdvertisements;  // You can return other properties as needed
    }
}

