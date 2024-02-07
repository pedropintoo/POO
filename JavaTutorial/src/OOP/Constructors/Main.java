package OOP.Constructors;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Rick",65,82.7);
        Human human2 = new Human("Pedro",18,70);

        /*
        System.out.println(human1.weight);
        System.out.println(human2.name);
        */

        human2.eat();
        human1.drink();
    }
}
