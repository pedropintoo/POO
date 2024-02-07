package OOP.ConstructoresOverloaded;

public class Pizza {

    String bread,sauce,cheese,topping;

    Pizza() {

    } // Quando não colocam nada!
    Pizza(String bread, String sauce) {
        this.bread = bread;
        this.sauce = sauce;
    }
    Pizza(String bread, String sauce, String cheese) {
        this.bread = bread;
        this.sauce = sauce;
        this.cheese = cheese;
    }
    Pizza(String bread, String sauce, String cheese, String topping) {
        this.bread = bread;
        this.sauce = sauce;
        this.cheese = cheese;
        this.topping = topping;
    }
}
