package com.facultate.laborator1.homework;

import java.util.HashSet;
import java.util.Set;

public class WordPermutations {

    private static Set<String> permutations = new HashSet<>();

    static public Set<String> getAllPermutations(String word){
        permutations.clear();
        for (int subwordLength = 1; subwordLength <= word.length(); subwordLength++){
            getPermutationsOfLengthRecursive(word, "", subwordLength);
        }
        return permutations;
    }

    static public Set<String> getPermutationsOfLength(String word, int length) {
        permutations.clear();
        getPermutationsOfLengthRecursive(word, "", length);
        return permutations;
    }

    static private void getPermutationsOfLengthRecursive(String word, String answer, int length) {
        if (answer.length() == length){
            permutations.add(answer);
        }
        if (word.length() == 0) {
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            String restOfWord = word.substring(0, i) + word.substring(i + 1);
            getPermutationsOfLengthRecursive(restOfWord, answer + character, length);
        }
    }
}
