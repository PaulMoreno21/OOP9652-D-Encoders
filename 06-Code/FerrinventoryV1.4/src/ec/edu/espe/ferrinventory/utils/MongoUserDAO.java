package ec.edu.espe.ferrinventory.utils;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import ec.edu.espe.ferrinventory.model.Admin;
import ec.edu.espe.ferrinventory.model.Manager;
import ec.edu.espe.ferrinventory.model.User;

public class MongoUserDAO implements UserDAO {
    private final MongoCollection<Document> collection;

    public MongoUserDAO(MongoCollection<Document> collection) {
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
                return Admin.getInstance(); // Devuelve la instancia única de Admin
            } else if ("managerType".equals(typeUser)) {
                return new Manager(0, name, password, permissions, typeUser);
            }
        }

        return null;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }
}
