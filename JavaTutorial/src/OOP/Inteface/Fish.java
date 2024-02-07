package OOP.Inteface;

public class Fish implements Prey,Predator{ //Implementamos as duas interfaces

    @Override
    public void hunt() {
        System.out.println("This fish is hunting smaller fish");
    }

    @Override
    public void flee() {
        System.out.println("This fish is fleeing from a larger fish");
    }
}
