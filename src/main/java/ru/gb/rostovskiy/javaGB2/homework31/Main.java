package ru.gb.rostovskiy.javaGB2.homework31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> someWords = new ArrayList<>(Arrays.asList("One", "Two", "One", "Two", "Three", "One", "Two", "Three", "Four", "One", "Two", "Three", "Four", "Five", "One", "Two", "Three", "Four", "Five", "Six"));
        System.out.println("Созданный массив: " + someWords);
        HashSet<String> uniqueWords = new HashSet<>(someWords);
        System.out.println("Массив без дубликатов: " + uniqueWords);
        // чтобы не считать к-во слов квадратично, используем Collections.frequency()
        for (String uniqueWord : uniqueWords) {
            System.out.println("Слово " + uniqueWord + " встречается в массиве " + Collections.frequency(someWords, uniqueWord) + " раз.");
        }
    }
}
