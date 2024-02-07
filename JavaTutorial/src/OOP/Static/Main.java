package OOP.Static;

public class Main {
    public static void main(String[] args) {

        Friend friend1 = new Friend("Pedro");
        Friend friend2 = new Friend("João");
        Friend friend3 = new Friend("Sponegbob");
        Friend friend4 = new Friend("Sandy");

        Friend.displayFriends(); // Claro que para cada friend também funcionava mas não é recomendado
        //System.out.println(Friend.numberOfFriends);

        // Math.round(2.5); // Se virmos na Class Math o round também é "static"
    }
}
