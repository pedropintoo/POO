public class StringMethods {
    public static void main(String[] args) {
        String name = "  pedro  ";

        //boolean result = name.equals("pedro");
        //boolean result = name.equalsIgnoreCase("Pedro");
        //int result = name.length();
        //char result = name.charAt(1);
        //int result = name.indexOf("B");
        //boolean result = name.isEmpty();
        //String result = name.toUpperCase();
        //String result = name.toLowerCase();
        //String result = name.trim();
        String result = name.replace('o','a');


        System.out.println("result = " + result);
    }
}
