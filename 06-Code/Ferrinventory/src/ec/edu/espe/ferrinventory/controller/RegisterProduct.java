package ec.edu.espe.ferrinventory.controller;

import ec.edu.espe.ferrinventory.model.Product;
import java.util.Scanner;


/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class RegisterProduct {
    public Product Product(){
        Scanner readProduct = new Scanner(System.in);

        System.out.print("Nombre:");
        String name = readProduct.nextLine();
        System.out.print("Id: ");
        String id = readProduct.nextLine();
        System.out.print("Categoria: ");
        String category = readProduct.nextLine();
        System.out.print("Sub Categoria: ");
        String subCategory=readProduct.nextLine();
        System.out.print("Marca: ");
        String brand=readProduct.nextLine();
        System.out.print("Stock:");
        int stock = readProduct.nextInt();
        while (stock<=-1){
            System.out.println("No se permite stock negativo");     
            System.out.print("Stock:");
            stock = readProduct.nextInt();             
        }
        System.out.print("Costo de compra(usar coma):");
        float cost = readProduct.nextFloat();
        while(cost<=-1){
            System.out.println("El costo no puede ser negativo");
            System.out.print("Costo de compra:");
            cost = readProduct.nextFloat();
        }
        Product product=new Product(id, name, category, subCategory, brand, cost, stock);
        return product;
    }
    
}
