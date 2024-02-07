package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("File name: ");
        String path = sc.nextLine();

        try(PrintWriter out = new PrintWriter("src/test/"+path)){
            int c;
            for(int i = 1; i <= 1000; i++){
                c = 0;
                for(int j = 1; j <= i; j++){
                    if(i % j == 0){
                        c++;
                    }
                }
                if(c == 2){
                    out.println(i);
                }
            }

        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }

        HashSet<Integer> primeHashSet = new HashSet<>();
        try(Scanner input = new Scanner(new File("src/test/"+path))){

            while(input.hasNextLine()){
                primeHashSet.add(Integer.parseInt(input.nextLine()));
            }

            int sum = primeHashSet.stream()
                    .reduce(0, Integer::sum);



            System.out.println("A soma dos numeros primos e: "+sum);
            System.out.println("A media dos numeros primos e: "+sum / primeHashSet.size());


            primeHashSet.stream()
                    .collect(Collectors.partitioningBy(x -> x >= 500))
                    .forEach((k,v) -> {
                        if(k){
                            System.out.println("Maiores que 500:");
                        }
                        else
                            System.out.println("Menores que 500:");
                        v.forEach(n -> System.out.println("\t"+n));
                    });

            primeHashSet = primeHashSet.stream()
                    .map(x -> x*2)
                    .collect(Collectors.toCollection(HashSet::new));

        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }

        List<String> list = Stream.of("one","two","three","four")
                .filter(str -> str.length() > 3)
                .peek(str -> System.out.println("Teste " + str))
                .toList();
        

    }
}
