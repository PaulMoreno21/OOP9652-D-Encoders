package ec.edu.espe.ferrinventory.controller;

import com.mongodb.client.MongoCollection;
import java.util.function.Function;
import javax.swing.JTextField;
import org.bson.Document;

public abstract class Ferrinventory<T> {
    protected final MongoCollection<Document> collection;

    public Ferrinventory(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public abstract void create(T item, Document document);

    public abstract void update(Document filter, Document update);

    public abstract void delete(Document filter);

    public abstract T find(Document query, Function<Document, T> mapper);

    public void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
}