package planet;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import ticket.Ticket;

import java.util.List;

@Table(name = "planet")
@Entity
@Data
public class Planet {
    @Id
    private String id;

    @Column(nullable = false, length = 200)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "planetFrom")
    private List<Ticket> ticketsFromList;

    @ToString.Exclude
    @OneToMany(mappedBy = "planetTo")
    private List<Ticket> ticketsToList;


}