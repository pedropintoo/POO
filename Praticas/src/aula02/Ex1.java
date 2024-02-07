package aula02;
import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        // Declarations
        double distance;
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("Distance in km : ");
        distance = sc.nextDouble();
        sc.close();

        // miles = km / 1.609
        distance = distance/1.609;

        // Outputs
        System.out.println("Distance = " + distance + " miles");

    }
}
