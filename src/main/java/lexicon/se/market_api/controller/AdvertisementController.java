package lexicon.se.market_api.controller;




import jakarta.validation.Valid;
import lexicon.se.market_api.domain.dto.AdvertisementDTOForm;
import lexicon.se.market_api.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/advertisements")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping
    public ResponseEntity<Void> createAdvertisement(@RequestBody @Valid AdvertisementDTOForm advertisementDTO) {
        advertisementService.createAdvertisement(advertisementDTO); // You might need to convert DTO to Entity
        ResponseEntity<Void> build = ResponseEntity.noContent().build();
        return build;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertisementDTOForm> getAdvertisementById(@PathVariable Long id) {
        AdvertisementDTOForm advertisement = advertisementService.getAdvertisementById(id); // Retrieve advertisement by ID
        return ResponseEntity.ok(advertisement);
    }

    // Additional advertisement-related endpoints can be added here
}
