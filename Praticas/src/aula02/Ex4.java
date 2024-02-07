package aula02;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        // Declarations
        double investido,taxa,total;
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("Invested: (euros) ");
        investido = sc.nextDouble();
        System.out.print("Rate: (%) ");
        taxa = sc.nextDouble()/100;
        sc.close();

        // total = total + (total*taxa) !!! For each Month
        total = investido;
        int months = 3;
        for(int i = 1; i <= months; i++) {
            total+= total*taxa;
        }

        // Outputs
        System.out.println("Total = " + total);
    }
}
