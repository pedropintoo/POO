package aula09.ex2;

import java.util.*;

public class CollectionTester {
    public static void main(String[] args) {
        int[] DIM = {1000, 5000, 10000, 20000, 40000, 100000};
        String[] op = {"add", "search", "remove"};

        Collection<Collection<Integer>> allCollections = new ArrayList<>() {
        };
        allCollections.add(new ArrayList<Integer>());
        allCollections.add(new LinkedList<Integer>());
        allCollections.add(new HashSet<Integer>());
        allCollections.add(new TreeSet<Integer>());

        // Title
        System.out.printf("%-15s %15d %15d %15d %15d %15d %15d","Collections",DIM[0],DIM[1],DIM[2],DIM[3],DIM[4],DIM[5]);

        for(Collection<Integer> col : allCollections){
            System.out.printf("\n\n%-15s",col.getClass().getSimpleName());
            for (int i = 0; i < op.length; i++){
                System.out.printf("\n%-15s ",op[i]);
                for(int dim : DIM) {
                    System.out.printf("%15f ", checkPerformance(col,dim)[i]);
                }
            }
        }


    }

    private static double[] checkPerformance(Collection<Integer> col, int DIM) {
        double start, stop;
        double timeAdd, timeSearch, timeRemove;
        // TODO: Add
        start = System.nanoTime(); // clock snapshot before
        for(int i=0; i<DIM; i++ )
            col.add( i );
        stop = System.nanoTime(); // clock snapshot after
        timeAdd = (stop-start)/1e6; // convert to milliseconds

        // TODO: Search
        start = System.nanoTime(); // clock snapshot before
        for(int i=0; i<DIM; i++ ) {
            int n = (int) (Math.random()*DIM);
            if (!col.contains(n))
                System.out.println("Not found???"+n);
        }
        stop = System.nanoTime(); // clock snapshot after
        timeSearch = (stop-start)/1e6; // convert nanoseconds to milliseconds

        // TODO:  Remove
        start = System.nanoTime(); // clock snapshot before
        Iterator<Integer> iterator = col.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        stop = System.nanoTime(); // clock snapshot after
        timeRemove = (stop-start)/1e6; // convert nanoseconds to milliseconds

        return new double[] {timeAdd, timeSearch, timeRemove};
    }

}