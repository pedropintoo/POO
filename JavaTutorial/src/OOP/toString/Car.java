package OOP.toString;

public class Car {

    String make = "Chevrolet";
    String model = "Corvette";
    String color = "red";
    int year = 2021;

    public String toString() {  // é um método que já vem com o objeto e nós escrevemos por cima !
        return make + "\n" + model + "\n" + color + "\n" + year; // Isto nós é que escolhemos
    }

}
