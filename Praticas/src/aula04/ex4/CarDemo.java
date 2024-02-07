package aula04.ex4;

import java.util.Scanner;

class Car {
    public String make;
    public String model;
    public int year;
    public int kms;

    public Car(String make, String model, int year, int kms) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kms = kms;
    }

    public void drive(int distance) {
        this.kms += distance;
    }

}

public class CarDemo {

    static Scanner sc = new Scanner(System.in);

    static int registerCars(Car[] cars) {
        // TODO: pede dados dos carros ao utilizador e acrescenta ao vetor

        // Declarations
        String make, model, input;
        String[] splitInput;
        int maxCars = cars.length;
        int numberRegister = 0;
        int year, kms, lengthInput;

        // For each input
        do{
            // Inputs
            System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
            input = sc.nextLine();

            // Validation:  w+ w+(s+w+)* d{4} d+
            if(input.matches("^\\w+ \\w+(\\s+\\w+)* \\d{4} \\d+$")){
                // Starting the split
                model = "";
                splitInput = input.split(" "); // Array
                lengthInput = splitInput.length;

                // Splitting
                make = splitInput[0];
                year = Integer.parseInt(splitInput[lengthInput-2]);
                kms = Integer.parseInt(splitInput[lengthInput-1]);
                for(int i = 1; i<= lengthInput-3; i++){ // Between the first and penultimate
                    model += " " + splitInput[i] ;
                }

                // New register
                cars[numberRegister] = new Car(make, model, year , kms);
                numberRegister++;
            }
            else if (input != ""){
                System.out.println("Dados mal formatados. Tente novamente.");
            }
        }while(input != "" && numberRegister < maxCars);

        return numberRegister;
   }

    static void registerTrips(Car[] cars, int numCars) {
        // TODO: pede dados das viagens ao utilizador e atualiza informação do carro

        // Declaration
        String input;
        int carNum, distance;
        String[] splitInput;

        // For each input
        do{
            // Input
            System.out.print("Registe uma viagem no formato \"carro:distância\": ");
            input = sc.nextLine();

            // carNum = numCars - 1 is the max for cars[carNum] !
            if(input.matches("^\\d:\\d+$") && Integer.parseInt(input.split(":")[0]) < numCars){
                // Starting split
                splitInput = input.split(":");

                // Splitting and convert to integer
                carNum = Integer.parseInt(splitInput[0]);
                distance = Integer.parseInt(splitInput[1]);

                // Call the method to add kms
                cars[carNum].drive(distance);

            }
            else if (input != ""){
                System.out.println("Dados mal formatados. Tente novamente.");
            }
        }while(input != "");
    }


    static void listCars(Car[] cars) {
        // TODO: lista todos os carros registados

        // For prettying
        System.out.println();

        System.out.println("Carros registados: ");
        // For each car
        for(Car car : cars){
            if(car != null)
                System.out.println(car.make + car.model + ", " + car.year + ", kms: " + car.kms);
        }

        // For prettying
        System.out.println();
    }

    public static void main(String[] args) {

        Car[] cars = new Car[10];

        int numCars = registerCars(cars);

        if (numCars>0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }

        sc.close();

    }
}