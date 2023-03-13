package client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class ClientCrudService {
    private final Session session;

    public ClientCrudService(Session session) {
        this.session = session;
    }

    public long createNewClient(String name) {
        Client newClient = new Client();
        if (name.length() < 2) {
            System.out.println("Error. The name must be 3 or more characters.");
        } else if (name.length() > 200) {
            System.out.println("Error. The name must be less than 200 characters.");
        } else {
            Transaction transaction = session.beginTransaction();
            newClient.setName(name);
            session.persist(newClient);
            transaction.commit();
            System.out.println("A new client has been created. New client: " + newClient);
        }
        return newClient.getId();
    }

    public List<Client> getAllClients() {
        return session.createQuery("from Client", Client.class).list();
    }

    public Client getClientById(long id) {
        Client client = session.get(Client.class, id);

        if (client == null) {
            System.out.println("The client with id: " + id + " does not exist.");
        } else {
            System.out.println(client);
        }
        return client;
    }

    public Client updateClientById(long id, String newName) {
        Transaction transaction = session.beginTransaction();
        Client updateClient = getClientById(id);
        if (updateClient != null) {
            updateClient.setName(newName);
            session.persist(updateClient);
            transaction.commit();
            System.out.println("The client with id: " + id + " has been updated.");
        }
        return updateClient;
    }

    public void deleteClientById(long id) {
        Transaction transaction = session.beginTransaction();

        Client client = session.get(Client.class, id);

        if (client == null) {
            System.out.println("The client with id: " + id + " wasn't found.");
        } else {
            NativeQuery query = session.createNativeQuery("delete from Client where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            System.out.println("The client with id: " + id + " was deleted.");
        }

        transaction.commit();
    }
}
