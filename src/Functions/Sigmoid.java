package Functions;

public class Sigmoid implements ActivationFunction {
    @Override
    public double apply(double in) {
        return 1/(1 + (Math.pow(Math.E, -in)));
    }
}
