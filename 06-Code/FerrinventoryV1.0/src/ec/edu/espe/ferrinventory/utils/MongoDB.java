/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.ferrinventory.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class MongoDB {
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;
    
    public void connect(String collections){
        String uri = "mongodb+srv://pmoreno:pmoreno@cluster0.to6ri80.mongodb.net/?retryWrites=true&w=majority";
        String db ="Ferrinventory";
        mongoClient = MongoClients.create(uri);
        database = mongoClient.getDatabase(db);
        collection = database.getCollection(collections);
    }
    
    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }
}
