
package ec.edu.espe.ferrinventory.model;


/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class Product {
    private String id;
    private String name;
    private String category;
    private String brand;
    private float cost;
    private float price;
    private int stock;

    public Product(String id, String name, String category,String brand, float cost, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.cost = cost;
        this.stock = stock;
        this.price=calculatePrice();
    }
    private float calculatePrice() {
        float costFinal=(float) (cost/1.12);
        float priceOnSale=(float) (costFinal/0.75);
        float priceIva = (float) (priceOnSale*1.12);
        return priceIva;
        }

    @Override
    public String toString() {
        return "\n\t------------" + "\n\tNombre=" + name+ "\n\tCodigo=" + id  + "\n\tCategoria=" + category 
                + "\n\tMarca=" + brand + 
                "\n\tCosto=" + cost + "\n\tPVP=" + price+ "\n\tstock=" + stock + '\n';
    }
    
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }



    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the cost
     */
    public float getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }


    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    


}
