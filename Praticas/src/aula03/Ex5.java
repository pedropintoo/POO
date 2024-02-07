package aula03;

import utils.UserInput;

import java.util.Scanner;

public class Ex5 {

    public static void main(String[] args) {
        // Declarations
        int[] date;
        date = getDate(); // {month,year,dayWeek}

        // Show method with calculations integrated
        showMonth(date);

    }

    private static int[] getDate(){
        // Declarations
        Scanner sc = new Scanner(System.in);
        String monthYear;
        String[] arrayMonthYear;
        int month,year,dayWeek;

        // Inputs + Validation
        do {
            System.out.print("Date [mm/yyyy]: ");
            monthYear = sc.next();
        } while(!monthYear.matches("^(0[1-9]|1[0-2])/[0-9]{4}$"));

        // Split for return integers
        arrayMonthYear = monthYear.split("/");
        month = Integer.parseInt(arrayMonthYear[0]);
        year = Integer.parseInt(arrayMonthYear[1]);

        // Inputs + Validation
        dayWeek = UserInput.IntegerInput(1,7,
                "Day of the week the month starts: \n" +
                " [1] - Monday  \n [2] - Tuesday \n [3] - Wednesday \n" +
                " [4] - Thursday \n [5] - Friday \n [6] - Saturday \n [7] - Sunday \n" +
                "\n Option: ");


        return new int[]{month, year, dayWeek};
    }

    private static int calcDaysMonth(int month, int year){
        switch (month){
            case 2:
                return (year%4 == 0 && !(year%100 == 0 && year%400 != 0)) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static void showMonth(int[] date) {
        // Declarations
        String[] allMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int month = date[0];
        int year = date[1];
        int dayWeek = date[2];
        int totalDays = calcDaysMonth(month,year);

        System.out.println(); // for prettying

        // Header
        System.out.printf("   %s\n",allMonths[month-1]+" "+year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        if(dayWeek == 7) {
            dayWeek = 0; // for helping in counter, because 7 - (Sunday) is the first
        }
        else{
            for(int i = 0; i < dayWeek; i++){
                System.out.print("   "); // spaces behind the first day of the month
            }
        }

        // Days
        for(int i = 1; i <= totalDays ;i++){
            if(dayWeek % 7 == 0 && dayWeek != 0){
                System.out.println(); // new line each weak
                dayWeek=0;
            }
            System.out.printf("%2d ",i);

            dayWeek++;
        }



    }
}
