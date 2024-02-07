public class Methods {
    public static void main(String[] args) {

        String name = "Pedro";
        int age = 18;
        //hello(name,age);

        int x = 3;
        int y = 4;
        int sum = add(x,y);
        System.out.println("sum = " + sum);
    }
    static void hello(String name, int age) {
        System.out.println("Hello "+ name);
        System.out.println(age + " years old!");
    }
    static int add(int x, int y) {
        return x + y;
    }
}
