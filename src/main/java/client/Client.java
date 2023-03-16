package client;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import ticket.Ticket;

import java.util.List;

@Table(name = "client")
@Entity
@Data
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;


    @Column(nullable = false, length = 200)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "client")
    private List<Ticket> ticketList;


}