package ru.geekbrains.javaGB2.homework1;

public class App {
    public static void main(String[] args) {
        Participants[] participants = new Participants[]{
                new Cat("Гарфилд", 10, 5),
                new Cat("Салем", 50, 8),
                new Cat("Бегемот", 7, 1),
                new Human("Архимед", 20, 20),
                new Human("Пифагор", 15, 4),
                new Human("Платон", 40, 5),
                new Robot("Арнольд", "T-800", 12, 2),
                new Robot("Роберт", "T-1000", 15, 1),
                new Robot("Валли", "WALL-E", 50, 20),
        };
        Let[] lets = new Let[]{
                new Treadmill(15),
                new Treadmill(10),
                new Wall(10),
                new Wall(20),
        };
        for (Participants participant : participants) {
            System.out.println(participant);
            for (Let let : lets) {
                System.out.print(let);
                if (!let.letAction(participant)) {
                    break;
                }
            }
        }

    }
}
