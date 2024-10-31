package lexicon.se.market_api.domain.entity;


import jakarta.persistence.*;
import lexicon.se.market_api.domain.entity.Advertisement;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean isActive;

    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "user")
    private List<Advertisement> advertisements;

    @PrePersist
    public void initialData() {
        createdDate = LocalDateTime.now();
        isActive = true; // Default to active when created
    }
}
