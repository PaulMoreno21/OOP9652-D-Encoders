
package ec.edu.espe.ferrinventory.model;

import ec.edu.espe.ferrinventory.controller.Menu;
import ec.edu.espe.ferrinventory.controller.RegisterProduct;
import ec.edu.espe.ferrinventory.controller.Save;
import java.util.ArrayList;

/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class MenuProduct {
   public static void ProductMenu() {
        Product product;
        ArrayList<Product> products1=new ArrayList<>();
        ArrayList<Product> products2=new ArrayList<>();
        WareHouse wareHouse1 = new WareHouse(1, products1);
        WareHouse wareHouse2 = new WareHouse(2, products2);
        Menu printmenu=new Menu();
        RegisterProduct registerProduct= new RegisterProduct();
        Save saveInfo=new Save();
       
        boolean exit = true;
        
        while (exit==true){
            int option =printmenu.printProductMenu();
            switch(option){
                case 1:
                    System.out.println("-----Bodega#1 -----");
                    product=registerProduct.Product();
                    products1.add(product);
                    saveInfo.saveWareHouse1(wareHouse1);
                    break;
                case 2 :
                    System.out.println("-----Bodega#2 -----");
                    product=registerProduct.Product();
                    products2.add(product);
                    saveInfo.saveWareHouse2(wareHouse2);
                    break;
                case 3 :
                 //   saveInfo.saveInfo(wareHouse1, wareHouse2);
                    exit = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            } 
        } 
    } 
}
