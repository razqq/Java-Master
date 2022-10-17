package com.facultate.laborator2.activity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class WordDictionary {
    public static Set<String> words = new HashSet<>();
    private static final String dictionaryPath = "/Users/razcro/Desktop/Facultate/Java/Laboratory1/src/main/java/com/facultate/laborator1/dictionary.txt";

    public static boolean checkDictionaryFileExists(){
        File file = new File(dictionaryPath);
        System.out.println(file.getAbsolutePath());
        return file.exists();
    }

    public static void populateDictionary() throws IOException {
        words.clear();
        Path path = Paths.get(dictionaryPath);
        words = new HashSet<>(Files.readAllLines(path));
    }
}
