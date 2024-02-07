package aula12.ex1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO: Expected:
        //  Numero Total de Palavras: xxx
        //  Numero de Diferentes Palavras: yyy

        Scanner input = new Scanner(new FileReader("src/aula12/ex1/major.txt"));

        HashSet<String> allUniqueWordsFile = new HashSet<>();

        int rep = 0;
        while (input.hasNextLine()) {

            String line = input.nextLine();
            String[] wordsLine = line.split("[ \t\n.,:'‘’;?!\\-*{}=+&/()\\[\\]”“\"]+");

            // Add to allWordsFile
            for(String word : wordsLine){
                word = word.toLowerCase();
                if(word.length() > 0){
                    if(allUniqueWordsFile.contains(word)) rep++;
                    allUniqueWordsFile.add(word);
                }
            }
        }

        int uniqueWords = allUniqueWordsFile.size();
        System.out.println("Numero Total de Palavras: "+ (rep + uniqueWords));
        System.out.println("Numero de Diferentes Palavras: "+uniqueWords);

        System.out.println(allUniqueWordsFile);
    }
}
