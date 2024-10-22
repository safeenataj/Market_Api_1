package lexicon.se.market_api.domain;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertisementId;

    @Column(nullable = false)
    private String title;

    private String description;
    private double price;
    private LocalDateTime createdDate;
    private LocalDateTime expiredDate;
    private String category;

    @ManyToOne
    private User user;

    public void setTitle(Object title) {
    }

    public void setDescription(Object description) {
    }

    public void setUser(User user) {
    }

    public void setExpiredDate(Object expiredDate) {
    }

    public void setCreatedDate(LocalDateTime now) {
    }

    public void setCategory(Object category) {
    }

    public void setPrice(Object price) {
    }

    // Constructors, Getters, Setters
}

