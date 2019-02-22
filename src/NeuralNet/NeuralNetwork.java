package NeuralNet;

import ActivationFunctions.ActivationFunction;
import org.ejml.data.DMatrixRMaj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.DoubleSupplier;

public class NeuralNetwork {
    private ArrayList<Layer> layers;

    /**
     * Create a new NN. Input size is size of first layer, output size is size of last layer
     * Input layer (first layer) passes inputs on to hidden layers unmodified. Only exists to fix input size
     * Output layer (last layer) can have a custom activation function and weights
     * @param layerSizes Gives number of layers and the size of each layer including input and output layers
     * @param functions functions[i] = activation function of i-th layer
     * @throws IllegalArgumentException if lengths of layer and function arrays don't match
     */
    public NeuralNetwork(int[] layerSizes, ActivationFunction[] functions, DoubleSupplier weightSupplier) throws IllegalArgumentException {
        if(layerSizes.length != functions.length)
            throw new IllegalArgumentException("cannot construct net: number of layers and functions do not match");
        if(layerSizes.length < 2)
            throw new IllegalArgumentException("cannot construct net: number of hidden layers is zero");

        layers = new ArrayList<>(layerSizes.length);
        layers.add(new Layer(layerSizes[0]));
        for (int i = 1; i < layerSizes.length; i++)
            layers.add(new Layer(layerSizes[i], layerSizes[i - 1], functions[i], weightSupplier));
    }

    /** create new NN with same activation function for each layer */
    public NeuralNetwork(int[] layerSizes, ActivationFunction function, DoubleSupplier weightSupplier) {
        this(layerSizes, Collections.nCopies(layerSizes.length, function).toArray(new ActivationFunction[0]), weightSupplier);
    }

    public Layer getLayer(int i) {
        return layers.get(i);
    }

    public DMatrixRMaj think(DMatrixRMaj input) {
        if(input.getNumRows() != layers.get(0).getSize())
            throw new IllegalArgumentException(String.format("expected input length %d, got %d", layers.get(0).getSize(), input.getNumRows()));
        DMatrixRMaj result = input;
        for(Layer l : layers)
            result = l.think(result);
        return result;
    }
}
