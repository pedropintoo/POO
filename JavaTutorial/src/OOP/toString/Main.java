package OOP.toString;

public class Main {
    public static void main(String[] args) {

        Car car = new Car();

        System.out.println(car.toString());
        System.out.println(car);
        // é igual, ele faz isto sozinho car.toString() == car
    }
}
