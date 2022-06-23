public class StepTracker {
    private final MonthData[] monthToData;
    private int stepsNumberTarget;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        stepsNumberTarget = 10000;
    }

    public void setStepsNumberTarget(int stepsNumberTarget) {
        this.stepsNumberTarget = stepsNumberTarget;
    }

    public void saveSteps(int month, int day, int steps) {
        monthToData[month].getStepsPerMonth()[day - 1] = steps;
    }

    public void getStatisticsForMonth(int month) {
        Converter converter = new Converter();
        int totalSteps = 0;
        int maxCountSteps = 0;
        double averageCountSteps = 0.0;
        int countDaysBestSeries = 0;
        int series = 0;
        int[] stepsByDayPerMonth = monthToData[month].getStepsPerMonth();

        System.out.println("Количество пройденных шагов по дням:");

        for (int i = 0; i < stepsByDayPerMonth.length; i++) {
            System.out.print(i + 1 + " день: " + stepsByDayPerMonth[i] + ", ");
            totalSteps += monthToData[month].getStepsPerMonth()[i];
            if (stepsByDayPerMonth[i] > maxCountSteps) {
                maxCountSteps = stepsByDayPerMonth[i];
            }
            averageCountSteps = (double) totalSteps / stepsByDayPerMonth.length;
            if (stepsByDayPerMonth[i] >= stepsNumberTarget) {
                ++series ;
                if (series  > countDaysBestSeries) {
                    countDaysBestSeries = series ;
                }
            } else {
                series  = 0;
            }
        }

        System.out.println();
        System.out.println("Общее количество шагов за месяц " + month + ": " + totalSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxCountSteps);
        System.out.println("Среднее количество шагов за месяц: " + averageCountSteps);
        System.out.println("Пройденная дистанция (в км): " + converter.convertStepsToKm(totalSteps));
        System.out.println("Количество сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(totalSteps));
        System.out.println("Лучшая серия: " + countDaysBestSeries);
    }

    class MonthData {
        private final int[] stepsByDay = new int[30];

        public int[] getStepsPerMonth() {
            return stepsByDay;
        }
    }
}
