package aula05.ex2;

import aula05.ex1.DateYMD;
import utils.UserInput;

import java.util.Scanner;

public class Main {
    final static Scanner sc = new Scanner(System.in);
    static Calendar calendar;
    public static void main(String[] args) {

        menu();

    }
    public static void menu(){
        // TODO: Display the 'tester' menu of class 'Calendar'

        int optionMenu, optionMonth;

        do {
            optionMenu = UserInput.IntegerInput(0,3, """
                                    
                    Calendar operations:
                    1 - create new calendar
                    2 - print calendar month
                    3 - print calendar
                    0 – exit
                                    
                    Option:\s"""); // \s is for spacing

            if(optionMenu == 1){
                createCalendar();
            }
            else if(optionMenu == 2){
                if(calendar == null){
                    System.out.println("Create date firstly!");
                } // in case, date does not exist
                else {
                    optionMonth = UserInput.IntegerInput(1,12,"What month do you wanna print: ");
                    System.out.println(calendar.printMonth(optionMonth));
                }
            }
            else if(optionMenu == 3){
                if(calendar == null){
                    System.out.println("Create date firstly!");
                } // in case, date does not exist
                else System.out.println(calendar);
            }
        } while(optionMenu != 0);


    }
    public static void createCalendar(){
        // TODO: Create calendar with/without events

        // Declarations
        int year, firstWeekdayOfYear, addRemoveInput, addRemoveSelectionInput, inputMonth, inputDay;
        String inputUser;
        DateYMD date;

        // Inputs
        do{
            System.out.print("Year of the calendar: ");
            year = sc.nextInt();
        }while (year<=0);

        do {
            System.out.print("First weekday of Year (between 1-Sunday e 7-Saturday): ");
            firstWeekdayOfYear = sc.nextInt();
        }while (firstWeekdayOfYear<1 || firstWeekdayOfYear>7);

        // Create calendar with inputs
        calendar = new Calendar(year, firstWeekdayOfYear);

        // Add/Remove events with input (dd-mm)
        addRemoveInput = UserInput.IntegerInput(0,1,"Do you wanna add/remove events (0 - No / 1 - Yes): ");
        if(addRemoveInput == 1){
            do{
                addRemoveSelectionInput = UserInput.IntegerInput(0,2,"0 - Add / 1 - Remove / 2 - STOP: ");
                if(addRemoveSelectionInput != 2){
                    do {
                        System.out.print("Event \"dd-mm\": ");
                        inputUser = sc.next();
                    } while (!inputUser.matches("^\\d{2}-\\d{2}$"));

                    // Split the input
                    inputDay = Integer.parseInt(inputUser.split("-")[0]);
                    inputMonth = Integer.parseInt(inputUser.split("-")[1]);


                    // create the event with constructor and add/remove event with calendar's method
                    date = new DateYMD(inputDay,inputMonth,calendar.getYear());

                    // If date is invalid date = 00-00-0000
                    if(date.getDay() != 0){
                        if(addRemoveSelectionInput == 0) calendar.addEvent(date);
                        else calendar.removeEvent(date);
                    }

                }
            } while(addRemoveSelectionInput != 2);

        }


    }
}
