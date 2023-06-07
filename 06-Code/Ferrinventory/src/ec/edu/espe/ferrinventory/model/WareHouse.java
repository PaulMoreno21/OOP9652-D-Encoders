
package ec.edu.espe.ferrinventory.model;

import java.util.ArrayList;

/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class WareHouse {
    private int Id;
    private ArrayList<Product> products;

    @Override
    public String toString() {
        return "Bodega" + "#" + Id + "\nContenido=" + products + '\n';
    }

    
    
    public WareHouse(int Id, ArrayList<Product> products) {
        this.Id = Id;
        this.products = products;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
}
