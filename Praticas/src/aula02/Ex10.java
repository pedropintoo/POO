package aula02;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        // Declarations
        double primeiro, max, min, media, numero;
        double soma = 0;
        int lidos = 1;
        Scanner sc = new Scanner(System.in);

        // Input 1
        System.out.print("Number: ");
        primeiro = sc.nextDouble();

        max = primeiro;
        min = primeiro;
        soma = primeiro;

        // Inputs Loop
        do{
            System.out.print("Number: ");
            numero = sc.nextDouble();

            lidos++;
            soma += numero;
            if (numero > max)
                max = numero;
            else if (numero < min)
                min = numero;
        } while(numero != primeiro);
        sc.close();

        // media = soma dos números lidos/número de numeros lidos
        media = soma/lidos;

        // Outputs
        System.out.println();
        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
        System.out.println("Numbers read = " + lidos);
        System.out.println("Mean = " + media);

    }
}
