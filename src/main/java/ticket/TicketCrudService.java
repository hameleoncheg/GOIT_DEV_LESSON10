package ticket;

import client.Client;
import client.ClientCrudService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import planet.Planet;
import planet.PlanetCrudService;

import java.util.List;

public class TicketCrudService {
    private final Session session;

    public TicketCrudService(Session session) {
        this.session = session;
    }

    public long createNewTicket(Client client, Planet planetFrom, Planet planetTo) {
        if (client != null && planetFrom != null && planetTo != null) {
            Client existingClient = new ClientCrudService(session).getClientById(client.getId());
            Planet existingPlanetFrom = new PlanetCrudService(session).getPlanetById(planetFrom.getId());
            Planet existingPlanetTo = new PlanetCrudService(session).getPlanetById(planetTo.getId());

            if (existingClient != null && existingPlanetFrom != null && existingPlanetTo != null) {
                if (planetFrom.equals(planetTo)) {
                    System.out.println("The planet of departure and the planet of arrival must be different.");
                } else {
                    Ticket newTicket = new Ticket();

                    Transaction transaction = session.beginTransaction();
                    newTicket.setClient(client);
                    newTicket.setPlanetFrom(planetFrom);
                    newTicket.setPlanetTo(planetTo);
                    session.persist(newTicket);
                    transaction.commit();

                    return newTicket.getId();
                }
            }
        }
        System.out.println("Not exist.");
        return -1;
    }

    public List<Ticket> getAllTicket() {
        return session.createQuery("from Ticket", Ticket.class).list();
    }

    public Ticket getTicketById(long id) {
        return session.get(Ticket.class, id);
    }

    public Ticket updateTicket(long id, Client client, Planet planetFrom, Planet planetTo) {
        Transaction transaction = session.beginTransaction();
        Ticket updatingTicket = getTicketById(id);
        updatingTicket.setClient(client);
        updatingTicket.setPlanetFrom(planetFrom);
        updatingTicket.setPlanetTo(planetTo);
        session.persist(updatingTicket);
        transaction.commit();

        return updatingTicket;
    }

    public void deleteTicketById(long id) {
        Transaction transaction = session.beginTransaction();

        NativeQuery query = session.createNativeQuery("delete from Ticket where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        transaction.commit();

        if (result > 0) {
            System.out.println("Ticket was deleted.");
        }
    }
}
