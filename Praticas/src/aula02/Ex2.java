package aula02;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        // Declarations
        double tempF, tempC;
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("Temperature: (ºC) ");
        tempC = sc.nextDouble();
        sc.close();

        // tempFº = 1.8*(tempCº) + 32
        tempF = 1.8*tempC + 32;

        // Outputs
        System.out.println("Temperature in Fahrenheits = " + tempF + " ºF");
    }
}
