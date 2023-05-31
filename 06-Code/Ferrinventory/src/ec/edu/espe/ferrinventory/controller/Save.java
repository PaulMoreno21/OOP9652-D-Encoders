
package ec.edu.espe.ferrinventory.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.ferrinventory.model.WareHouse;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class Save {
    public void saveInfo(WareHouse wareHouse1,WareHouse wareHouse2){
       Gson gson=new GsonBuilder().setPrettyPrinting().create();
       String gsonWareHouse1 = gson.toJson(wareHouse1);
       String gsonWareHouse2=gson.toJson(wareHouse2);
       System.out.println(gsonWareHouse1);
       System.out.println(gsonWareHouse2);
       try(PrintWriter printWriter = new PrintWriter(new File("./Data./Products.json"))){
            printWriter.write(gsonWareHouse1);
            printWriter.write(gsonWareHouse2);
        }catch(Exception e){
            e.printStackTrace();
        }
 
    }
}
