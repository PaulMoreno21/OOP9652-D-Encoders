package ec.edu.espe.ferrinventory.model;

import java.util.HashMap;
import java.util.Map;

public class ClientsRegister {
    private static int nextRegisterId = 1;
    private Map<Integer, Client> registerEntries;

    public ClientsRegister() {
        registerEntries = new HashMap<>();
    }

    public void addRegister(Client client) {
        client.setId(nextRegisterId);
        registerEntries.put(nextRegisterId, client);
        nextRegisterId++;
    }

    public void removeRegister(Client client) {
        registerEntries.remove(client.getId());
    }

    public Client getClientById(int clientId) {
        return registerEntries.get(clientId);
    }

    public Map<Integer, Client> getAllClients() {
        return registerEntries;
    }
}
