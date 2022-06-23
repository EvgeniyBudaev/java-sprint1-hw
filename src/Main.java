import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("За какой месяц вы хотите ввести шаги: 0-Январь, 1-Февраль?");
                int month = scanner.nextInt();
                System.out.println("За какое число вы хотите ввести шаги?");
                int day = scanner.nextInt();
                System.out.println("Введите кол-во шагов за день:");
                int stepPerDay = scanner.nextInt();
                stepTracker.saveSteps(month, day, stepPerDay);
            } else if (userInput == 2) {
                System.out.println("За какой месяц напечатать статистику: 0-Январь, 1-Февраль?");
                int month = scanner.nextInt();
                stepTracker.getStatisticsForMonth(month);
            } else if (userInput == 3) {
                System.out.println("Установите новую цель по количеству шагов в день");
                int steps = scanner.nextInt();
                stepTracker.setStepsNumberTarget(steps);
            } else if (userInput  == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}
