package ec.edu.espe.ferrinventory.controller;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class LogInController {

    private CollectionStrategy collectionFromStrategy;

    public boolean matchInMongo(int id, String password) {

        collectionFromStrategy = setCollection(id);
        return collectionFromStrategy.obtainUser(id, password);

    }

    public CollectionStrategy setCollection(int id) {

        if (id < 100000 && id > 99000) {
            collectionFromStrategy = new CollectionPrincipal();
        }
        if (id < 99000 && id > 50000) {
            collectionFromStrategy = new CollectionTeacher();
        }
        if (id < 50000 && id > 10000) {
            collectionFromStrategy = new CollectionStudent();
        }

        return collectionFromStrategy;
    }
}
