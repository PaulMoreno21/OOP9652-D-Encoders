package ec.edu.espe.ferrinventory.controller;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import ec.edu.espe.ferrinventory.model.Product;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class ProductController {

    public static void addToProductsCollection(Product product) {
        MongoCollection<Document> collectionProducts = MongoConnection.getConnection("Products");
        Document productDoc = new Document("_id", new ObjectId())
                .append("id", product.getId())
                .append("name", product.getName())
                .append("category", product.getCategory())
                .append("brand", product.getBrand())
                .append("cost", product.getCost())
                .append("price", product.getPrice())
                .append("stock", product.getStock());
        collectionProducts.insertOne(productDoc);
    }

    public static Product findProduct(String name) {
        Gson gson = new Gson();
        MongoCollection<Document> collection = MongoConnection.getConnection("Products");
        Bson filter = Filters.eq("name", name);
        MongoCursor<Document> cursor = collection.find(filter).limit(1).iterator();

        if (cursor.hasNext()) {
            Document doc = collection.find(filter).first();
            String productDoc = doc.toJson();
            Product product = gson.fromJson(productDoc, Product.class);
            return product;
        }
        return null;
    }

public static boolean removeProducts(String name, int quantity) {
        MongoCollection<Document> collection = MongoConnection.getConnection("Products");

        Bson filter = Filters.and(Filters.eq("name", name));
        FindIterable<Document> productsToDelete = collection.find(filter).limit(quantity);

        int deletedCount = 0;
        for (Document product : productsToDelete) {
            collection.deleteOne(product);
            deletedCount++;
        }

        return deletedCount == quantity;
    }


public static void updateProduct(Product product) {
        MongoCollection<Document> collection = MongoConnection.getConnection("Products");
        Bson filter = Filters.and(Filters.eq("name", product.getName()));
        Bson productUpdates = Updates.combine(
                Updates.set("name", product.getName()),
                Updates.set("category", product.getCategory()),
                Updates.set("cost", product.getCost()), // Actualizar también el costo
                Updates.set("price", product.getPrice()),
                Updates.set("stock", product.getStock())); // Asegúrate de agregar el stock aquí
        collection.updateOne(filter, productUpdates);
    }

    // Método para incrementar el stock de un producto
    public static void increaseProductStock(String name, int quantity) {
        MongoCollection<Document> collection = MongoConnection.getConnection("Products");
        Bson filter = Filters.eq("name", name);
        Bson update = Updates.inc("stock", quantity);
        collection.updateOne(filter, update);
    }

    // Método para decrementar el stock de un producto
    public static void decreaseProductStock(String name, int quantity) {
        MongoCollection<Document> collection = MongoConnection.getConnection("Products");
        Bson filter = Filters.eq("name", name);
        Bson update = Updates.inc("stock", -quantity);
        collection.updateOne(filter, update);
    }
}
