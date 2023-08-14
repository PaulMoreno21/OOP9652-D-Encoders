package ec.edu.espe.ferrinventory.controller;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import ec.edu.espe.ferrinventory.model.Admin;
import ec.edu.espe.ferrinventory.model.Manager;
import ec.edu.espe.ferrinventory.model.User;
import ec.edu.espe.ferrinventory.controller.UserDAOController;

public class MongoUserDAOController implements UserDAOController {
    private final MongoCollection<Document> collection;

    public MongoUserDAOController(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    @Override
    public User findByUsername(String username) {
        Document query = new Document("name", username);
        Document result = collection.find(query).first();

        if (result != null) {
            String name = result.getString("name");
            String password = result.getString("password");
            boolean permissions = result.getBoolean("permissions");
            String typeUser = result.getString("typeUser");

            if ("adminType".equals(typeUser)) {
                Admin admin = new Admin(0, name, password, permissions, typeUser);
                return admin;
            } else if ("managerType".equals(typeUser)) {
                Manager manager = new Manager(0, name, password, permissions, typeUser);
                return manager;
            }
        }

        return null;
    }
}
