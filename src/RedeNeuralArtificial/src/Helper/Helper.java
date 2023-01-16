package Helper;

import java.util.Random;

public class Helper {
    public static double calculateSigmoid(double x) {
        return 1.0 / (1 + Math.exp(-x));
    }

    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }
}
