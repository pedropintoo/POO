package aula05.ex1;

import utils.UserInput;

import java.util.Scanner;

public class Main {
    final static Scanner sc = new Scanner(System.in);
    static DateYMD date;
    public static void main(String[] args) {

        menu();

    }
    public static void menu(){
        // TODO: Display the 'tester' menu of class 'DateYMD'

        // Declarations
        int optionMenu, inputIncrement, inputDecrement;

        do {
            optionMenu = UserInput.IntegerInput(0,4, """
                
                Date operations:
                1 - create new date
                2 - show current date
                3 - increment date
                4 - decrement date
                0 - exit
                
                Option:\s"""); // \s is for spacing

            if(optionMenu == 1){
                createDate();
            }
            else if(optionMenu == 2){
                if(date == null){
                    System.out.println("Create date firstly!");
                } // in case, date does not exist
                else System.out.println(date);
            }
            else if(optionMenu == 3){
                if(date == null){
                    System.out.println("Create date firstly!");
                } // in case, date does not exist
                else{
                    System.out.print("How many days do you want to increment? ");
                    inputIncrement = sc.nextInt();
                    if( inputIncrement > 0){
                        date.increment(inputIncrement);
                    }
                    else {
                        System.out.println("Increment must be positive");
                    }
                }
            }
            else if(optionMenu == 4){
                if(date == null){
                    System.out.println("Create date firstly!");
                } // in case, date does not exist
                else{
                    System.out.print("How many days do you want to decrement? ");
                    inputDecrement = sc.nextInt();
                    if( inputDecrement > 0){
                        date.decrement(inputDecrement);
                    }
                    else {
                        System.out.println("Decrement must be positive");
                    }
                }
            }
        } while(optionMenu != 0);


    }
    public static void createDate(){
        // Declarations
        String inputUser;
        int inputYear, inputMonth, inputDay;

        // Inputs
        do {
            System.out.print("Create a data \"aaaa-mm-dd\": ");
            inputUser = sc.next();
        } while (!inputUser.matches("^\\d{4}-\\d{2}-\\d{2}$"));

        // Split the input
        inputYear = Integer.parseInt(inputUser.split("-")[0]);
        inputMonth = Integer.parseInt(inputUser.split("-")[1]);
        inputDay = Integer.parseInt(inputUser.split("-")[2]);

        // Change/create the data with constructor
        date = new DateYMD(inputDay,inputMonth,inputYear);
    }
}
