package aula03;

import java.util.Random;
import java.util.Scanner;
import utils.UserInput;

public class Ex4 {
    final private static int P = 0;
    final private static int T = 1;
    public static void main(String[] args) {
        // Declarations
        int totalStudents;
        Scanner sc = new Scanner(System.in);

        // Number of students and create an Array to contain the grades
        do {
            System.out.print("Number of students: ");
            totalStudents = sc.nextInt();
        } while(totalStudents <= 0);


        double[][] grades = new double[totalStudents][2];

        // Generate grades
        genGrades(grades);

        // Outputs
        getGrades(grades);


    }
    private static int calcFinalGrade(double notaT, double notaP){
        if(notaT<7 || notaP<7){
            return 66; // Minimum grade
        }
        else{
            return (int) Math.round(0.4*notaT + 0.6*notaP);
        }
    }

    private static void genGrades(double[][] grades){
        // Declarations
        Random random = new Random();

        // Random values for students
        for(int i = 0; i < grades.length; i++){
            // Practical
            grades[i][P] = random.nextDouble(20);
            grades[i][P] = UserInput.roundPrecision(grades[i][P],1);

            // Theoretical
            grades[i][T] = random.nextDouble(20);
            grades[i][T] = UserInput.roundPrecision(grades[i][T],1);
        }
    }

    private static void getGrades(double[][] grades){
        // Declarations
        double tempNotaT, tempNotaP;
        int tempNotaFinal;

        // Outputs
        System.out.println("NotaT  NotaP  Pauta");
        for(int i = 0; i < grades.length; i++){
            tempNotaT = grades[i][T];
            tempNotaP = grades[i][P];

            // Calculate final grade
            tempNotaFinal = calcFinalGrade(tempNotaT, tempNotaP);

            System.out.printf("%5.1f  %5.1f  %5d",tempNotaT, tempNotaP, tempNotaFinal);

            System.out.println();
        }
    }
}
