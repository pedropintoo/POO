public class WrapperClasses {
    public static void main(String[] args) {
        // primitive (vs) wrapper
        //------------------------
        // boolean       Boolean
        // char          Character
        // int           Integer
        // double        Double
        // OS PRIMITIVOS SÃO MAIS RÁPIDOS, MAS OS WRAPPER TÊM MAIS FUNÇÕES!

        // autoboxing
        Boolean a = true;
        Character b = '@';
        Integer c = 123;
        Double d = 3.14;
        String e = "Pedro"; // String já é uma "reference data type"

        // unboxing
        if(a==true) {
            System.out.println("This is True");
        }


    }
}
