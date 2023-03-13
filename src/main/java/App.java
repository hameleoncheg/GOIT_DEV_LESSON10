import client.Client;
import client.ClientCrudService;
import org.hibernate.Session;
import planet.PlanetCrudService;
import services.hibernate.HibernateUtil;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // new MigrationService().migrate();

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

        ClientCrudService clientCrudService = new ClientCrudService(session);
        PlanetCrudService planetCrudService = new PlanetCrudService(session);

        List<Client> existingClients = clientCrudService.getAllClients();

        long newClientAnn = clientCrudService.createNewClient("A");
        Client updateClient = clientCrudService.updateClientById(1, "MaxNEW");
        clientCrudService.deleteClientById(13);
        List<Client> newClientsList = clientCrudService.getAllClients();
        System.out.println(newClientsList);




    }
}
