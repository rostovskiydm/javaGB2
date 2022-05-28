package ru.geekbrains.javaGB2.homework1;

public class Treadmill implements Let {
    private final int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean letAction(Participants participant) {
        if (participant.run() >= distance) {
            System.out.println("Пробежал");
            return true;
        }
        System.out.println("Не пробежал");
        System.out.println("Приглашается следующий участник!");
        return false;
    }

    @Override
    public String toString() {
        return "Забег на " + distance + "м: ";
    }
}
