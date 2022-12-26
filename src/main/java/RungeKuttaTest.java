import java.util.Arrays;

public class RungeKuttaTest {

    public static void test() {
        int n = 40;
        double a = 0;
        double b = 4;
        double h = (b - a) / n;
        
        double[] y1 = new double[n];
        double[] y2 = new double[n];

        y1[0] = 1;
        y2[0] = 1;

        for (int i = 0; i < n - 1; i++) {
            double t = a + i * h;

            double k1 = Functions.f1(t, y1[i], y2[i]);
            double m1 = Functions.f2(t, y1[i], y2[i]);

            double k2 = Functions.f1(t + h / 2, y1[i] + h * k1 / 2, y2[i] + h * m1 / 2);
            double m2 = Functions.f2(t + h / 2, y1[i] + h * k1 / 2, y2[i] + h * m1 / 2);

            double k3 = Functions.f1(t + h / 2, y1[i] + h * k2 / 2, y2[i] + h * m2 / 2);
            double m3 = Functions.f2(t + h / 2, y1[i] + h * k2 / 2, y2[i] + h * m2 / 2);

            double k4 = Functions.f1(t + h, y1[i] + h * k3, y2[i] + h * m3);
            double m4 = Functions.f2(t + h, y1[i] + h * k3, y2[i] + h * m3);

            y1[i + 1] = y1[i] + h * (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            y2[i + 1] = y2[i] + h * (m1 + 2 * m2 + 2 * m3 + m4) / 6;
        }

        double[] u = new double[n];
        for (int i = 0; i < u.length; i++) {
            double t = a + i * h;
            u[i] = Math.exp(-t);
        }

        double[] pogr = new double[n];
        for (int i = 0; i < pogr.length; i++) {
            pogr[i] = Math.abs(y1[i] - u[i]);
        }

        System.out.println(Arrays.toString(pogr));
    }


}
