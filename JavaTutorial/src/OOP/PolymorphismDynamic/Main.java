package OOP.PolymorphismDynamic;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Animal animal; // Não queremos gastar o espaço na memoria para os 2, esperamos e depois criamos

        System.out.println("What animal do you want?");
        System.out.println("1 - Dog");
        System.out.println("2 - Cat");
        int choice = sc.nextInt();

        if(choice == 1){
            animal = new Dog();
            animal.speak();
        }
        else if(choice == 2){
            animal = new Cat();
            animal.speak();
        }
        else {
            animal = new Animal();
            System.out.println("That choice was invalid!");
            animal.speak();
        }

    }
}
