package OOP.ConstructoresOverloaded;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("pao","tomato");
        //Pizza pizza = new Pizza("pao","tomato","mozzarella"); Tens as opções de por ou não
        System.out.println("Here are ingredients of your pizza: ");
        System.out.println(pizza.bread);
        System.out.println(pizza.sauce);
        System.out.println(pizza.cheese);
        System.out.println(pizza.topping);
    }
}
