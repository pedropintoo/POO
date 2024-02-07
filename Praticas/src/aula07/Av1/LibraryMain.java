package aula07.Av1;

import utils.UserInput;

import java.util.Scanner;

public class LibraryMain {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ILibrary library = new Library();
        Scanner sc = new Scanner(System.in);
        String choice = "";

        while (!choice.equals("7")) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Search for item");
            System.out.println("4. Borrow item");
            System.out.println("5. Return item");
            System.out.println("6. Print inventory");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    // adicionar um item
                    addItem(library);
                    break;
                case "2":
                    // remover um item
                    removeItem(library);
                    break;
                case "3":
                    searchItem(library);
                    break;
                case "4":
                    // emprestar um item, através do ID
                    borrowItem(library);
                    break;
                case "5":
                    // devolver um item, através do ID
                    returnItem(library);
                    break;
                case "6":
                    // imprimir o inventório da libraria
                    library.printInventory();
                    break;
                case "7":
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Error in input! ");
                    break;
            }
        }
        sc.close();
        scanner.close();
    }
    public static void addItem(ILibrary library){
        int duration;
        String title, autor;
        String choice = "";
        while (!choice.equals("3")) {
            System.out.println("\nLibrary add:");
            System.out.println("1. Book");
            System.out.println("2. DvD");
            System.out.println("3. Back");

            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Title: ");
                    title = scanner.nextLine();
                    System.out.print("Name of autor: ");
                    autor = scanner.nextLine();
                    library.addItem(new Book(title, autor));
                    break;
                case "2":
                    System.out.print("Title: ");
                    title = scanner.nextLine();
                    System.out.print("Duration: ");
                    duration = scanner.nextInt();
                    scanner.nextLine();
                    library.addItem(new DvD(title, duration));
                    break;
                case "3":
                    System.out.println("Exiting adder.\n");
                    break;
                default:
                    System.out.println("Errr in input! \n");

            }
        }
    }

    public static void removeItem(ILibrary library){
        String title;
        System.out.print("Title: ");
        title = scanner.nextLine();
        if(library.searchForItem(title) != null){
            library.removeItem(library.searchForItem(title));
            System.out.println("Item removed!\n");
        }
        else System.out.println("Invalid title\n");
    }

    public static void searchItem(ILibrary library){
        String title;
        System.out.print("Title: ");
        title = scanner.nextLine();
        if(library.searchForItem(title) != null){
            System.out.println(library.searchForItem(title));
        }
        else System.out.println("Invalid title\n");
    }

    public static void borrowItem(ILibrary library){
        int id;
        System.out.print("ID: ");
        id = scanner.nextInt();

        if(!library.borrowItem(id)){
            System.out.println("The borrow is impossible!");
        }
        System.out.println();

    }

    public static void returnItem(ILibrary library){
        int id;
        System.out.print("ID: ");
        id = scanner.nextInt();

        if(!library.returnItem(id)){
            System.out.println("The return is impossible!");
        }
        System.out.println();
    }
}

