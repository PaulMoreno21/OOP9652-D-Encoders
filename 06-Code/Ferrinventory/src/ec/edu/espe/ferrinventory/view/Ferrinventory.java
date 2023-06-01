
package ec.edu.espe.ferrinventory.view;

import ec.edu.espe.ferrinventory.controller.Menu;
import ec.edu.espe.ferrinventory.controller.RegisterProduct;
import ec.edu.espe.ferrinventory.controller.Save;
import ec.edu.espe.ferrinventory.model.Product;
import ec.edu.espe.ferrinventory.model.WareHouse;
import java.util.ArrayList;

/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class Ferrinventory {
    public static void main(String[] args) {
        Product product;
        ArrayList<Product> products1=new ArrayList<>();
        ArrayList<Product> products2=new ArrayList<>();
        Menu printmenu=new Menu();
        RegisterProduct registerProduct= new RegisterProduct();
        Save saveInfo=new Save();
        
        boolean exit = true;
        
        while (exit==true){
            int option =printmenu.printMenu();
            switch(option){
                case 1:
                    System.out.println("-----Bodega #1 -----");
                    product=registerProduct.Product();
                    products1.add(product);
                    break;
                case 2 :
                    System.out.println("-----Bodega #2 -----");
                    product=registerProduct.Product();
                    products2.add(product);
                    break;
                case 3 :
                    WareHouse wareHouse1 = new WareHouse(1, products1);
                    WareHouse wareHouse2 = new WareHouse(2, products2);
                    saveInfo.saveInfo(wareHouse1, wareHouse2);
                    break;
                default:
                    exit = false;
                    break;
            }
            
            
        }
        
        
    }
}
