package aula10.ex4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new FileReader("src/aula10/ex4/words.txt"));
        Collection<String> allWords = new HashSet<>();
        while (input.hasNext()) {
            String word = input.next();
            if(word.length() > 2){
                allWords.add(word);
            }
        }
        Collection<String> removeWords = new HashSet<>();
        for(String word : allWords){
            if(word.endsWith("s"))
                System.out.println(word);
            if(!word.matches("^[a-zA-Z]*$")){
                System.out.println("\t"+word);
                removeWords.add(word);
            }
        }
        allWords.removeAll(removeWords);

        System.out.println();
        System.out.println("Word without simbols");

        for (String word : allWords){
            System.out.println(word);
        }


    }
}
