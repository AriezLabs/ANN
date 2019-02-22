package Functions;

import java.util.function.DoubleSupplier;

public class EqualDistribution implements DoubleSupplier {
    double min;
    double max;

    /**
     * defaults to random values in [-0.1, 0.1)
     */
    public EqualDistribution() {
        this(-0.1, 0.1);
    }

    /**
     * returns random values in [min, max)
     */
    public EqualDistribution(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public double getAsDouble() {
        return Math.random() * (max - min) + min;
    }
}
