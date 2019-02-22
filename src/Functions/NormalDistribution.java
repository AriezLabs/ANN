package Functions;

import java.util.Random;
import java.util.function.DoubleSupplier;

public class NormalDistribution implements DoubleSupplier {
    double mean;
    double stddev;
    Random r;

    /**
     * default to mean = 0 and stddev = 1
     */
    public NormalDistribution() {
        this(0, 1);
    }

    /**
     * create new normally distributed double supplier with given mean and stddev
     */
    public NormalDistribution(double mean, double stddev) {
        this.mean = mean;
        this.stddev = stddev;
        r = new Random();
    }

    @Override
    public double getAsDouble() {
        return r.nextGaussian() * stddev + mean;
    }
}
