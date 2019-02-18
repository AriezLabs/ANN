package NeuralNet;

import ActivationFunctions.ActivationFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.DoubleSupplier;

public class NeuralNetwork {
    private ArrayList<Layer> layers;

    public NeuralNetwork(int[] layerSizes, ActivationFunction function, DoubleSupplier weightSupplier) {
        this(layerSizes, Collections.nCopies(layerSizes.length, function).toArray(new ActivationFunction[0]), weightSupplier);
    }

    /**
     * Create a new NN. Input size is size of first layer, output size is size of last layer
     * @param layerSizes Gives number of layers and the size of each layer
     * @param functions functions[i] = activation function of i-th layer
     * @throws IllegalArgumentException if lengths of layer and function arrays don't match
     */
    public NeuralNetwork(int[] layerSizes, ActivationFunction[] functions, DoubleSupplier weightSupplier) throws IllegalArgumentException {
        if(layerSizes.length != functions.length)
            throw new IllegalArgumentException("cannot construct net: number of layers and functions do not match");
        if(layerSizes.length < 1)
            throw new IllegalArgumentException("cannot construct net: number of layers is zero");

        layers = new ArrayList<>(layerSizes.length);
        layers.add(new Layer(layerSizes[0], layerSizes[0], functions[0], weightSupplier));
        for (int i = 1; i < layerSizes.length; i++)
            layers.add(new Layer(layerSizes[i], layerSizes[i - 1], functions[i], weightSupplier));
    }

    public Layer getLayer(int i) {
        return layers.get(i);
    }
}
