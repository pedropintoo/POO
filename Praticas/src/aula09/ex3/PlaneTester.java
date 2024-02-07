package aula09.ex3;

import utils.UserInput;

import java.util.Scanner;

public class PlaneTester {
    public static void main(String[] args) {
        PlaneManager planeManager = new PlaneManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPlane Fleet Menu:");
            System.out.println("1. Add a plane to the fleet");
            System.out.println("2. Remove a plane from the fleet");
            System.out.println("3. Search for a plane");
            System.out.println("4. Print summary of all planes in the fleet");
            System.out.println("5. Print list of all commercial planes in the fleet");
            System.out.println("6. Print list of all military planes in the fleet");
            System.out.println("7. Print the fastest plane in the fleet");
            System.out.println("8. Add 5 random planes to the fleet");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addPlane(planeManager, scanner);
                    break;
                case 2:
                    removePlane(planeManager, scanner);
                    break;
                case 3:
                    searchPlane(planeManager, scanner);
                    break;
                case 4:
                    printAllPlanes(planeManager);
                    break;
                case 5:
                    printCommercialPlanes(planeManager);
                    break;
                case 6:
                    printMilitaryPlanes(planeManager);
                    break;
                case 7:
                    printFastestPlane(planeManager);
                    break;
                case 8:
                    add5RandomPlanes(planeManager);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addPlane(PlaneManager planeManager, Scanner scanner) {
        // Declarations
        int choice;

        String id = "", manufactured = "", model = "";
        int yearOfManufacture = 0, maxNumberOfPassengers = 0;
        double maxSpeed = 0;

        int numMissiles = 0; // For military plane
        int numOfCrewMembers = 0; // For commercial plane

        do {

            System.out.println("\nPlane Add Menu:");
            System.out.println("1. Military Plane");
            System.out.println("2. Commercial Plane");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if(choice != 1 && choice != 2){
                continue;
            }

            System.out.println();
            // Inputs
            do{
                System.out.print("Unique Identifier: ");
                id = scanner.nextLine();
            } while(planeManager.searchPlane(id) != null);
            do{
                System.out.print("Manufactured by: ");
                manufactured = scanner.nextLine();
            } while(manufactured.equals(""));
            do{
                System.out.print("Model: ");
                model = scanner.nextLine();
            } while(model.equals(""));
            do{
                System.out.print("Year of manufacture: ");
                yearOfManufacture = scanner.nextInt();
                scanner.nextLine();
            } while(yearOfManufacture == 0);
            do{
                System.out.print("Max number of passengers: ");
                maxNumberOfPassengers = scanner.nextInt();
                scanner.nextLine();
            } while(maxNumberOfPassengers == 0);
            do{
                System.out.print("Max speed: ");
                maxSpeed = scanner.nextDouble();
                scanner.nextLine();
            } while(maxSpeed == 0);

            // Specific input for each plane type
            switch (choice) {
                case 1:
                    // numMissiles
                    do{
                        System.out.print("Number of missiles: ");
                        numMissiles = scanner.nextInt();
                        scanner.nextLine();
                    } while(numMissiles == 0);
                    planeManager.addPlane(new MilitaryPlane(id,manufactured,model,yearOfManufacture,maxNumberOfPassengers,maxSpeed,numMissiles));
                    System.out.println(id+" : ADDED ");
                    break;
                case 2:
                    // numOfCrewMembers
                    do{
                        System.out.print("Number of crew members: ");
                        numOfCrewMembers = scanner.nextInt();
                        scanner.nextLine();
                    } while(numOfCrewMembers == 0);
                    planeManager.addPlane(new CommercialPlane(id,manufactured,model,yearOfManufacture,maxNumberOfPassengers,maxSpeed,numOfCrewMembers));
                    System.out.println(id+" : ADDED ");
                    break;
                case 0:
                    // Back to menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    private static void removePlane(PlaneManager planeManager, Scanner scanner) {
        String id;

        System.out.println();
        System.out.print("Unique Identifier: ");
        id = scanner.nextLine();

        if(planeManager.searchPlane(id) == null)
            System.out.println("Invalid ID!");
        else{
            planeManager.removePlane(id);
            System.out.println(id+" : REMOVED ");
        }


    }

    private static void searchPlane(PlaneManager planeManager, Scanner scanner) {
        String id;

        System.out.println();
        System.out.print("Unique Identifier: ");
        id = scanner.nextLine();
        Plane plane = planeManager.searchPlane(id);

        if(plane == null)
            System.out.println("Invalid ID!");
        else
            System.out.println(plane);

    }

    private static void printAllPlanes(PlaneManager planeManager) {

        planeManager.printAllPlanes("Aircraft Fleet");
    }

    private static void printCommercialPlanes(PlaneManager planeManager) {
        PlaneManager planeManagerCommercialPlanes = new PlaneManager();
        for(Plane plane : planeManager.getCommercialPlanes()){
            planeManagerCommercialPlanes.addPlane(plane);
        }

        planeManagerCommercialPlanes.printAllPlanes("Commercial Planes");

    }

    private static void printMilitaryPlanes(PlaneManager planeManager) {
        PlaneManager planeManagerMilitaryPlanes = new PlaneManager();
        for(Plane plane : planeManager.getMilitaryPlanes()){
            planeManagerMilitaryPlanes.addPlane(plane);
        }

        planeManagerMilitaryPlanes.printAllPlanes("Military Planes");

    }

    private static void printFastestPlane(PlaneManager planeManager) {
        System.out.println(planeManager.getFastestPlane());
    }

    private static void add5RandomPlanes(PlaneManager planeManager){
        // Declarations

        String id = "", manufactured = "", model = "";
        int yearOfManufacture = 0, maxNumberOfPassengers = 0;
        double maxSpeed = 0;

        int numMissiles = 0; // For military plane
        int numOfCrewMembers = 0; // For commercial plane

        System.out.println();
        for(int i = 0; i<5 ; i++){

            // Generate properties
            do{
                id = String.valueOf((int) (Math.random()*1000000 + 1));
            } while(planeManager.searchPlane(id) != null);

            manufactured = "Manufacture"+(int) (Math.random()*100 + 1);

            model = "Model"+(int) (Math.random()*100 + 1);

            yearOfManufacture = (int) (Math.random() * 500 + 1600);

            maxNumberOfPassengers = (int) (Math.random() * 100 + 50);

            maxSpeed = UserInput.roundPrecision( Math.random()*200 + 50,2);

            if( Math.random() >= 0.5){
                numMissiles = (int) (Math.random() * 20 + 5);
                planeManager.addPlane(new MilitaryPlane(id,manufactured,model,yearOfManufacture,maxNumberOfPassengers,maxSpeed,numMissiles));
                System.out.println(id+" : ADDED ");
            }
            else{
                numOfCrewMembers = (int) (Math.random() * 10 + 3);
                planeManager.addPlane(new CommercialPlane(id,manufactured,model,yearOfManufacture,maxNumberOfPassengers,maxSpeed,numOfCrewMembers));
                System.out.println(id+" : ADDED ");
            }

        }

    }
}
