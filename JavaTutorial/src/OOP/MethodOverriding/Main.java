package OOP.MethodOverriding;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();
        animal.speak();
        System.out.println();
        cat.speak();
        dog.speak();
    }
}
