package Models;

import BLL.NeuralNetowrkBLL;
import Constants.FitPerformance;

public class Fitted extends Model{

    public Fitted(NeuralNetowrkBLL neuralNetowrkBLL) {
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
    public void HandleFitGoodPerformance() { }

    @Override
    public void HandleFitRegularPerformance() {
        this.getNeuralNetowrkBLL().setModel(new IterFit(getNeuralNetowrkBLL()));
    }

    @Override
    public void HandleFitBadPerformance() {
        this.getNeuralNetowrkBLL().setModel(new Unftted(getNeuralNetowrkBLL()));
    }
}
