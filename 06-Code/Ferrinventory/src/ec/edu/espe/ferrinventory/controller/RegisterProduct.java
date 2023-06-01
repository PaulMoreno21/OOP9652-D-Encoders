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
        
        System.out.print("Nombre del Producto: ");
        String name = readProduct.nextLine();
        System.out.print("Categoria: ");
        String category = readProduct.nextLine();
        System.out.print("Codigo: ");
        String id = readProduct.nextLine();
        System.out.print("Stock:");
        int stock = readProduct.nextInt();
        while (stock<=-1){
        System.out.println("No se permite stock negativo");
        System.out.print("Stock");
        stock = readProduct.nextInt();
    }
        Product product =new Product(id, name, category, stock);
        return product;
    }
}
