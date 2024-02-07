package aula02;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        // Declarations
        double massa,tempInicial,tempFinal,energia;
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("Water in kilograms: ");
        massa = sc.nextDouble();
        System.out.print("initialTemperature: (ºC) ");
        tempInicial = sc.nextDouble();
        System.out.print("finalTemperature: (ºC) ");
        tempFinal = sc.nextDouble();
        sc.close();

        // Q = M * (finalTemperature - initialTemperature) * 4184.
        energia = massa * (tempFinal-tempInicial)*4184;

        // Outputs
        System.out.println("Energy = " + energia + " J");
    }
}
