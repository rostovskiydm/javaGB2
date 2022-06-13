package ru.gb.rostovskiy.javaGB2.homework5;

import java.util.Arrays;

public class Homework5 {

    private static final int SIZE = 10_000_000;

    public static void main(String[] args) {
        ArrayActions arrayActions = new ArrayActions(SIZE);
        arrayActions.oneThread();
        arrayActions.multiThread();
    }

}

class ArrayActions {
    private final int arraySize;
    private final int arrayHalfSize;
    private float[] arr;
    private float[] arrLeftHalf;
    private float[] arrRightHalf;

    public ArrayActions(int arraySize) {
        this.arraySize = arraySize;
        this.arrayHalfSize = arraySize / 2;
    }

    public void oneThread() {
        arr = new float[arraySize];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        arr = calculateNewValues(arr);
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public void multiThread() {
        arr = new float[arraySize];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        splitArray();
        Thread t1 = new Thread(() -> {
            arrLeftHalf = calculateNewValues(arrLeftHalf);
            System.arraycopy(arrLeftHalf, 0, arr, 0, arrayHalfSize);
        });
        Thread t2 = new Thread(() -> {
            arrRightHalf = calculateNewValues(arrRightHalf);
            System.arraycopy(arrRightHalf, 0, arr, arrayHalfSize, arrayHalfSize);
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public void splitArray() {
        arrLeftHalf = new float[arrayHalfSize];
        arrRightHalf = new float[arrayHalfSize];
        System.arraycopy(arr, 0, arrLeftHalf, 0, arrayHalfSize);
        System.arraycopy(arr, arrayHalfSize, arrRightHalf, 0, arrayHalfSize);
    }

    public float[] calculateNewValues(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

}