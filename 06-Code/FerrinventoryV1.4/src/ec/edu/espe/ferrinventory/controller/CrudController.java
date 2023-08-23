package ec.edu.espe.ferrinventory.controller;

import com.mongodb.client.MongoCollection;
import java.util.function.Function;
import org.bson.Document;

public abstract class CrudController<T> extends Ferrinventory<T> {

    public CrudController(MongoCollection<Document> collection) {
        super(collection);
    }

    @Override
    public void create(T item, Document document) {
        collection.insertOne(document);
    }

    @Override
    public void update(Document filter, Document update) {
        collection.updateOne(filter, update);
    }

    @Override
    public void delete(Document filter) {
        collection.deleteOne(filter);
    }

    @Override
    public T find(Document query, Function<Document, T> mapper) {
        Document foundDocument = collection.find(query).first();

        if (foundDocument == null) {
            return null;
        }
        return mapper.apply(foundDocument);
    }

}
