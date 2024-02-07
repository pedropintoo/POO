package OOP.MethodOverriding;

public class Dog extends Animal{

    @Override   // Não faz nada mas sinaliza apenas que está escrito por cima
    void speak() {
        System.out.println("The dog goes *bark*");
    }
}
