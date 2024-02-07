import java.util.Scanner;

public class Exception extends Throwable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter a whole number to divide: ");
            int x = sc.nextInt();

            System.out.println("Enter a whole number to divide by: ");
            int y = sc.nextInt();

            double z = x/y;

            System.out.println("Result = "+z);
        }
        catch (ArithmeticException e) { // chamamos á exceção --> 'e'
            System.out.println("You can't divide by zero! IDIOT!");
        }
        catch (java.util.InputMismatchException e) { // Precisas de importar idkw :D
            System.out.println("Please enter a number!!!");
        }
        catch (java.lang.Exception e) {
            System.out.println("Something went wrong!");
        }
        finally { //Executa-se sempre!
            sc.close();
            System.out.println("(This will always print)");
        }

    }
}
