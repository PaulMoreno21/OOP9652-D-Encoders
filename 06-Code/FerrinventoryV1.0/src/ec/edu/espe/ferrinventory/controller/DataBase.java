/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.ferrinventory.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import ec.edu.espe.ferrinventory.utils.MongoDB;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class DataBase {
    public  void singUp(String user,String password){
        MongoDB db= new MongoDB();
        db.connect("User");
        MongoCollection<org.bson.Document> collection = db.getCollection();  
            String encrypt = "";
            int add = 1;

            for (int i = 0; i < password.length(); i++) {

                int Rename = password.codePointAt(i);

                char letterAdd = (char) (Rename + add);

                encrypt = encrypt + letterAdd;
            }

            Document doc1 = new Document("User", user).append("Pasword", encrypt);

            collection.insertOne(doc1);
     }
    
    public void createDocument(String id,String name,String category,String brand,float Cost,float Price, int Stock){
        MongoDB db= new MongoDB();
        db.connect("Product");
        MongoCollection<org.bson.Document> collection = db.getCollection();  
        Document doc1 = new Document("id", id).append("Name", name).append
        ("Category", category).append("brand", brand).append("Cost",Cost).append("Price",Price).append("Stock",Stock);

        collection.insertOne(doc1);
    }
    
    public static void deleteDocument(String del){
        MongoDB db= new MongoDB();
        db.connect("Product");
        MongoCollection<org.bson.Document> collection = db.getCollection(); 
        Bson filter = Filters.eq("id",del);
        collection.deleteOne(filter);
    }
    
    public static void readDocument(String search){
            MongoDB db= new MongoDB();
            db.connect("Product");
            MongoCollection<org.bson.Document> collection = db.getCollection();
            MongoCursor<Document> cursor = collection.find(eq("id",search)).cursor();

            try {
                while (cursor.hasNext()){
                    System.out.println(cursor.next().toJson());
                }
            } finally {
                cursor.close();
            }
        
    }
    
    public static void modifyDocument(String search,String name,String category,String brand,float Cost,float Price, int Stock){
        MongoDB db= new MongoDB();
        db.connect("Product");
        MongoCollection<org.bson.Document> collection = db.getCollection();
            Document docmod =collection.find(eq("id", search)).first();

        Document doc1 = new Document("Name", name).append
        ("Category", category).append("brand", brand).append("Cost",Cost).append("Price",Price).append("Stock",Stock);
         collection.replaceOne(docmod, doc1);
           
        }
        
    }


