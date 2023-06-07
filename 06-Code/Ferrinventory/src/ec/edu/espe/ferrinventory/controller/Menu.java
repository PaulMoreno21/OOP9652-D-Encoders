package ec.edu.espe.ferrinventory.controller;

import java.util.Scanner;

/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class Menu {

    int option;
    public  int printProductMenu(){
        Scanner readOption = new Scanner(System.in);
        System.out.println("<----BIENVENIDO A FERRINVENTORY---->");
        System.out.println("Escoja la Bodega:");
        System.out.println("1. Bodega #1\n");
        System.out.println("2. Bodega #2\n");
        System.out.println("3. Salir\n");
        option = readOption.nextInt();
        return option;
    }
    public  int printMenu(){
        Scanner readOption = new Scanner(System.in);
        System.out.println("<----BIENVENIDO A FERRINVENTORY---->");
        System.out.println("Que deseas hacer ?");
        System.out.println("1. Agregar productos\n");
        System.out.println("2. Imprimir reporte de inventario\n");
        System.out.println("3. Salir\n");
        option = readOption.nextInt();
        return option;
    }
        
    
}

