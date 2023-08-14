package ec.edu.espe.ferrinventory.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private static int nextId = 1;
    private final int id;
    private String name;
    private String category;
    private String brand;
    private float cost;
    private float price;
    private int stock;

    public Product(String name, String category, String brand, float cost, int stock) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.cost = cost;
        this.price = calculatePrice();
        this.stock = stock;
    }

    private float calculatePrice() {
        BigDecimal costFinal = BigDecimal.valueOf(cost / 1.12);
        BigDecimal priceOnSale = costFinal.divide(BigDecimal.valueOf(0.75), 2, RoundingMode.HALF_UP);
        BigDecimal priceIva = priceOnSale.multiply(BigDecimal.valueOf(1.12));
        return priceIva.floatValue();
    }
 
    public int getId() {
        return id;
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
        this.price = calculatePrice();
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void increaseStock(int quantity) {
        this.stock += quantity;
    }

    public void decreaseStock(int quantity) {
        if (stock >= quantity) {
            this.stock -= quantity;
        } else {
            throw new IllegalArgumentException("Insufficient stock.");
        }
    }

    @Override
    public String toString() {
        return "\n\t------------" + "\n\tID=" + id + "\n\tNombre=" + name + "\n\tCategoria=" + category
                + "\n\tMarca=" + brand + "\n\tCosto=" + cost + "\n\tPVP=" + price + "\n\tstock=" + stock + '\n';
    }
}
