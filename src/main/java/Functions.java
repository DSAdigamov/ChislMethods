public class Functions {

    private final static double ALPHA = 2;
    private final static double BETA = 3;

    public static double f1(double t, double y1, double y2) {
        return -ALPHA * y1 - BETA * y2 + (ALPHA + BETA - 1) * Math.exp(-t);
    }

    public static double f2(double t, double y1, double y2) {
        return -BETA * y1 - ALPHA * y2 + (ALPHA + BETA - 1) * Math.exp(-t);
    }
}
