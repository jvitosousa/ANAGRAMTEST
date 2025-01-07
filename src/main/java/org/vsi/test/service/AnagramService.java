package org.vsi.test.service;

import java.util.ArrayList;
import java.util.List;

public class AnagramService {

    private static String PREFIX = "";
    private static String MESSAGE_VALIDATION = "Entrada em formato invalido!! Forneça uma entrada não vazia com apenas letras sem numeros!!";
    private List<String> result = new ArrayList<>();

    public List<String> generateAnagram(String input) {
        if (input == null || input.isEmpty() || !input.matches("[a-zA-Z]+")) {
            throw new RuntimeException(MESSAGE_VALIDATION);
        }
        generateAnagramsHelper(PREFIX, input, result);
        return result;
    }

    private static void generateAnagramsHelper(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            char currentChar = remaining.charAt(i);
            String newPrefix = prefix + currentChar;
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generateAnagramsHelper(newPrefix, newRemaining, result);
        }
    }
}
