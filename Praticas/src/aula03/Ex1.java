package aula03;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        // Declarations
        int number;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        // Inputs
        do{
            System.out.print("Positive Integer number: ");
            number = sc.nextInt();
        }while (number<=0);

        // Sum of prime numbers
        for(int i = number; i > 0; i--){
            if(isPrime(i)) sum+=i;
        }

        // Output
        System.out.println("Sum of prime numbers: "+sum);
        sc.close();
    }

    private static boolean isPrime(int number){
        int tSum = 0;
        if(number == 1) return false; // 1 is not prime

        // checking if number have another divisors between ]1,n[
        for(int i = 2; i <= number-1; i++){
            if(number % i == 0) tSum++;
            if(tSum > 0) return false;
        }
        return true;
    }
}
