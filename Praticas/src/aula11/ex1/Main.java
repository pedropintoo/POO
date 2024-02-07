package aula11.ex1;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new FileReader("src/aula11/ex1/major.txt"));

        TreeMap<String, TreeMap<String,Integer>> wordsCollection = new TreeMap<>();

        ArrayList<String> allWordsFile = new ArrayList<>();
        while (input.hasNextLine()) {

            String line = input.nextLine();
            String[] wordsLine = line.split("[ \t\n.,:'‘’;?!\\-*{}=+&/()\\[\\]”“\"]");

            // Add to allWordsFile
            for(String word : wordsLine){
                if(word.length() >= 3){
                    allWordsFile.add(word.toLowerCase());
                }
            }
        }

        // Add file words to collection
        for(int i = 0; i < allWordsFile.size()-1; i++){
            add(allWordsFile.get(i), allWordsFile.get(i + 1),wordsCollection);
        }

        // print the collection
        System.out.println(print(wordsCollection));

    }
    public static void add(String word, String nextWord, TreeMap<String, TreeMap<String,Integer>> wordsCollection){
        int numNextWord = 1;
        if(wordsCollection.containsKey(word)){
            if(wordsCollection.get(word).containsKey(nextWord)){
                numNextWord = wordsCollection.get(word).get(nextWord) + 1;
            }
            wordsCollection.get(word).put(nextWord,numNextWord);
        }
        else{
            TreeMap<String, Integer> treeMap = new TreeMap<>();
            treeMap.put(nextWord,1);
            wordsCollection.put(word, treeMap);
        }
    }

    public static StringBuilder print(TreeMap<String, TreeMap<String,Integer>> wordsCollection){
        StringBuilder result = new StringBuilder();
        boolean first;
        for(Map.Entry<String, TreeMap<String, Integer>> entry : wordsCollection.entrySet()){
            result.append(entry.getKey()).append("={");
            first = true;
            for(Map.Entry<String, Integer> entryNext : entry.getValue().entrySet()){
                if(!first){
                    result.append(", ");
                }
                result.append(entryNext.getKey()).append("=").append(entryNext.getValue());
                first = false;
            }
            result.append("}");
            result.append("\n");
        }

        return result;
    }
}
