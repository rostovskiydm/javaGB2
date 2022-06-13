package ru.gb.rostovskiy.javaGB2.homework5Universal;


import java.util.Arrays;

public class Homework5Universal {

    private static final int SIZE = 10_000_000;

    public static void main(String[] args) {
        ArrayActions arrayActions = new ArrayActions(SIZE);
        arrayActions.oneThread();
        arrayActions.multiThread(20);
    }
}

class ArrayActions {
    private final int arraySize;
    private float[] arr;
    private int arrFirstIndex;
    private int arrLastIndex;


    public ArrayActions(int arraySize) {
        this.arraySize = arraySize;
        this.arrFirstIndex = 0;
        this.arrLastIndex = 0;
    }

    public void oneThread() {
        arr = new float[arraySize];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        arr = calculateNewValues(arr);
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public void multiThread(int threadQuantity) {
        arr = new float[arraySize];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        if (arraySize < threadQuantity) {
            threadQuantity = arraySize; // чтоб не получить 0 в делении массива на части
        }
        int arrSmallPart = arr.length / threadQuantity;
        Thread[] t = new Thread[threadQuantity];
        for (int i = 0; i < t.length; i++) {
            if (arrLastIndex + arrSmallPart < arr.length && i + 1 < t.length) { // анализируем окончание большого массива
                arrLastIndex += arrSmallPart;
                t[i] = new MyThread(arrLastIndex, arrFirstIndex, this);
                arrFirstIndex += arrSmallPart;
            } else {
                arrFirstIndex = arrLastIndex;
                arrLastIndex = arr.length;
                t[i] = new MyThread(arrLastIndex, arrFirstIndex, this);
            }
        }
        for (Thread thread : t) {
            thread.start();
        }
        try {
            for (Thread thread : t) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public void splitAndMergeArray(int lastIndex, int firstIndex) {
        float[] array;
        array = Arrays.copyOfRange(arr, firstIndex, lastIndex); // заполняем промежуточный массив, равный части большого массива
        array = calculateNewValues(array);
        System.arraycopy(array, 0, arr, firstIndex, lastIndex - firstIndex); // перезаполняем большой массив промежуточным
    }

    public float[] calculateNewValues(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

}

class MyThread extends Thread {
    private final int lastIndex;
    private final int firstIndex;
    private final ArrayActions arrayActions;

    public MyThread(int lastIndex, int firstIndex, ArrayActions arrayActions) {
        this.lastIndex = lastIndex;
        this.firstIndex = firstIndex;
        this.arrayActions = arrayActions;
    }

    @Override
    public void run() {
        arrayActions.splitAndMergeArray(lastIndex, firstIndex);
    }
}
