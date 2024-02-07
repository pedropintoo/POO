public class Printf {
    public static void main(String[] args) {

        // % [flags] [precision] [width] [conversion-character]

        boolean myBoolean = true;
        char myChar = '@';
        String myString = "Pedro";
        int myInt = 50;
        double myDouble = 10000.05;

        // [conversion-character]
        System.out.printf("%b\n",myBoolean);
        System.out.printf("%c\n",myChar);
        System.out.printf("%s\n",myString);
        System.out.printf("%d\n",myInt);
        System.out.printf("%f\n",myDouble);

        // [width]
        System.out.printf("Hello %10s\n",myString);

        // [precision]
        System.out.printf("Money = %.1f \n",myDouble);

        // [flags]  (Eg.. '- : left-justify' / '+ : sign for number' / '0' / ', : spaces in big numbers')
        System.out.printf("Money = %-20.4f !\n",myDouble);
        System.out.printf("Money = %+.4f\n",myDouble);
        System.out.printf("Money = %015f\n",myDouble);
        System.out.printf("Money = %,.1f\n",myDouble);
    }
}
