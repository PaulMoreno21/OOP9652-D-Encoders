
package ec.edu.espe.ferrinventory.view;

import ec.edu.espe.ferrinventory.controller.Menu;
import ec.edu.espe.ferrinventory.controller.Save;
import ec.edu.espe.ferrinventory.model.MenuProduct;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class Ferrinventory {
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        Menu printMenu= new Menu();
        Save printInfo=new Save();
        boolean exit= true;
        while (exit==true){
            int option =printMenu.printMenu();
            switch(option){
                case 1:
                    MenuProduct.ProductMenu();
                    break;
                case 2 :
                    //TODO
                    printInfo.fileReader();
                    printInfo.fileReader2();
                    break;
                default:
                    exit=false;
                    break;
            } 
        } 
    }
}
