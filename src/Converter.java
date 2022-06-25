public class Converter {
    private final double lengthStep = 0.00075;
    private final double kilocaloriesPerStep = 0.05;

    public Converter() {
    }

    public double convertStepsToKm(int steps) {
        return steps * lengthStep;
    }

    public double convertStepsToKilocalories(int steps) {
        return steps * kilocaloriesPerStep;
    }
}
