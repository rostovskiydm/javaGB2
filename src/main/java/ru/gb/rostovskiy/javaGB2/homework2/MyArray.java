package ru.gb.rostovskiy.javaGB2.homework2;

import java.util.Arrays;

public class MyArray {
    private static final int ROWS = 4;
    private static final int COLUMNS = 4;
    private String[][] array;

    public MyArray(String[][] array) {
        this.array = array;
    }

    public void checkSize() {
        if (array.length != ROWS || array[0].length != COLUMNS) {   // допущение, что все строки одной длины
            throw new MyArraySizeException(array.length, array[0].length);
        }
    }

    public void sumDataArray() {
        checkSize();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Сумма элементов массива: " + sum);
    }

    public String toString() {
        return Arrays.deepToString(array);
    }
}
