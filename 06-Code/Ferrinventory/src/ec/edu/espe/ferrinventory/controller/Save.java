
package ec.edu.espe.ferrinventory.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.ferrinventory.model.WareHouse;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class Save {
    public void saveWareHouse1(WareHouse wareHouse){
        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        String gsonWareHouse=gson.toJson(wareHouse);
        System.out.println(gsonWareHouse);
        JSONParser parser= new JSONParser();
        try {
            String routeWH1="data\\WareHouse#1.json";
            String route2="data\\helper.json";
            
            FileWriter writer= new FileWriter(routeWH1,false);
            writer.write(gsonWareHouse);
            writer.close();
            
            Object wh= parser.parse(new FileReader(route2));
            Object wh2= parser.parse(new FileReader(routeWH1));
            
            JSONObject pr=(JSONObject) wh;
            JSONObject pr2=(JSONObject) wh2;
            
            JSONArray array=(JSONArray) pr.get("Contenido");
            
            array.add(wh2);
            String array2=gson.toJson(wh);
            FileWriter writer2 = new FileWriter(route2,false);
            writer2.write(array2);
            writer.close();
            
        } catch (Exception e) {
        } 
    }
    public void fileReader() throws FileNotFoundException, IOException, ParseException{
        String fileRoute="data\\WareHouse#1.json";
        JSONParser parser = new JSONParser();
        
        try {
            Object wh=parser.parse(new FileReader(fileRoute));
            JSONObject pr=(JSONObject) wh;
            JSONArray array=(JSONArray) pr.get("Contenido");
            
            for(int i =0; i<array.size(); i++){
                JSONObject singleProduct =(JSONObject) array.get(i);
                System.out.println(singleProduct);
            }
            System.out.println("PRoductos en la Bodega #1");  
        } catch (JSONException e) {
            System.out.println("Error"+e.getMessage());
        }
        Scanner sc=new Scanner(System.in);
            System.out.println("Presione Enter para continuar");
            sc.nextLine();
    }
    
    public void saveWareHouse2(WareHouse wareHouse){
        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        String gsonWareHouse=gson.toJson(wareHouse);
        System.out.println(gsonWareHouse);
        JSONParser parser= new JSONParser();
        try {
            String routeWH1="data\\WareHouse#2.json";
            String route2="data\\helper.json";
            
            FileWriter writer= new FileWriter(routeWH1,false);
            writer.write(gsonWareHouse);
            writer.close();
            
            Object wh= parser.parse(new FileReader(route2));
            Object wh2= parser.parse(new FileReader(routeWH1));
            
            JSONObject pr=(JSONObject) wh;
            JSONObject pr2=(JSONObject) wh2;
            
            JSONArray array=(JSONArray) pr.get("Contenido");
            
            array.add(wh2);
            String array2=gson.toJson(wh);
            FileWriter writer2 = new FileWriter(route2,false);
            writer2.write(array2);
            writer.close();
            
        } catch (Exception e) {
        } 
    }
    public void fileReader2() throws FileNotFoundException, IOException, ParseException{
        String fileRoute="data\\WareHouse#2.json";
        JSONParser parser = new JSONParser();
        
        try {
            Object wh=parser.parse(new FileReader(fileRoute));
            JSONObject pr=(JSONObject) wh;
            JSONArray array=(JSONArray) pr.get("Contenido");
            
            for(int i =0; i<array.size(); i++){
                JSONObject singleProduct =(JSONObject) array.get(i);
                System.out.println(singleProduct);
            }
            System.out.println("Productos en la Bodega #1");  
        } catch (JSONException e) {
            System.out.println("Error"+e.getMessage());
        }
        Scanner sc=new Scanner(System.in);
            System.out.println("Presione Enter para continuar");
            sc.nextLine();
    }
}
