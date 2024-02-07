package aula06.ex3;

public class Vector {
    // TODO: Save a array of different integers

    // Declarations
    private int[] arrayOfIntegers = new int[0];

    @Override
    public String toString() {
        String result = "";
        for(int number : this.arrayOfIntegers){
            result += number + " ";
        }
        return result;
    }

    public void insert(int n) {

        // Necessary condition
        if(!contains(n)){
            // Declarations
            int lenArrayOfIntegers = size();
            int[] tempArray = new int[lenArrayOfIntegers+1];

            // System.arraycopy() is faster than manual copy with for loop
            System.arraycopy(this.arrayOfIntegers,0,tempArray,0,lenArrayOfIntegers);

            // Adding the actual insert number
            tempArray[lenArrayOfIntegers] = n;

            this.arrayOfIntegers = tempArray;
        }

    }


    public boolean contains(int n) {
        for(int number : this.arrayOfIntegers){
            if(n == number) return true;
        }
        return false;
    }

    public void remove(int n) {
        // Necessary condition
        if(contains(n)) {
            // Declarations
            int lenArrayOfIntegers = size();
            int[] tempArray = new int[lenArrayOfIntegers-1];
            int j = 0;

            for(int number : this.arrayOfIntegers){
                if(n != number){
                    tempArray[j] = number;
                    j++; // index counter for tempArray because of the removed index
                }
            }

            this.arrayOfIntegers = tempArray;
        }
    }

    public void empty() {
        this.arrayOfIntegers = new int [0];
    }

    public int size() {
        return this.arrayOfIntegers.length;
    }

    public Vector combine(Vector add) {
        Vector combineArray = new Vector();
        combineArray.arrayOfIntegers = this.arrayOfIntegers;

        for(int number : add.arrayOfIntegers){
            combineArray.insert(number);
        }

        return combineArray;
    }

    public Vector subtract(Vector dif) {
        Vector subtractArray = new Vector();
        subtractArray.arrayOfIntegers = this.arrayOfIntegers;

        for(int number : dif.arrayOfIntegers){
            subtractArray.remove(number);
        }

        return subtractArray;
    }

    public Vector intersect(Vector inter) {
        Vector intersectArray = new Vector();

        for(int number : inter.arrayOfIntegers){
            if(contains(number)) intersectArray.insert(number);
        }

        return intersectArray;
    }

    public static void main(String[] args) {
        Vector c1 = new Vector();
        c1.insert(4);
        c1.insert(7);
        c1.insert(6);
        c1.insert(5);

        Vector c2 = new Vector();
        int[] test = {7, 3, 2, 5, 4, 6, 7};
        for (int el : test) c2.insert(el);
        c2.remove(3);
        c2.remove(5);
        c2.remove(6);

        System.out.println(c1);
        System.out.println(c2);

        System.out.println("Number of elements in c1: " + c1.size());
        System.out.println("Number of elements in c2: " + c2.size());

        System.out.println("c1 have 6?: " + ((c1.contains(6) ? "yes" : "no")));
        System.out.println("c2 have 6?: " + ((c2.contains(6) ? "yes" : "no")));

        System.out.println("Combination: " + c1.combine(c2));
        System.out.println("Intersection: " + c1.intersect(c2));
        System.out.println("Difference: " + c1.subtract(c2));

        c1.empty();
        System.out.println("c1:" + c1);

    }
}
