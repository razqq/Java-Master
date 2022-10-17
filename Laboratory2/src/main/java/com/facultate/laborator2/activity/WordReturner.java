package com.facultate.laborator2.activity;


import com.facultate.laborator2.activity.WordDictionary;
import com.facultate.laborator2.activity.WordPermutations;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
public class WordReturner {
    private HttpServletResponse response;

    public Set<String> returnText(String word, String size) throws IOException {
        Set<String> wordsToPrint;

        if (word != null) {
            if (!Objects.equals(size, "0")) {
                wordsToPrint = WordPermutations.getPermutationsOfLength(word, Integer.parseInt(size));
            } else {
                wordsToPrint = WordPermutations.getAllPermutations(word);
            }

            // if the dictionary is present, we remove the permutations that are not present in it
            if (WordDictionary.checkDictionaryFileExists()) {
                WordDictionary.populateDictionary();
                wordsToPrint.removeIf(w -> !WordDictionary.words.contains(w));
            }

            // print words
            return wordsToPrint;
        } else {
            return new HashSet<>();
        }
    }
}
