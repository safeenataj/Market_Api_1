package lexicon.se.market_api.controller;



import com.marketplace.dto.AdvertisementDTO;
import com.marketplace.entity.Advertisement;
import com.marketplace.entity.User;
import com.marketplace.service.AdvertisementService;
import com.marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Advertisement createAdvertisement(@RequestBody AdvertisementDTO advertisementDTO, @RequestParam String email) {
        User user = userService.findUserByEmail(email);
        return advertisementService.createAdvertisement(advertisementDTO, user);
    }

    @GetMapping("/user")
    public List<Advertisement> getAdvertisementsForUser(@RequestParam String email) {
        User user = userService.findUserByEmail(email);
        return advertisementService.getAdvertisementsForUser(user);
    }

    @GetMapping("/active")
    public List<Advertisement> getActiveAdvertisements() {
        return advertisementService.getActiveAdvertisements();
    }
}
