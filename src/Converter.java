public class Converter {
    private final double lengthStep;
    private final double kilocaloriesPerStep;

    public Converter() {
        lengthStep = 0.00075;
        kilocaloriesPerStep = 0.05;
    }

    public double convertStepsToKm(int steps) {
        return steps * lengthStep;
    }

    public double convertStepsToKilocalories(int steps) {
        return steps * kilocaloriesPerStep;
    }
}
