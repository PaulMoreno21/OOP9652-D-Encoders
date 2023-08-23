package ec.edu.espe.ferrinventory.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import ec.edu.espe.ferrinventory.model.Product;
import ec.edu.espe.ferrinventory.utils.MongoConnection;
import ec.edu.espe.ferrinventory.view.FrmProduct;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController extends CrudController<Product> implements ActionListener {

    private final FrmProduct view;
    private int lastProductId; // Mantener el último id utilizado

    public ProductController(FrmProduct view) {
        super(MongoConnection.getConnection("Products"));
        this.view = view;
        this.view.btnAdd.addActionListener(this::addProduct);
        initializeLastProductId(); // Obtener el último id utilizado al iniciar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnAdd) {
            addProduct(e);
        }
    }

    public void addProduct(ActionEvent e) {
        String name = view.txtName.getText();
        String category = view.cmbCategory.getSelectedItem().toString();
        String brand = view.cmbBrand.getSelectedItem().toString();
        String costText = view.txtCost.getText();

        if (costText.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Ingrese un costo válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float cost;
        try {
            cost = Float.parseFloat(costText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Ingrese un costo numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(view.txtQuantity.getText());
            if (quantity < 1) {
                JOptionPane.showMessageDialog(view, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Loop para agregar la cantidad especificada de productos
        for (int i = 0; i < quantity; i++) {
            lastProductId++; // Incrementar el último id utilizado
            Product newProduct = new Product(name, category, brand, cost, i + 1); // No necesitamos el índice en el constructor
            newProduct.setId(lastProductId); // Asignar el nuevo id incremental
            addToProductsCollection(newProduct);
        }

        JOptionPane.showMessageDialog(view, "Producto(s) agregado(s) correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void initializeLastProductId() {
        MongoCollection<Document> collection = MongoConnection.getConnection("Products");
        MongoCursor<Document> cursor = collection.find().sort(new Document("_id", -1)).limit(1).iterator();
        if (cursor.hasNext()) {
            Document lastDocument = cursor.next();
            lastProductId = lastDocument.getInteger("product_id", 0);
        }
    }

    private void addToProductsCollection(Product product) {
        Document productDoc = createDocument(product);
        create(product, productDoc); // Llama al método create heredado de CrudController
    }

    private Document createDocument(Product product) {
        return new Document("_id", new ObjectId()) // Generar un nuevo _id en MongoDB
                .append("product_id", product.getId()) // Usar el id de Product como product_id en MongoDB
                .append("name", product.getName())
                .append("category", product.getCategory())
                .append("brand", product.getBrand())
                .append("cost", product.getCost())
                .append("price", product.getPrice())
                .append("stock", product.getStock());
    }
}
