package ActivationFunctions;

public class Identity implements ActivationFunction {
    @Override
    public double apply(double in) {
        return in;
    }
}
