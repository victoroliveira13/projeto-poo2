package Models;

import BLL.NeuralNetowrkBLL;

public abstract class Model {

    NeuralNetowrkBLL neuralNetowrkBLL;

    public Model(NeuralNetowrkBLL neuralNetowrkBLL){
        this.neuralNetowrkBLL = neuralNetowrkBLL;
    }

    // Faz fit e retorna se foi satisfatorio ou não
    public abstract void fit();
    public abstract void HandleFitGoodPerformance();
    public abstract void HandleFitRegularPerformance();
    public abstract void HandleFitBadPerformance();

    public NeuralNetowrkBLL getNeuralNetowrkBLL() {
        return neuralNetowrkBLL;
    }
}
