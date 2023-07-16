package ec.edu.espe.ferrinventory.model;

public class Transaction {
    private int id ;
    private int quantity;
    private String productName;

    public Transaction(int id, int quantity, String productName) {
        this.id = id;
        this.quantity = quantity;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", quantity=" + quantity + ", productName=" + productName + '}';
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }    
}
