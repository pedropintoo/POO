import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {
        // São Arrays que podem ser manipulados
        // Mas apenas se pode guardar WrapperClasses
        ArrayList<String> food = new ArrayList();

        food.add("Pizza");
        food.add("Hamburer");
        food.add("Hotdog");

        //Methods
        food.set(0,"Sushi");
        food.remove(2);
        //food.clear();

        for(int i = 0; i<food.size(); i++){
            System.out.println(food.get(i));
        }

    }
}
