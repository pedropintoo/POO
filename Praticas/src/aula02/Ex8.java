package aula02;

import java.lang.Math;
import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        // Declarations
        double catetoA,catetoB,hip,ang;
        Scanner sc = new Scanner(System.in);

        // Inputs
        do{
            System.out.print("Cathetus A: ");
            catetoA = sc.nextDouble();
        }while (catetoA <= 0);
        do{
            System.out.print("Cathetus B: ");
            catetoB = sc.nextDouble();
        }while (catetoB <= 0);
        sc.close();

        // hip = sqrt(cA^2 + cA^2)
        hip = Math.sqrt(catetoA*catetoA + catetoB*catetoB);
        // ang = asin(cA/hip) em radians
        ang = Math.toDegrees(Math.asin(catetoB/hip));

        // Outputs
        System.out.println("Hypotenuse = " + hip);
        System.out.println("Angle (A e hip) = " + ang + " degrees");
    }
}
