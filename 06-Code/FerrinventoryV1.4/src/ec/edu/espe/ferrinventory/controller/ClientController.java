package ec.edu.espe.ferrinventory.controller;
import ec.edu.espe.ferrinventory.utils.MongoConnection;
import ec.edu.espe.ferrinventory.model.Client;
import ec.edu.espe.ferrinventory.view.FrmClient;
import ec.edu.espe.ferrinventory.view.FrmSellMenu;
import org.bson.Document;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientController extends CrudController<Client> implements ActionListener {
    private final FrmClient view;

   public ClientController(FrmClient view) {
        super(MongoConnection.getConnection("Client"));
        this.view = view;
        this.view.btnAddClient.addActionListener(this::addClientActionPerformed);
        this.view.btnSearchClient.addActionListener(this::searchClientActionPerformed);
        this.view.BtnUpdateClient.addActionListener(this::updateClientActionPerformed);
        this.view.BtnDeleteClient.addActionListener(this::deleteClientActionPerformed);
        this.view.btnCancelClient.addActionListener(this::cancelClientActionPerformed);
    }

    
    private void cancelClientActionPerformed(ActionEvent e) {
        cancel(view);
        FrmSellMenu frmSellMenu = new FrmSellMenu();
        frmSellMenu.setVisible(true);
    }

    private void cancel(FrmClient view) {
        clearFields(view.txtNameClient, view.txtEmailClient, view.txtDirectionClient, view.txtPhoneClient);
    }
private void addClientActionPerformed(ActionEvent e) {
    String name = view.txtNameClient.getText(); 
    String email = view.txtEmailClient.getText();
    String address = view.txtDirectionClient.getText(); 
    String phone = view.txtPhoneClient.getText(); 

    if (name.isEmpty() || email.isEmpty() || address.isEmpty() || phone.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int nextId = getLastClientIdFromDatabase() + 1; // Obtener el siguiente ID disponible

    Client newClient = new Client(name, email, address, phone); // Crear el cliente sin proporcionar el ID

    Document clientDoc = new Document("id", nextId)
            .append("name", newClient.getName())
            .append("email", newClient.getEmail())
            .append("address", newClient.getAddress())
            .append("phone", newClient.getPhone());

    create(newClient, clientDoc);

    JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente.");
    clearFields(view.txtNameClient, view.txtEmailClient, view.txtDirectionClient, view.txtPhoneClient);
}



private int getLastClientIdFromDatabase() {
    Document sortDescById = new Document("id", -1);
    Document lastClient = collection.find().sort(sortDescById).first();

    if (lastClient != null) {
        return lastClient.getInteger("id");
    }
    return 0; // Si no hay clientes en la base de datos, comenzar desde 0
}

private void searchClientActionPerformed(ActionEvent e) {
    String nameToSearch = view.txtNameClient.getText();
    String phoneToSearch = view.txtPhoneClient.getText(); 
    String addressToSearch = view.txtDirectionClient.getText(); 
    String emailToSearch = view.txtEmailClient.getText();

    if (nameToSearch.isEmpty() && phoneToSearch.isEmpty() && addressToSearch.isEmpty()&& emailToSearch.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor ingrese al menos un campo para buscar.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    Document queryDocument = new Document();

    if (!nameToSearch.isEmpty()) {
        queryDocument.append("name", nameToSearch);
    }

    if (!phoneToSearch.isEmpty()) {
        queryDocument.append("phone", phoneToSearch);
    }

    if (!addressToSearch.isEmpty()) {
        queryDocument.append("address", addressToSearch);
    }
    
    if (emailToSearch.isEmpty()) {
    } else {
        queryDocument.append("email", emailToSearch);
        }

     Client foundClient = find(queryDocument);

if (foundClient != null) {
    int clientIdFromDatabase = getClientIdFromDatabase(foundClient.getName());


    JOptionPane.showMessageDialog(null, """
                                    Cliente encontrado:
                                    ID: """ + clientIdFromDatabase + "\n" +
        "Nombre: " + foundClient.getName() + "\n" +
        "Email: " + foundClient.getEmail() + "\n" +
        "Dirección: " + foundClient.getAddress() + "\n" +
        "Teléfono: " + foundClient.getPhone(), "Cliente Encontrado", JOptionPane.INFORMATION_MESSAGE);
} else {
    JOptionPane.showMessageDialog(null, "Cliente no encontrado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
}

}

private int getClientIdFromDatabase(String name) {
    Document query = new Document("name", name);
    Document clientDoc = collection.find(query).first();

    if (clientDoc != null) {
        return clientDoc.getInteger("id");
    }

    return 0;
}

    private Client mapClientFromDocument(Document clientDoc) {
        String clientName = clientDoc.getString("name");
        String clientEmail = clientDoc.getString("email");
        String clientAddress = clientDoc.getString("address");
        String clientPhone = clientDoc.getString("phone");

        return new Client(clientName, clientEmail, clientAddress, clientPhone);
    }

private void deleteClientActionPerformed(ActionEvent e) {
    String nameToDelete = view.txtNameClient.getText();

    if (nameToDelete.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre del cliente a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Client clientToDelete = findClientByName(nameToDelete);

    if (clientToDelete != null) {
        int confirm = JOptionPane.showConfirmDialog(null,
                """
                Est\u00e1 a punto de eliminar el siguiente cliente:
                
                Nombre: """ + clientToDelete.getName() + "\n" +
                        "Email: " + clientToDelete.getEmail() + "\n" +
                        "Dirección: " + clientToDelete.getAddress() + "\n" +
                        "Teléfono: " + clientToDelete.getPhone() + "\n\n" +
                        "¿Está seguro de que desea eliminar este cliente?",
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            Document filter = new Document("name", nameToDelete);
            delete(filter);
            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con el nombre proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private Client findClientByName(String name) {
    Document query = new Document("name", name);
    Document clientDoc = collection.find(query).first();

    if (clientDoc == null) {
        return null;
    }

    String clientName = clientDoc.getString("name");
    String clientEmail = clientDoc.getString("email");
    String clientAddress = clientDoc.getString("address");
    String clientPhone = clientDoc.getString("phone");

    return new Client(clientName, clientEmail, clientAddress, clientPhone);
}

private void updateClientActionPerformed(ActionEvent e) {
    String nameToUpdate = view.txtNameClient.getText();

    if (nameToUpdate.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre del cliente a actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Client clientToUpdate = findClientByName(nameToUpdate);

    if (clientToUpdate != null) {
        String newEmail = JOptionPane.showInputDialog("Ingrese el nuevo correo electrónico:", clientToUpdate.getEmail());
        String newAddress = JOptionPane.showInputDialog("Ingrese la nueva dirección:", clientToUpdate.getAddress());
        String newPhone = JOptionPane.showInputDialog("Ingrese el nuevo teléfono:", clientToUpdate.getPhone());

        if (newEmail != null && newAddress != null && newPhone != null) {
            clientToUpdate.setEmail(newEmail);
            clientToUpdate.setAddress(newAddress);
            clientToUpdate.setPhone(newPhone);

            Document filter = new Document("name", nameToUpdate);
            Document update = new Document("$set", new Document("email", newEmail)
                    .append("address", newAddress)
                    .append("phone", newPhone));

            update(filter, update);

            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con el nombre proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

   private Client find(Document queryDocument) {
    Document clientDoc = collection.find(queryDocument).first();

    if (clientDoc != null) {
        return mapClientFromDocument(clientDoc);
    }

    return null;
}


    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == view.btnAddClient) {
        addClientActionPerformed(e);
    } else if (e.getSource() == view.btnSearchClient) {
        searchClientActionPerformed(e);
    } else if (e.getSource() == view.BtnUpdateClient) {
        updateClientActionPerformed(e);
    } else if (e.getSource() == view.BtnDeleteClient) {
        deleteClientActionPerformed(e);
    } else if (e.getSource() == view.btnCancelClient) {
        cancelClientActionPerformed(e);
    }
    
}

  
}