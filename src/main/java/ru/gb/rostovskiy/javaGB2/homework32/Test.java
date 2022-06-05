package ru.gb.rostovskiy.javaGB2.homework32;

public class Test {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "998446541");
        phonebook.add("Иванов", "891184640");
        phonebook.add("Иванов", "89884640");
        phonebook.add("Сидоров", "89114875645");
        phonebook.add("Иванов", "89884640");
        phonebook.add("Петров", "89884640");
        phonebook.add("Петров", "891148756");
        phonebook.add("Петров", "891148756");

        phonebook.get("Иванов");
        phonebook.get("Петров");

        phonebook.getAllEntries();

    }
}
