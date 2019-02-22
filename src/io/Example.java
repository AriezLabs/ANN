package io;

import org.ejml.data.DMatrixRMaj;

/**
 * Represents a training example with label and input vector
 */
public class Example {
    int label;
    DMatrixRMaj data;

    public Example(int label, DMatrixRMaj data) {
        this.label = label;
        this.data = data;
    }
}
