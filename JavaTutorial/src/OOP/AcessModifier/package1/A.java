package OOP.AcessModifier.package1;
import OOP.AcessModifier.package2.*;

public class A {
    public static void main(String[] args) {
        B b = new B();
        //System.out.println(b.privateMessage); Não funciona porque é "private" no B
    }
}
