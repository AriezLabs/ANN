# ANN

Simple ANN (re)written from almost scratch (only uses [EJML][1] for matrix operations). In development. Largely built according to [Make Your Own Neural Net][2] book, but aims to extend that in some aspects (e.g. number of layers).

This is the second incarnation of this project. The original code can be found in the `old/` directory and peaked at 97.7% accuracy on MNIST using a single hidden layer with 200 neurons and 10 epochs of training.

### Usage

The rewrite is not functional as of now. The original code works, however. Simply compile DigitRecognizer.java and run it.

### Future Improvements

This is just a short list of possibilities.

* Allow arbitrary numbers of layers
* Parallelize training
* Try to figure out what the network is actually doing
* Polish and add notes on NNs
* Add visualizations for the evolution of weights etc.

[1]: https://github.com/makeyourownneuralnetwork/makeyourownneuralnetwork
[2]: http://ejml.org/wiki/index.php?title=Main_Page
