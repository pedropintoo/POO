public class Array {
    public static void main(String[] args) {
        // Array são listas em que não conseguimos mudar o tamanho e não muito flexiveis
        // (ArrayLists são melhores para isso)

        //                  0          1        2      3
        /*
        String[] cars = {"Camaro","Corvette","Tesla","BMW"}; // Têm de ser todos do mesmo tipo
        cars[0] = "Mustang";
        */
        String[] cars = new String[3];
        
        cars[0] = "Camaro";
        cars[1] = "Corvette";
        cars[2] = "Tesla";

        for(int i=0; i<cars.length; i++) {
            System.out.println("Position "+i+" : "+cars[i]);
        }
        /* A MESMA COISA MAS COM "FOR EACH" ( funciona também para ArrayList)
        for(String el : cars) {
            System.out.println(el);
        }
        */


    }
}
