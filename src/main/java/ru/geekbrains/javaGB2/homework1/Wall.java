package ru.geekbrains.javaGB2.homework1;

public class Wall implements Let {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean letAction(Participants participant) {
        if (participant.jump() >= height) {
            System.out.println("Перепрыгнул!");
            return true;
        }
        System.out.println("Не перепрыгнул!");
        System.out.println("Приглашается следующий участник!");
        return false;
    }

    @Override
    public String toString() {
        return "Прыжок в высоту на " + height + "м: ";
    }
}
