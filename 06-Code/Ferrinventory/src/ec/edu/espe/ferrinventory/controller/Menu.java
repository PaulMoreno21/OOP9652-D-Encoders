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
        System.out.println("<----FERRINVENTORY---->\n");
        System.out.println("Que Deseas Hacer?");
        System.out.println("1. Agregar Productos Al Almacen #1\n");
        System.out.println("2. Agregar Productos Al Almacen # 2\n");
        System.out.println("3. Guardar e Imprimir Productos\n");
        System.out.println("4. Salir del Programa\n");
        option = readOption.nextInt();
        return option;
    }
}
