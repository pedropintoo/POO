package OOP.Encapsulation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("Chevrolet","Camaro",2021);
        //System.out.println(car);
        car.setYear(2022);

        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());

    }

}
