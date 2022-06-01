package ru.gb.rostovskiy.javaGB2.homework2;

import java.util.Arrays;

public class App {


    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "7", "1", "4"},
                {"6", "Строка", "2", "4"},
                {"5", "2", "3", "4"}};
        MyArray myArray = new MyArray(array);
        try {
            myArray.sumDataArray();
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }


}

