package aula02;
import java.lang.Math;

import java.util.Scanner;
import java.lang.Math;
public class Ex7 {
    public static void main(String[] args) {
        // Declarations
        double x1,y1,x2,y2,dis;
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.println("A=(X1,Y1)");
        System.out.print("X1: ");
        x1 = sc.nextDouble();
        System.out.print("Y1: ");
        y1 = sc.nextDouble();
        System.out.println("B=(X2,Y2)");
        System.out.print("X2: ");
        x2 = sc.nextDouble();
        System.out.print("Y2: ");
        y2 = sc.nextDouble();
        sc.close();

        // Distance = sqrt((x1-x2)^2 + (y1-y2)^2)
        dis = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));

        // Outputs
        System.out.println("Distance = " + dis);
    }
}
