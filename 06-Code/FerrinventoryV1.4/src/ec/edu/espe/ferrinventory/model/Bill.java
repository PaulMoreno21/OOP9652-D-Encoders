package ec.edu.espe.ferrinventory.model;

public class Bill {
    protected int quantity;
    protected String productName;
    protected double unitPrice;

    public Bill(int quantity, String productName, double unitPrice) {
        this.quantity = quantity;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    public double calculateTotal() {
        return quantity * unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
