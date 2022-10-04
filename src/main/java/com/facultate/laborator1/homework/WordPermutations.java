package com.facultate.laborator1.homework;

import java.util.HashSet;
import java.util.Set;

public class WordPermutations {

    private static Set<String> permutations = new HashSet<>();

    static public Set<String> getAllPermutations(String word){
        permutations.clear();
        getAllPermutationsRecursive(word, "");
        return permutations;
    }

    static private void getAllPermutationsRecursive(String word, String answer) {
        if (word.length() == 0) {
            permutations.add("<p>" + answer + "</p>");
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            String restOfWord = word.substring(0, i) + word.substring(i + 1);
            getAllPermutationsRecursive(restOfWord, answer + character);
        }
    }

    static public Set<String> getPermutationsOfLength(String word, int length) {
        permutations.clear();
        getAllPermutationsRecursive(word, "");
        permutations.removeIf(permutation -> permutation.length() - "<p></p>".length() != length);
        return permutations;
    }
}
