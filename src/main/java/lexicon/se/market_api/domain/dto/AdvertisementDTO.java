package lexicon.se.market_api.domain.dto;


import java.time.LocalDateTime;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AdvertisementDTO {

    @NotBlank(message = "Title cannot be empty.")
    private String title;

    @NotBlank(message = "Description cannot be empty.")
    private String description;

    @Positive(message = "Price must be a positive number.")
    private double price;

    @NotBlank(message = "Category cannot be empty.")
    private String category;

    @NotNull(message = "Expired date cannot be null.")
    private LocalDateTime expiredDate;
}
