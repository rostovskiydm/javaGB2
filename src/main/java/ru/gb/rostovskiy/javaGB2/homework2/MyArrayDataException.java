package ru.gb.rostovskiy.javaGB2.homework2;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int row, int column) {
        super("В массиве присутсвует символ/строка в строке " + row + " колонка " + column);
    }
}
