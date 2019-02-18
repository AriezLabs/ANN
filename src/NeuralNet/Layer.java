package NeuralNet;

import ActivationFunctions.ActivationFunction;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;

import java.util.function.DoubleSupplier;

public class Layer {
    private ActivationFunction function;
    private DMatrixRMaj weights;

    public Layer(int size, int inputSize, ActivationFunction function, DoubleSupplier weightSupplier) {
        weights = new DMatrixRMaj(inputSize, size);
        this.function = function;

        for (int i = 0; i < weights.getNumRows(); i++)
            for (int j = 0; j < weights.getNumCols(); j++)
                weights.set(i, j, weightSupplier.getAsDouble());
    }

    public DMatrixRMaj think(DMatrixRMaj input) {
        DMatrixRMaj result = new DMatrixRMaj(input.getNumRows(), 1);
        CommonOps_DDRM.mult(weights, input, result);
        for (int i = 0; i < result.getNumRows(); i++)
            result.set(i, 0, function.apply(result.get(i, 0)));
        return result;
    }

    public ActivationFunction getFunction() {
        return function;
    }

    public void setFunction(ActivationFunction function) {
        this.function = function;
    }

    public int getSize() {
        return weights.getNumCols();
    }
}
