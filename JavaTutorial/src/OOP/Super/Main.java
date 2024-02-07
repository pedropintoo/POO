package OOP.Super;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Batman",42,"€€€");
        Hero hero2 = new Hero("Superman",43,"everything");
        System.out.println(hero1);
        System.out.println();
        System.out.println(hero2.toString());
    }
}
