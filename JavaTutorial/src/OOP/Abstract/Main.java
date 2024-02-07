package OOP.Abstract;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        //Vehicle vehicle = new Vehicle(); // Com o "abstract" a classe já não pode ser inicializada
        car.go();
    }
}
