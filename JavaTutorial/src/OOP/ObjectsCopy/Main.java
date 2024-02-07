package OOP.ObjectsCopy;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car("Chevrolet","Camaro",2021);

        //Car car2 = new Car("Ford","Mustang",2022);
        //car2.copy(car1);

        Car car2 = new Car(car1); // outra forma mas com 1 linha

        System.out.println(car1);
        System.out.println(car2);
        System.out.println();
        System.out.println(car1.getMake());
        System.out.println(car1.getModel());
        System.out.println(car1.getYear());
        System.out.println();
        System.out.println(car2.getMake());
        System.out.println(car2.getModel());
        System.out.println(car2.getYear());

        //car2 = car1; //A FAZER ISTO ESTAMOS A CRIAR UM CLONE COM OUTRO NOME (MUDAMOS 1 --> MUDAR O OUTRO) !!!
    }

}