package ru.geekbrains.javaGB2.homework1;

public class Robot implements Actions {
    @Override
    public void run() {
        System.out.println("run");
    }

    @Override
    public void jump() {
        System.out.println("jump");
    }
}
