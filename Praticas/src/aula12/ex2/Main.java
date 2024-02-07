package aula12.ex2;


import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new FileReader("src/aula12/ex2/A_cidade_e_as_serras.txt"));

        TreeMap<String, TreeMap<String,Integer>> wordsCollection = new TreeMap<>();

        String firstLetter;
        int numberOfWord;
        TreeMap<String, Integer> treeMap;

        while (input.hasNextLine()) {

            String line = input.nextLine();
            String[] wordsLine = line.split("[ \t\n.,:'‘’;?!\\-*{}=+&/()\\[\\]”“\"]");

            // Add to allWordsFile
            for(String word : wordsLine){
                if(word.matches("[a-zA-Z]{3,}")){
                    word = word.toLowerCase();
                    numberOfWord = 1;
                    firstLetter = String.valueOf(word.charAt(0));
                    if(wordsCollection.containsKey(firstLetter)){
                        if(wordsCollection.get(firstLetter).containsKey(word)){
                            numberOfWord = wordsCollection.get(firstLetter).get(word) + 1;
                        }


                        wordsCollection.get(firstLetter).put(word,numberOfWord);
                    }
                    else{
                        treeMap = new TreeMap<>();
                        treeMap.put(word,1);
                        wordsCollection.put(firstLetter, treeMap);
                    }
                }
            }
        }


        // print the collection
        System.out.println(print(wordsCollection));

        // generate file with collection
        generateFile(print(wordsCollection),"teste.txt");

    }

    public static StringBuilder print(TreeMap<String, TreeMap<String,Integer>> wordsCollection){
        StringBuilder result = new StringBuilder();

        for(Map.Entry<String, TreeMap<String, Integer>> entryLetters : wordsCollection.entrySet()){
            result.append(entryLetters.getKey()).append(": ");
            for(Map.Entry<String, Integer> entryWords : entryLetters.getValue().entrySet()){
                result.append(entryWords.getKey()).append(", ").append(entryWords.getValue()).append("; ");

            }
            result.append("\n");
        }

        return result;
    }

    public static void generateFile(StringBuilder content, String file) throws IOException {
        PrintWriter out = new PrintWriter("src/aula12/ex2/"+file);

        out.print(content);

        out.close();
    }
}