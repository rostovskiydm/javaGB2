package ru.gb.rostovskiy.javaGB2.homework2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(int rows, int columns) {
        super("Неверный размер массива. Задан размер " + rows + "X" + columns);
    }
}
