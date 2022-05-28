package ru.geekbrains.javaGB2.homework1;

public class Cat implements Participants {

    private final String name;

    private int runDistance;
    private int jumpHeight;

    public Cat(String name, int runDistance, int jumpHeight) {
        this.name = name;
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
        return "**********\n" + name + " выходит на полосу препятствий.";
    }
}
