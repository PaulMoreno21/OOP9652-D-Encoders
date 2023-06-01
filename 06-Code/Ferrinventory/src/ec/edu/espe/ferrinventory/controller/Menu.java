package ec.edu.espe.ferrinventory.controller;

import java.util.Scanner;

/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class Menu {

    int option;
    public  int printMenu(){
        Scanner readOption = new Scanner(System.in);
        System.out.println("<----WELCOME TO FERRINVENTORY---->");
        System.out.println("What do you want to do ?");
        System.out.println("1. Add Products in the WareHouse 1\n");
        System.out.println("2. Add Products in the Warehouse 2\n");
        System.out.println("3. Save\n");
        System.out.println("4. Exit\n");
        option = readOption.nextInt();
        return option;
    }
}
