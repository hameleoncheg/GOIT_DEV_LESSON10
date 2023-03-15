package ticket;

import client.Client;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import planet.Planet;

@Table(name = "ticket")
@Entity
@Data
public class Ticket {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "CREATED_AT")
    private String createdAt;

    //(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "FROM_PLANET_ID", nullable = false)
    private Planet planetFrom;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "TO_PLANET_ID", nullable = false)
    private Planet planetTo;

}