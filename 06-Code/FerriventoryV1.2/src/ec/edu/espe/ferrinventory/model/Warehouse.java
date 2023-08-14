package ec.edu.espe.ferrinventory.model;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Product> stock;

    public Warehouse() {
        stock = new ArrayList<>();
    }

    public List<Product> getAllProducts() {
        return stock;
    }

    public void updateStock(Product product, int newQuantity) {
        for (Product p : stock) {
            if (p.getId().equals(product.getId())) {
                p.setQuantity(newQuantity);
                break;
            }
        }
    }

    public void addProduct(Product product) {
        stock.add(product);
    }

    public void deleteProduct(Product product) {
        stock.remove(product);
    }

    public Product searchProductByName(String name) {
        for (Product product : stock) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public void generateWarehouseReport() {
        System.out.println("Warehouse Report:");
        for (Product product : stock) {
            System.out.println(product);
        }
    }
}
