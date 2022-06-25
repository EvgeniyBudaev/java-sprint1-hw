public class StepTracker {
    private final MonthData[] monthToData;
    private int stepsNumberTarget;
    private Converter converter;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        stepsNumberTarget = 10000;
        converter = new Converter();
    }

    public void setStepsNumberTarget(int stepsNumberTarget) {
        this.stepsNumberTarget = stepsNumberTarget;
    }

    public void saveSteps(int month, int day, int steps) {
        monthToData[month].getStepsPerMonth()[day - 1] = steps;
    }

    public void getStatisticsForMonth(int month) {
        MonthData monthData = new MonthData();
        int[] steps = monthToData[month].getStepsPerMonth();
        int totalSteps = monthData.getTotalSteps(steps, month);;

        System.out.println("Количество пройденных шагов по дням:");
        monthData.getStepsByDay(steps);
        System.out.println();
        System.out.println("Общее количество шагов за месяц " + month + ": " + totalSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.getMaxCountSteps(steps));
        System.out.println("Среднее количество шагов за месяц: " + monthData.getAverageCountSteps(steps));
        System.out.println("Пройденная дистанция (в км): " + converter.convertStepsToKm(totalSteps));
        System.out.println("Количество сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(totalSteps));
        System.out.println("Лучшая серия: " + monthData.getCountDaysBestSeries(steps));
    }

    class MonthData {
        private int totalSteps = 0;
        private int maxCountSteps = 0;
        private double averageCountSteps = 0.0;
        private int countDaysBestSeries = 0;
        private int series = 0;
        private final int[] stepsByDay = new int[30];

        public int[] getStepsPerMonth() {
            return stepsByDay;
        }

        public void getStepsByDay(int[] stepsByDayPerMonth) {
            for (int i = 0; i < stepsByDayPerMonth.length; i++) {
                System.out.print(i + 1 + " день: " + stepsByDayPerMonth[i] + ", ");
            }
        }

        public int getTotalSteps(int[] stepsByDayPerMonth, int month) {
            for (int i = 0; i < stepsByDayPerMonth.length; i++) {
                totalSteps += monthToData[month].getStepsPerMonth()[i];
            }
            return totalSteps;
        }

        public int getMaxCountSteps(int[] stepsByDayPerMonth) {
            for (int i = 0; i < stepsByDayPerMonth.length; i++) {
                if (stepsByDayPerMonth[i] > maxCountSteps) {
                    maxCountSteps = stepsByDayPerMonth[i];
                }
            }
            return maxCountSteps;
        }

        public double getAverageCountSteps(int[] stepsByDayPerMonth) {
            for (int i = 0; i < stepsByDayPerMonth.length; i++) {
                averageCountSteps = (double) totalSteps / stepsByDayPerMonth.length;
            }
            return averageCountSteps;
        }

        public int getCountDaysBestSeries(int[] stepsByDayPerMonth) {
            for (int i = 0; i < stepsByDayPerMonth.length; i++) {
                if (stepsByDayPerMonth[i] >= stepsNumberTarget) {
                    ++series ;
                    if (series  > countDaysBestSeries) {
                        countDaysBestSeries = series ;
                    }
                } else {
                    series  = 0;
                }
            }
            return countDaysBestSeries;
        }
    }
}
