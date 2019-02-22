package Applications;

import Functions.NormalDistribution;
import Functions.Sigmoid;
import NeuralNet.NeuralNetwork;
import io.CSVParser;
import io.Stdin;

/**
 * For MNIST CSV data.
 */
public class MNIST {
    private static void usage() {
        System.out.println("usage: java Applications.MNIST <trainset>");
    }

    public static void main(String[] args) throws Exception {
        if(args.length != 1) {
            usage();
            return;
        }

        int[] layerSizes = new int[Stdin.promptInt("number of hidden layers") + 1];
        layerSizes[0] = 784;
        for (int i = 1; i < layerSizes.length; i++) {
            layerSizes[i] = Stdin.promptInt("size of layer " + i);
        }

        NeuralNetwork net = new NeuralNetwork(layerSizes, new Sigmoid(), new NormalDistribution());
        net.train(new CSVParser(args[0]));
    }
}
