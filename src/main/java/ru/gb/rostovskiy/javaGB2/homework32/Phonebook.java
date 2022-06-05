package ru.gb.rostovskiy.javaGB2.homework32;

import java.util.*;

public class Phonebook {
    private HashMap<String, ArrayList<String>> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String secondName, String phoneNumber) {
        if (secondName != null && phoneNumber != null) {
            ArrayList<String> phoneNumbers;
            if (phonebook.containsKey(secondName)) {
                phoneNumbers = new ArrayList<>(phonebook.get(secondName));
                if (!phoneNumbers.contains(phoneNumber)) {
                    phoneNumbers.add(phoneNumber);
                } else {
                    System.out.println("В справочнике уже есть хапись по " + secondName + " с номером т." + phoneNumber);
                    return;
                }
            } else {
                phoneNumbers = new ArrayList<>(List.of(phoneNumber));
            }
            phonebook.put(secondName, phoneNumbers);
            System.out.println("Данные в справочник добавлены успешно!");
        } else {
            System.out.println("Введены некорректные значения. Добваление данных в справочник - невозможно!");
        }
    }

    public void get(String secondName) {
        if (secondName != null && phonebook.containsKey(secondName)) {
            System.out.println("С фамилией " + secondName + " в справочнике найдены следующие номера: ");
            System.out.println(phonebook.get(secondName));
        } else {
            System.out.println("По указанным данным в справочнике ничего не найдено!");
        }
    }

    public void getAllEntries(){
        System.out.println("****** ТЕЛЕФОННЫЙ СПРАВОЧНИК *******");
        for (Map.Entry<String, ArrayList<String>> entry : phonebook.entrySet()){
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

}
