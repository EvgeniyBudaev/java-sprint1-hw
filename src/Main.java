import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                int month;
                int day;
                int stepPerDay;

                while (true){
                    System.out.println("За какой месяц вы хотите ввести шаги: 0-Январь, ..., 11-Декабрь?");
                    month = scanner.nextInt();
                    if (month < 0 || month > 11){
                        System.out.println("Введите корректный номер месяца: 0-Январь, ..., 11-Декабрь");
                    }
                    else break;
                }
                while (true){
                    System.out.println("За какое число вы хотите ввести шаги?");
                    day = scanner.nextInt();
                    if (day < 1 || day > 30){
                        System.out.println("Введите корректное число месяца: от 1 до 30");
                    }
                    else break;
                }
                while (true){
                    System.out.println("Введите кол-во шагов за день:");
                    stepPerDay = scanner.nextInt();
                    if (stepPerDay < 0){
                        System.out.println("Кол-во шагов не может быть отрицательным значением");
                    }
                    else break;
                }
                stepTracker.saveSteps(month, day, stepPerDay);
            } else if (userInput == 2) {
                int month;
                while (true){
                    System.out.println("За какой месяц напечатать статистику: 0-Январь, ..., 11-Декабрь?");
                    month = scanner.nextInt();
                    if (month < 0 || month > 11){
                        System.out.println("Введите корректный номер месяца: 0-Январь, ..., 11-Декабрь");
                    }
                    else break;
                }
                stepTracker.getStatisticsForMonth(month);
            } else if (userInput == 3) {
                int steps;
                while (true){
                    System.out.println("Установите новую цель по количеству шагов в день");
                    steps = scanner.nextInt();
                    if (steps < 0){
                        System.out.println("Кол-во шагов не может иметь отрицательное значение");
                    }
                    else break;
                }
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
