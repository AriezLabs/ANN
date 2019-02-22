package NeuralNet;

import Functions.Identity;
import org.ejml.data.DMatrixRMaj;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LayerTest {

    @Test
    void think() {
        Layer test = new Layer(2, 2, new Identity(), () -> 5);
        DMatrixRMaj testInput = new DMatrixRMaj(2, 1);
        // test case 1
        testInput.set(0, 2);
        testInput.set(1, 4);
        DMatrixRMaj out = test.think(testInput);
        assertEquals(30, out.get(0));
        assertEquals(30, out.get(1));
        // test case 2
        testInput.set(0, 0);
        testInput.set(1, 0);
        out = test.think(testInput);
        assertEquals(0, out.get(0));
        assertEquals(0, out.get(1));
    }
}