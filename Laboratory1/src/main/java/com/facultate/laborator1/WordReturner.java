package com.facultate.laborator1;


import com.facultate.laborator1.compulsory.OrderedList;
import com.facultate.laborator1.homework.WordDictionary;
import com.facultate.laborator1.homework.WordPermutations;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
public class WordReturner {
    private HttpServletResponse response;

    public void returnHTML(String word, String size) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>"); // Start html

        Set<String> wordsToPrint;

        if (word != null) {
            out.println("<div><h1>Word to ordered list</h1></div>");
            out.println(OrderedList.wordToOrderedList(word));

            if (!Objects.equals(size, "0")) {
                out.println(String.format("<div><h1>Word permutations of length <%s>:</h1>", size));
                wordsToPrint = WordPermutations.getPermutationsOfLength(word, Integer.parseInt(size));

            } else {
                out.println("<div><h1>Word permutations of all lengths since size is not specified</h1>");
                wordsToPrint = WordPermutations.getAllPermutations(word);
            }

            // if the dictionary is present, we remove the permutations that are not present in it
            if (WordDictionary.checkDictionaryFileExists()) {
                WordDictionary.populateDictionary();
                wordsToPrint.removeIf(w -> !WordDictionary.words.contains(w));
            }

            // print words
            out.println(wordsToPrint);
            out.println("</div>");
        } else {
            out.println("<div>No word received</div>");
        }

        out.println("</body></html>"); // End html
    }

    public void returnText(String word, String size) throws IOException {
        PrintWriter out = response.getWriter();
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
            out.println(wordsToPrint);
        } else {
            out.println("[]");
        }
    }
}
