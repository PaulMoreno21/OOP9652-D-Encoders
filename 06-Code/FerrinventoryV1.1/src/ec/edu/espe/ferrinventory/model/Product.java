
package ec.edu.espe.ferrinventory.model;
/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String id;
    private String name;
    private String category;
    private String brand;
    private float cost;
    private float price;
    private int stock;
    private int quantity;

    public Product(String id, String name, String category, String brand, float cost, int stock, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.cost = cost;
        this.stock = stock;
        this.quantity = quantity;
        this.price = calculatePrice();
    }

    private float calculatePrice() {
        BigDecimal costFinal = BigDecimal.valueOf(cost / 1.12);
        BigDecimal priceOnSale = costFinal.divide(BigDecimal.valueOf(0.75), 2, RoundingMode.HALF_UP);
        BigDecimal priceIva = priceOnSale.multiply(BigDecimal.valueOf(1.12));
        return priceIva.floatValue();
    }

    @Override
    public String toString() {
        return "\n\t------------" + "\n\tNombre=" + name + "\n\tCodigo=" + id + "\n\tCategoria=" + category
                + "\n\tMarca=" + brand +
                "\n\tCosto=" + cost + "\n\tPVP=" + price + "\n\tstock=" + stock + '\n';
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
}
