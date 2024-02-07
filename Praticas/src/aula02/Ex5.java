package aula02;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        // Declarations
        double v1,d1,v2,d2,dT,tT,vM;
        Scanner sc = new Scanner(System.in);

        // Inputs
        do{
            System.out.print("Velocity 1: ");
            v1 = sc.nextDouble();
        }while (v1 <= 0);
        do{
            System.out.print("Distance 1: ");
            d1 = sc.nextDouble();
        }while (d1 <= 0);
        do{
            System.out.print("Velocity 2: ");
            v2 = sc.nextDouble();
        }while (v2 <= 0);
        do{
            System.out.print("Distance 2: ");
            d2 = sc.nextDouble();
        }while (d2 <= 0);
        sc.close();

        // vM = dT/tT e t = d/v
        dT = d1 + d2;
        tT = (d1/v1) + (d2/v2);
        vM = dT/tT;

        // Outputs
        System.out.println("Velociadade média final = " + vM);
        
        
        
    }
}
