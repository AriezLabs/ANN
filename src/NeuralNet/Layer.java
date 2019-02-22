package NeuralNet;

import Functions.ActivationFunction;
import Functions.Identity;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;

import java.util.function.DoubleSupplier;

public class Layer {
    private ActivationFunction function;
    private DMatrixRMaj inputWeights; // dimensions: inputSize x layerSize

    /**
     * create input layer: neuron i passes input i on to next layer unmodified
     * @param inputSize
     */
    public Layer(int inputSize) {
        inputWeights = new DMatrixRMaj(inputSize, inputSize);
        this.function = new Identity();
        for (int i = 0; i < inputSize; i++)
            inputWeights.set(i, i, 1);
    }

    /**
     * create ordinary layer with weights given by supplier
     * @param size
     * @param inputSize
     * @param function
     * @param weightSupplier
     */
    public Layer(int size, int inputSize, ActivationFunction function, DoubleSupplier weightSupplier) {
        inputWeights = new DMatrixRMaj(size, inputSize);
        this.function = function;

        for (int i = 0; i < inputWeights.getNumRows(); i++)
            for (int j = 0; j < inputWeights.getNumCols(); j++)
                inputWeights.set(i, j, weightSupplier.getAsDouble());
    }

    /**
     * Process input by applying weights and activation function
     * @param input Input vector. Dimensions: layerSize x 1
     */
    DMatrixRMaj think(DMatrixRMaj input) {
        if(input.getNumRows() != inputWeights.getNumCols())
            throw new IllegalArgumentException(String.format("expected input length %d, got %d", inputWeights.getNumCols(), input.getNumRows()));

        DMatrixRMaj result = new DMatrixRMaj(input.getNumRows(), 1);
        CommonOps_DDRM.mult(inputWeights, input, result); // result = inputWeights * input
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
        return inputWeights.getNumCols();
    }
}
