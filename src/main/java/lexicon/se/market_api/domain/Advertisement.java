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

    // Constructors, Getters, Setters
}

