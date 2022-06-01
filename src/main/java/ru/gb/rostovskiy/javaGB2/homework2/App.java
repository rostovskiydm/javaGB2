package ru.gb.rostovskiy.javaGB2.homework2;

import java.util.Arrays;

public class App {


    public static void main(String[] args) {

        MyArray myArray = new MyArray();
        try {
            myArray.sumDataArray();
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }


}

