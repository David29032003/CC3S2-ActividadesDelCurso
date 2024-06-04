package org.example;

import java.util.StringTokenizer;

public class CountWords {
    public int count(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        int count = 0;

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            // Remover caracteres no alfanuméricos al final de la palabra
            word = word.replaceAll("[^a-zA-Z0-9]$", "");
            if (word.endsWith("r") || word.endsWith("s")) {
                count++;
            }
        }

        return count;
    }
}


