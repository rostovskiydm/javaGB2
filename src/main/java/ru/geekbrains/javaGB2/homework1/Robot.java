package ru.geekbrains.javaGB2.homework1;

public class Robot implements Participants {
    private final String name;
    private final String model;
    private int runDistance;
    private int jumpHeight;

    public Robot(String name, String model, int runDistance, int jumpHeight) {
        this.name = name;
        this.model = model;
        setRunDistance(runDistance);
        setJumpHeight(jumpHeight);
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = Math.max(runDistance, 0);
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = Math.max(jumpHeight, 0);
    }

    @Override
    public int run() {
        return runDistance;
    }

    @Override
    public int jump() {
        return jumpHeight;
    }

    @Override
    public String toString() {
        return "**********\n" + name + " " + model + " выходит на полосу препятствий.";
    }
}
