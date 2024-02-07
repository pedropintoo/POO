package aula03;

import utils.UserInput;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        // Declarations
        Scanner sc = new Scanner(System.in);
        double moneyInvested, rate;

        // Inputs
        do{
            System.out.print("Money Invested (positive and multiple of 1000): ");
            moneyInvested = sc.nextDouble();
        } while(moneyInvested<=0 || moneyInvested%1000 != 0);

        rate = UserInput.DoubleInput(0,5,"Monthly interest rate [0%,5%]: ");

        // Calculations for each month
        for(int i = 1; i <= 12; i++) {
            moneyInvested = moneyInvested * (1+(rate/100));
            System.out.println(i+" month: "+moneyInvested+"€");
        }

        sc.close();
    }
}
