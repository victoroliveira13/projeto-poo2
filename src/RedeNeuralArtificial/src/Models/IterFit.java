package Models;

import BLL.NeuralNetowrkBLL;

public class IterFit extends Model {

    public IterFit(NeuralNetowrkBLL neuralNetowrkBLL){
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
        this.neuralNetowrkBLL.setModel(new Fitted(getNeuralNetowrkBLL()));
    }

    @Override
    public void HandleFitRegularPerformance() { }

    @Override
    public void HandleFitBadPerformance() {
        this.neuralNetowrkBLL.setModel(new Unftted(getNeuralNetowrkBLL()));
    }

    public NeuralNetowrkBLL getNeuralNetowrkBLL() {
        return neuralNetowrkBLL;
    }
}
