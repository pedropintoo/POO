package aula13.av2;


import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO: Menu with 11 different options
        //         Contacts operations:
        //                1 - insert contact
        //                2 - change contact
        //                3 - delete contact
        //                4 - search contact by name
        //                5 - search contact by phone number
        //                6 - search contact by email
        //                7 - list contacts
        //                8 - list contacts by name
        //                9 - list contacts by phone number
        //                10 - list contacts by email
        //                11 - list contacts by date of bith
        //                0 - exit
        Scanner sc = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();
        contactManager.load("src/aula13/av2/contactos.txt");
        menu(contactManager, sc);
        contactManager.save("src/aula13/av2/contactosSave.txt");
        sc.close();
    }
    public static void menu(ContactManager contactManager, Scanner sc){
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
                System.out.println();
                System.out.println("Add contact: ");
                System.out.print("name = ");
                String name = sc.nextLine();
                System.out.print("phone number = ");
                int phonenumber = sc.nextInt();
                sc.nextLine();
                System.out.print("email = ");
                String email = sc.nextLine();
                System.out.print("date (yyyy-mm-dd) = ");
                String dateInfo = sc.nextLine();

                LocalDate date = LocalDate.of(Integer.parseInt(dateInfo.split("-")[0]),
                        Integer.parseInt(dateInfo.split("-")[1]),
                        Integer.parseInt(dateInfo.split("-")[2]));

                Contact contact = null;
                if(contactManager.validatePhoneNumber(String.valueOf(phonenumber)) && contactManager.validateEmail(email)){

                    contact = new Contact(name, phonenumber, email, date);
                }
                if(contactManager.addContact(contact)){
                    System.out.println("Added successfully!");
                }
                else System.out.println("Error!");


            }
            else if(optionMenu == 2){
                System.out.println();
                System.out.print("Change by ID = ");
                int id = sc.nextInt();
                sc.nextLine();
                Contact c = contactManager.searchContactById(id);
                if(c != null){
                    int option;

                    option = IntegerInput(0, 4, """
                                                
                            Change contact:
                            1 - by name
                            2 - by email
                            3 - by phonenumber
                            4 - by date of birth
                            0 - exit
                                                        
                            Option:\s""", sc);
                    if (option == 1) {
                        System.out.println();
                        System.out.print("New name = ");
                        String nome = sc.nextLine();
                        c.setName(nome);
                        System.out.println("Changed successfully!");
                    } else if (option == 2) {
                        System.out.println();
                        System.out.print("New email = ");
                        String email = sc.nextLine();
                        if(contactManager.validateEmail(email)) {
                            c.setEmail(email);
                            System.out.println("Changed successfully!");
                        }
                        else System.out.println("Error!");
                    } else if (option == 3) {
                        System.out.println();
                        System.out.print("New phone number = ");
                        int phonenumber = sc.nextInt();
                        if(contactManager.validatePhoneNumber(String.valueOf(phonenumber))) {
                            c.setPhoneNumber(phonenumber);
                            System.out.println("Changed successfully!");
                        }
                        else System.out.println("Error!");
                    } else if (option == 4) {
                        System.out.println();
                        System.out.print("New date of birth = ");
                        String dateInfo = sc.nextLine();
                        LocalDate date = LocalDate.of(Integer.parseInt(dateInfo.split("-")[0]),
                                Integer.parseInt(dateInfo.split("-")[1]),
                                Integer.parseInt(dateInfo.split("-")[2]));
                        c.setBirthDate(date);
                        System.out.println("Changed successfully!");
                    }

                }
                else System.out.println("Error!");
            }
            else if(optionMenu == 3){
                System.out.println();
                System.out.print("Remove by ID = ");
                int id = sc.nextInt();
                sc.nextLine();
                Contact c = contactManager.searchContactById(id);
                if(contactManager.removeContact(c)){
                    System.out.println("Removed successfully!");
                }
                else System.out.println("Error!");
            }
            else if(optionMenu == 4){
                System.out.println();
                System.out.print("Search by name = ");
                String nome = sc.nextLine();
                System.out.println(contactManager.searchContactByname(nome));
            }
            else if(optionMenu == 5){
                System.out.println();
                System.out.print("Search by phone number = ");
                int phoneNumber = sc.nextInt();
                sc.nextLine();
                System.out.println(contactManager.searchContactByPhoneNumber(phoneNumber));
            }
            else if(optionMenu == 6){
                System.out.println();
                System.out.print("Search by email = ");
                String email = sc.nextLine();
                System.out.println(contactManager.searchContactByEmail(email));
            }
            else if(optionMenu == 7){
                contactManager.listAllContacts();
            }
            else if(optionMenu == 8){
                contactManager.listContactsByName();
            }
            else if(optionMenu == 9){
                contactManager.listContactsByPhoneNumber();
            }
            else if(optionMenu == 10){
                contactManager.listContactsByEmail();
            }else if(optionMenu == 11){
                contactManager.listContactsByBirthDate();
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
