import client.Client;
import client.ClientCrudService;
import org.hibernate.Session;
import planet.PlanetCrudService;
import services.MigrationService;
import services.hibernate.HibernateUtil;
import ticket.Ticket;
import ticket.TicketCrudService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        //  new MigrationService().migrate();
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

        TicketCrudService ticketCrudService = new TicketCrudService(session);
        List<Ticket> ticketList = ticketCrudService.getAllTicket();
        System.out.println(ticketList);
        System.out.println(ticketCrudService.getTicketById(5));

    }
}
