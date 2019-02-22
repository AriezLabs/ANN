package io;

import org.ejml.data.DMatrixRMaj;

import java.io.*;
import java.util.Arrays;

/**
 * read csv file line by line, assuming first datapoint is the label and the rest are the input
 * return according examples
 */
public class CSVParser implements ExampleSupplier{
    private BufferedReader br;

    public CSVParser(String pathToCsv) throws FileNotFoundException {
        this(new File(pathToCsv));
    }

    public CSVParser(File csvData) throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(csvData));
    }

    /**
     * @return null if any error occurs!
     */
    public Example getNext() {
        try {
            String line = br.readLine();
            if(line == null) {
                br.close();
                return null;
            }
            int[] data = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
            if(data == null)
                return null;
            DMatrixRMaj mat = new DMatrixRMaj(data.length - 1, 1);
            for (int i = 0; i < data.length - 1; i++)
                mat.set(i, 0, data[i + 1]);
            return new Example(data[0], mat);
        } catch (IOException e) {
            return null;
        }
    }
}
