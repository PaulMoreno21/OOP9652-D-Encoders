
package ec.edu.espe.ferrinventory.model;

/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class Product {
    private int id;
    private String name;
    private String Category;
    private int stock;

    public Product(int id, String name, String Category, int stock) {
        this.id = id;
        this.name = name;
        this.Category = Category;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product\n" + "id=" + id + "\n name=" + name + 
                "\n Category=" + Category + "\n stock=" + stock + '\n';
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
     * @return the Category
     */
    public String getCategory() {
        return Category;
    }

    /**
     * @param Category the Category to set
     */
    public void setCategory(String Category) {
        this.Category = Category;
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
