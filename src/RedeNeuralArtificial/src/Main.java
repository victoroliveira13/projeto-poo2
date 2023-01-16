import BLL.NeuralNetowrkBLL;
import Models.Unftted;

public class Main {

    public static void main(String[] args) {
        NeuralNetowrkBLL neuralNetwork = new NeuralNetowrkBLL(2,2);

        neuralNetwork.fit();
    }
}