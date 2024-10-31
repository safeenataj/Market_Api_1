package lexicon.se.market_api.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false, length = 65000)
    private String description;

    @Column(nullable = false)
    private double price;

    private String category;

    private LocalDateTime createdDate;
    private LocalDateTime expiredDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @PrePersist
    public void setCreatedDate() {
        createdDate = LocalDateTime.now();
    }
}