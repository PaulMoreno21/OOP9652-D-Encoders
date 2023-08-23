package ec.edu.espe.ferrinventory.controller;

import ec.edu.espe.ferrinventory.utils.MongoConnection;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.MongoClientException;
import javax.swing.JOptionPane;

public class SuplierController {
    private static final String COLLECTION_NAME = "Suplier"; 
    
    public static void addSuplier(String name, String phone, String address, String email) {
        try {
     
            MongoCollection<Document> collection = MongoConnection.getConnection(COLLECTION_NAME);

            Document newSupplier = new Document()
                .append("name", name)
                .append("phone", phone)
                .append("address", address)
                .append("email", email);
            
            collection.insertOne(newSupplier);
            
            JOptionPane.showMessageDialog(null, "Nuevo proveedor agregado a la base de datos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoClientException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con MongoDB Atlas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          
        }
    }
    
     public static void removeSuplierByName(String name) {
        try {
            MongoCollection<Document> collection = MongoConnection.getConnection(COLLECTION_NAME);

            Document filter = new Document("name", name);

            collection.deleteOne(filter);

            JOptionPane.showMessageDialog(null, "Proveedor eliminado de la base de datos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (MongoClientException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con MongoDB Atlas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
