import java.util.Random;
public class RandomNumbers {
    public static void main(String[] args) {

        Random random = new Random();
        int x = random.nextInt(5);
        double y = random.nextDouble();
        boolean z = random.nextBoolean();

        System.out.println("z = " + z);

    }
}
