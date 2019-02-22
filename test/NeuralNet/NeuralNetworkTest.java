package NeuralNet;

import Functions.Identity;
import org.ejml.data.DMatrixRMaj;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeuralNetworkTest {
    @Test
    void testNN() {
        NeuralNetwork net = new NeuralNetwork(new int[]{2, 5, 3, 1}, new Identity(), () -> 1);
        DMatrixRMaj testin = new DMatrixRMaj(2, 1);
        testin.set(0,0,1);
        testin.set(1,0,5);
        DMatrixRMaj out = net.think(testin);
        assertEquals(90d, out.get(0, 0));
    }
}