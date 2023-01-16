package Models;

import BLL.NeuralNetowrkBLL;

public class Unftted extends Model{
    NeuralNetowrkBLL neuralNetowrkBLL;

    public Unftted(NeuralNetowrkBLL neuralNetowrkBLL){
        super(neuralNetowrkBLL);
    }

    @Override
    public void fit() {
        switch (this.getNeuralNetowrkBLL().getFitPerformance()){
            case REGULAR:
                this.getNeuralNetowrkBLL().setModel(new IterFit(getNeuralNetowrkBLL()));
                break;
            case GOOD:
                this.getNeuralNetowrkBLL().setModel(new Fitted(getNeuralNetowrkBLL()));
                break;
            case BAD:
                this.getNeuralNetowrkBLL().setModel(new Unftted(getNeuralNetowrkBLL()));
                break;
        }
    }

    @Override
    public void HandleFitGoodPerformance() {
        this.getNeuralNetowrkBLL().setModel(new Fitted(getNeuralNetowrkBLL()));
    }

    @Override
    public void HandleFitRegularPerformance() {
        this.getNeuralNetowrkBLL().setModel(new IterFit(getNeuralNetowrkBLL()));
    }

    @Override
    public void HandleFitBadPerformance() { }
}