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
        System.out.print("Id: ");
        int id = readProduct.nextInt();
        System.out.print("Name:\n");
        String name = readProduct.next();
        System.out.print("Category: ");
        String category = readProduct.next();
        System.out.print("Stock:");
        int stock = readProduct.nextInt();
        Product product =new Product(id, name, category, stock);
        return product;
    }
}
