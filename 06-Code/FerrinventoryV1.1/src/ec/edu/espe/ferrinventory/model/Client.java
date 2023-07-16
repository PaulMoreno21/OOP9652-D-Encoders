package ec.edu.espe.ferrinventory.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private List<Transaction> transactions;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
        transactions = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void clientPurchase(FrontDeskHelper frontDeskHelper, String productName, int quantity) {
        Product product = frontDeskHelper.searchProductByName(productName);
        if (product != null && product.getStock() >= quantity) {
            double totalPrice = product.getPrice() * quantity;

            // Mostrar detalles del producto
            System.out.println("Product details:");
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Brand: " + product.getBrand());

            // Aceptar la compra y realizar el pago (lógica adicional)

            // Actualizar inventario
            frontDeskHelper.updateStock(product, quantity);

            // Actualizar informe de ventas
            transactions.add(new Transaction(id, quantity, productName));

            // Registrar las ganancias de la venta en el informe de ventas
            double revenue = totalPrice;
            frontDeskHelper.addSalesRevenue(revenue);
        } else {
            System.out.println("Product is out of stock or not found.");
        }
    }
}
