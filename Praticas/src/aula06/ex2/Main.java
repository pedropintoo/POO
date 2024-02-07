package aula06.ex2;

import aula06.ex1.Person;
import utils.UserInput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);

    private final static ListOfContacts listOfContacts = new ListOfContacts();
    public static void main(String[] args) {
        // TODO: Menu with 6 different options
        //         1 - insert contact
        //         2 - change contact
        //         3 - delete contact
        //         4 - search contact
        //         5 - list contacts
        //         6 - add 10 random contacts

        menu();
    }
    public static void menu(){
        // TODO: Display the 'tester' menu of class 'Contacts'
        // Declarations
        int optionMenu;

        do {
            optionMenu = UserInput.IntegerInput(0,6, """
                
                Contacts operations:
                1 - insert contact
                2 - change contact
                3 - delete contact
                4 - search contact
                5 - list contacts
                6 - add 10 random contacts
                0 - exit
                
                Option:\s"""); // \s is for spacing

            if(optionMenu == 1){
                insertContact();
            }
            else if(optionMenu == 2){
                changeContact();
            }
            else if(optionMenu == 3){
                deleteContact();
            }
            else if(optionMenu == 4){
                searchContact();
            }
            else if(optionMenu == 5){
                listContacts();
            }
            else if(optionMenu == 6){
                randomContacts();
            }
        } while(optionMenu != 0);

    }

    public static void insertContact(){
        // Declarations
        int optionMenu;

        do {
            optionMenu = UserInput.IntegerInput(0,3, """
                
                Contacts operations:
                1 - Person + Phone Number + Email
                2 - Person + Phone Number
                3 - Person + Email
                0 - back
                
                Option:\s"""); // \s is for spacing

            if(optionMenu == 1){
                Person contactPerson = inputPerson();
                if(!contactPerson.getName().equals("")){
                    int contactPhoneNumber = inputPhoneNumber();
                    String contactEmailAddress = inputEmailAddress();
                    Contact temp = new Contact(contactPerson, contactPhoneNumber, contactEmailAddress);
                    // If input is valid!
                    if(temp.getContactPerson() != null && !temp.getContactPerson().getName().equals("")){
                        listOfContacts.insertContact(temp);
                    }
                }

            }
            else if(optionMenu == 2){
                Person contactPerson = inputPerson();
                if(!contactPerson.getName().equals("")){
                    int contactPhoneNumber = inputPhoneNumber();
                    Contact temp = new Contact(contactPerson, contactPhoneNumber);
                    // If input is valid!
                    if(temp.getContactPerson() != null && !temp.getContactPerson().getName().equals("")){
                        listOfContacts.insertContact(temp);
                    }
                }
            }
            else if(optionMenu == 3){
                Person contactPerson = inputPerson();
                if(!contactPerson.getName().equals("")){
                    String contactEmailAddress = inputEmailAddress();
                    Contact temp = new Contact(contactPerson, contactEmailAddress);
                    // If input is valid!
                    if(temp.getContactPerson() != null && !temp.getContactPerson().getName().equals("")){
                        listOfContacts.insertContact(temp);
                    }
                }
            }
        } while(optionMenu != 0);
    }

    public static void changeContact() {
        int optionMenu;

        do {
            optionMenu = UserInput.IntegerInput(0, 3, """
                                    
                    Contacts operations:
                    1 - change by name
                    2 - change by number
                    3 - change by ID
                    0 - back
                                    
                    Option:\s"""); // \s is for spacing

            if (optionMenu == 1) {
                ArrayList<Contact> filterByName = listOfContacts.searchByName(inputName());
                if (filterByName.size() == 0) {
                    System.out.println("Contact not found!");
                } else if (filterByName.size() == 1) {
                    Person contactPerson = inputPerson();
                    if (!contactPerson.getName().equals("")) {
                        int contactPhoneNumber = inputPhoneNumber();
                        String contactEmailAddress = inputEmailAddress();
                        // If input is valid!
                        if (Contact.isContactValid(contactPerson, contactPhoneNumber, contactEmailAddress)) {
                            listOfContacts.changeContactByID(filterByName.get(0).getID(), contactPerson, contactPhoneNumber, contactEmailAddress);
                            System.out.println("CHANGED --> " + filterByName.get(0));
                        }
                        else
                            System.out.println("Contact is undefined!");
                    }

                } else {
                    System.out.println("\nList of contacts with this name: ");
                    for (Contact contact : filterByName) {
                        System.out.println(contact);
                    }
                    int inputID = UserInput.IntegerInput(1, listOfContacts.allContacts.size(), "\nContact ID: ");

                    Person contactPerson = inputPerson();
                    if (!contactPerson.getName().equals("")) {
                        int contactPhoneNumber = inputPhoneNumber();
                        String contactEmailAddress = inputEmailAddress();
                        // If input is valid!
                        if (Contact.isContactValid(contactPerson, contactPhoneNumber, contactEmailAddress)) {
                            listOfContacts.changeContactByID(inputID, contactPerson, contactPhoneNumber, contactEmailAddress);
                            System.out.println("CHANGED --> " + listOfContacts.allContacts.get(inputID - 1));
                        }
                        else
                            System.out.println("Contact is undefined!");
                    }
                }
            }
            else if (optionMenu == 2) {
                    ArrayList<Contact> filterByPhoneNumber = listOfContacts.searchByPhoneNumber(inputPhoneNumber());
                    if (filterByPhoneNumber.size() == 0) {
                        System.out.println("Contact not found!");
                    } else if (filterByPhoneNumber.size() == 1) {
                        Person contactPerson = inputPerson();
                        if (!contactPerson.getName().equals("")) {
                            int contactPhoneNumber = inputPhoneNumber();
                            String contactEmailAddress = inputEmailAddress();
                            // If input is valid!
                            if (Contact.isContactValid(contactPerson, contactPhoneNumber, contactEmailAddress)) {
                                listOfContacts.changeContactByID(filterByPhoneNumber.get(0).getID(), contactPerson, contactPhoneNumber, contactEmailAddress);
                                System.out.println("CHANGED --> " + filterByPhoneNumber.get(0));
                            }
                            else
                                System.out.println("Contact is undefined!");
                        }

                    } else {
                        System.out.println("\nList of contacts with this phone number: ");
                        for (Contact contact : filterByPhoneNumber) {
                            System.out.println(contact);
                        }
                        int inputID = UserInput.IntegerInput(1, listOfContacts.allContacts.size(), "\nContact ID: ");

                        Person contactPerson = inputPerson();
                        if (!contactPerson.getName().equals("")) {
                            int contactPhoneNumber = inputPhoneNumber();
                            String contactEmailAddress = inputEmailAddress();
                            // If input is valid!
                            if (Contact.isContactValid(contactPerson, contactPhoneNumber, contactEmailAddress)) {
                                listOfContacts.changeContactByID(inputID, contactPerson, contactPhoneNumber, contactEmailAddress);
                                System.out.println("CHANGED --> " + listOfContacts.allContacts.get(inputID - 1));
                            }
                            else
                                System.out.println("Contact is undefined!");
                        }
                    }
            } else if (optionMenu == 3) {
                int inputID = UserInput.IntegerInput(1, listOfContacts.allContacts.size(), "\nContact ID: ");
                Person contactPerson = inputPerson();
                if (!contactPerson.getName().equals("")) {
                    int contactPhoneNumber = inputPhoneNumber();
                    String contactEmailAddress = inputEmailAddress();
                    // If input is valid!
                    if (Contact.isContactValid(contactPerson, contactPhoneNumber, contactEmailAddress)) {
                        listOfContacts.changeContactByID(inputID, contactPerson, contactPhoneNumber, contactEmailAddress);
                        System.out.println("CHANGED --> " + listOfContacts.allContacts.get(inputID - 1));
                    }
                    else
                        System.out.println("Contact is undefined!");
                }
            }
        } while (optionMenu != 0) ;
    }

    public static void deleteContact(){
        int optionMenu;

        do {
            optionMenu = UserInput.IntegerInput(0,3, """
                
                Contacts operations:
                1 - delete by name
                2 - delete by number
                3 - delete by ID
                0 - back
                
                Option:\s"""); // \s is for spacing

            if(optionMenu == 1){
                ArrayList<Contact> filterByName = listOfContacts.searchByName(inputName());
                if(filterByName.size() == 0){
                    System.out.println("Contact not found!");
                }
                else if(filterByName.size() == 1){
                    System.out.println("DELETED --> "+filterByName.get(0));
                    listOfContacts.deleteById(filterByName.get(0).getID());
                }
                else{
                    System.out.println("\nList of contacts with this name: ");
                    for(Contact contact : filterByName){
                        System.out.println(contact);
                    }
                    int inputID = UserInput.IntegerInput(1,listOfContacts.allContacts.size(),"\nContact ID: ");
                    System.out.println("DELETED --> "+listOfContacts.allContacts.get(inputID-1));
                    listOfContacts.deleteById(inputID);
                }
            }
            else if(optionMenu == 2){
                ArrayList<Contact> filterByPhoneNumber = listOfContacts.searchByPhoneNumber(inputPhoneNumber());
                if(filterByPhoneNumber.size() == 0){
                    System.out.println("Contact not found!");
                }
                else if(filterByPhoneNumber.size() == 1){
                    System.out.println("DELETED --> "+filterByPhoneNumber.get(0));
                    listOfContacts.deleteById(filterByPhoneNumber.get(0).getID());
                }
                else{
                    System.out.println("\nList of contacts with this phone number: ");
                    for(Contact contact : filterByPhoneNumber){
                        System.out.println(contact);
                    }
                    int inputID = UserInput.IntegerInput(1,listOfContacts.allContacts.size(),"\nContact ID: ");
                    System.out.println("DELETED --> "+listOfContacts.allContacts.get(inputID-1));
                    listOfContacts.deleteById(inputID);
                }
            }
            else if(optionMenu == 3){
                int inputID = UserInput.IntegerInput(1,listOfContacts.allContacts.size(),"\nContact ID: ");
                System.out.println("DELETED --> "+listOfContacts.allContacts.get(inputID-1));
                listOfContacts.deleteById(inputID);
            }
        } while(optionMenu != 0);
    }

    public static void searchContact(){
        int optionMenu;

        do {
            optionMenu = UserInput.IntegerInput(0,3, """
                
                Contacts operations:
                1 - search by name
                2 - search by number
                3 - search by ID
                0 - back
                
                Option:\s"""); // \s is for spacing

            if(optionMenu == 1){
                ArrayList<Contact> filterByName = listOfContacts.searchByName(inputName());
                if(filterByName.size() == 0){
                    System.out.println("Contact not found!");
                }
                else if(filterByName.size() == 1){
                    System.out.println(filterByName.get(0));
                }
                else{
                    System.out.println("\nList of contacts with this name: ");
                    for(Contact contact : filterByName){
                        System.out.println(contact);
                    }
                    int inputID = UserInput.IntegerInput(1,listOfContacts.allContacts.size(),"\nContact ID: ");
                    System.out.println(listOfContacts.allContacts.get(inputID-1));
                }
            }
            else if(optionMenu == 2){
                ArrayList<Contact> filterByPhoneNumber = listOfContacts.searchByPhoneNumber(inputPhoneNumber());
                if(filterByPhoneNumber.size() == 0){
                    System.out.println("Contact not found!");
                }
                else if(filterByPhoneNumber.size() == 1){
                    System.out.println(filterByPhoneNumber.get(0));
                }
                else{
                    System.out.println("\nList of contacts with this phone number: ");
                    for(Contact contact : filterByPhoneNumber){
                        System.out.println(contact);
                    }
                    int inputID = UserInput.IntegerInput(1,listOfContacts.allContacts.size(),"\nContact ID: ");
                    System.out.println(listOfContacts.allContacts.get(inputID-1));
                }
            }
            else if(optionMenu == 3){
                int inputID = UserInput.IntegerInput(1,listOfContacts.allContacts.size(),"\nContact ID: ");
                System.out.println(listOfContacts.allContacts.get(inputID-1));
            }
        } while(optionMenu != 0);
    }

    public static void listContacts(){
        System.out.println("\nList of contacts: ");
        System.out.println(listOfContacts);
    }

    public static void randomContacts(){
        String[] names = {"Ana",  "Beatriz", "Carlos", "Daniel", "Eduarda", "Fernanda", "Gabriel", "Helena", "Isabel",   "Joao",  "Luana", "Miguel",   "Natalia",   "Otavio", "Paula",  "Rafael",  "Sofia",  "Tiago",  "Valentina", "Yasmin"};

        for(int i=0; i<10; i++){
            int nameIndex = (int) (Math.random() * names.length);
            String name = names[nameIndex];
            Person person = new Person(name);
            int phoneNumber = 900000000 + (int)(Math.random() * 100000000); // generate a 9-digit phone number
            String emailAddress = name.toLowerCase() + "@ua.pt";
            Contact contact = new Contact(person, phoneNumber, emailAddress);
            listOfContacts.allContacts.add(contact);
        }
        System.out.println("10 random contacts added to the list!");
    }

    public static Person inputPerson(){
        String personName;

        System.out.print("Name (min. 3 chars): ");
        personName = sc.nextLine();

        // Create Person only with name for simplify

        return new Person(personName);
    }

    public static int inputPhoneNumber(){
        return UserInput.IntegerInput(0,1000000000,"Phone number: ");
    }

    public static String inputName(){
        System.out.print("Name: ");
        return sc.nextLine();
    }

    public static String inputEmailAddress(){
        System.out.print("Email: ");
        return sc.nextLine();
    }






}
