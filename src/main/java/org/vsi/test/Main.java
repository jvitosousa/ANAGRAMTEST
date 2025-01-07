package org.vsi.test;


import org.vsi.test.service.AnagramService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static AnagramService anagramService = new AnagramService();

    public static void main(String[] args) {
       try {
           Scanner scan = new Scanner(System.in);

           System.out.println("Forneça uma string: ");
           String input = scan.nextLine();
           List<String> anagrams = anagramService.generateAnagram(input);
           System.out.println("Anagramas: " + anagrams);
       } catch (RuntimeException ex){
           System.out.println(ex.getMessage());
       }
    }
}