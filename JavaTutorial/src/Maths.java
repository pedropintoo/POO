import java.util.Scanner;
public class Maths {
    public static void main(String[] args) {

        /*
        * Math.max(x,y)
        * Math.abs(x)
        * Math.round(y)
        * Math.ceil(y)
        * Math.floor(y)
        * */
        double x;
        double y;
        double z; //hipotenusa

        Scanner scan = new Scanner(System.in);

        System.out.println("X = ");
        x = scan.nextDouble();
        System.out.println("Y = ");
        y = scan.nextDouble();

        z = Math.sqrt(x*x + y*y);

        System.out.println("Hypotenuse = " + z);
        scan.close();
    }
}
