package com.facultate.laborator1.homework;

import java.util.HashSet;
import java.util.Set;

public class WordPermutations {

    private static Set<String> permutations = new HashSet<>();

    static public Set<String> getAllPermutations(String word, String answer) {
        permutations.clear();
        if (word.length() == 0) {
            permutations.add("<p>" + answer + "</p>");

        }

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            String restOfWord = word.substring(0, i) + word.substring(i + 1);
            getAllPermutations(restOfWord, answer + character);
        }
        return permutations;
    }

    static public Set<String> getPermutationsOfLength(String word, String answer, int length) {
        permutations.clear();
        getAllPermutations(word, answer);
        permutations.removeIf(permutation -> permutation.length() != length);
        return permutations;
    }
}
