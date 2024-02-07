package aula13.av2;

import java.util.Scanner;

public class MenuExemplo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
        sc.close();
    }
    public static void menu(Scanner sc){
        // TODO: Display the 'tester' menu of class 'Contacts'
        // Declarations
        int optionMenu;

        do {
            optionMenu = IntegerInput(0,11, """
                
                Contacts operations:
                1 - insert contact
                2 - change contact
                3 - delete contact
                4 - search contact by name
                5 - search contact by phone number
                6 - search contact by email
                7 - list contacts
                8 - list contacts by name
                9 - list contacts by phone number
                10 - list contacts by email
                11 - list contacts by date of bith
                0 - exit
                
                Option:\s""", sc); // \s is for spacing

            if(optionMenu == 1){

            }
            else if(optionMenu == 2){

            }
            else if(optionMenu == 3){

            }
            else if(optionMenu == 4){

            }
            else if(optionMenu == 5){

            }
            else if(optionMenu == 6){

            }
            else if(optionMenu == 7){

            }
            else if(optionMenu == 8){

            }
            else if(optionMenu == 9){

            }
            else if(optionMenu == 10){

            }else if(optionMenu == 11){

            }
        } while(optionMenu != 0);

    }
    public static int IntegerInput(int min, int max, String print, Scanner sc) {

        // Inputs
        System.out.print(print);
        double number = sc.nextDouble();
        sc.nextLine();

        // Validation
        while (number != (int) number || number < min || number > max) {
            System.out.println("Invalid value!");
            System.out.print(print);
            number = sc.nextDouble();
        }

        //sc.close(); // is not included for loops

        // Return Integer
        return (int) number;
    }
}