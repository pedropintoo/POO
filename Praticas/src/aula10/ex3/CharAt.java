package aula10.ex3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CharAt {
    public static void main(String[] args) {
        String[] words = {"Hello World", "good night", "Java programming", "object-oriented", "compiler error", "data structures", "inheritance", "recursive function", "exception handling", "interface implementation"};

        Map<String, HashSet<Integer>> lettersPos;

        for(String word : words){
            lettersPos = new HashMap<>();

            for(int j = 0; j < word.length() ; j++){
                String c = String.valueOf(word.charAt(j));
                if(lettersPos.containsKey(c)){
                    lettersPos.get(c).add(j);
                }
                else{
                    lettersPos.put(c, new HashSet<Integer>());
                    lettersPos.get(c).add(j);
                }
            }

            System.out.println(word+" --> "+lettersPos);
        }


    }

}
