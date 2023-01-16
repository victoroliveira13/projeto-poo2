package BLL;
import Constants.ActivationFunction;
import Constants.FitPerformance;
import Models.Model;
import Models.Unftted;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Helper.Helper.calculateSigmoid;
import static Helper.Helper.getRandomNumberInRange;

public class NeuralNetowrkBLL {
    public int LayersNumber;
    public int NeurousByLayerNumber;
    public ActivationFunction ActivationFunction;
    public Double LearningRate;

    public FitPerformance fitPerformance;
    public Model Model;

    public NeuralNetowrkBLL(int LayersNumber, int NeurousByLayerNumber){
        this.LayersNumber = LayersNumber;
        this.NeurousByLayerNumber = NeurousByLayerNumber;
        this.Model = new Unftted(this);
        //this.fitPerformance = FitPerformance.REGULAR;
    }

    public void setModel(Models.Model model) {
        Model = model;
    }

    public Models.Model getModel() {
        return Model;
    }

    public void setFitPerformance(FitPerformance fitPerformance) {
        this.fitPerformance = fitPerformance;
    }

    public FitPerformance getFitPerformance() {
        return fitPerformance;
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        ActivationFunction = activationFunction;
    }

    public ActivationFunction getActivationFunction() {
        return ActivationFunction;
    }

    public void setLayersNumber(int layersNumber) {
        LayersNumber = layersNumber;
    }

    public int getLayersNumber() {
        return LayersNumber;
    }

    public void setNeurousByLayerNumber(int neurousByLayerNumber) {
        NeurousByLayerNumber = neurousByLayerNumber;
    }

    public int getNeurousByLayerNumber() {
        return NeurousByLayerNumber;
    }

    public void setLearningRate(Double learningRate) {
        LearningRate = learningRate;
    }

    public Double getLearningRate() {
        return LearningRate;
    }

    public List<Double> generanteWeights(){
        int neuronsNumber = getNeurousByLayerNumber();
        List<Double> weightsList =  new ArrayList<Double>();;

        for (int i = 0; i < neuronsNumber; i++){
            Random random = new Random();
            weightsList.add(random.nextDouble());
        }

        return weightsList;
    }

    public void classifatePerformance(List<Double> resultList){
        // TODO - RECEBER EXPECTED RESULTS POR PARÂMETRO
        // COMPARAR PORCENTAGEM DE SEMELHANÇA
        this.setFitPerformance(FitPerformance.GOOD);
    }

    public List<Double> generanteInputData(){
        int neuronsNumber = getNeurousByLayerNumber();
        List<Double> inputList = new ArrayList<Double>();

        for (int i = 0; i < neuronsNumber; i++){
            Random random = new Random();
            inputList.add(random.nextDouble());
            // int inputNumber = getRandomNumberInRange(1, neuronsNumber);
            // inputList.add(inputNumber);
        }

        return inputList;
    }

    public Double generanteBias(){
        Random random = new Random();
        return random.nextDouble();
    }

    public List<Double> generateOutput(List<Double> inputList){
        List<Double> outputList =  new ArrayList<Double>();;
        List<Double> weightList = generanteWeights();

        for (int i = 0; i < getNeurousByLayerNumber(); i++){
            Double biasedResult = (inputList.get(i) * weightList.get(i))+generanteBias();
            Double outputValue = calculateSigmoid(biasedResult);
            outputList.add(outputValue);
        }
        return outputList;
    }

    public void fit(){
        List<Double> processedData =  new ArrayList<Double>();;

        for (int i = 0; i < getNeurousByLayerNumber(); i++){

            if(i == 0){
                processedData = generateOutput(generanteInputData());
            }else{
                processedData = generateOutput(processedData);
            }

            // CADA PROCESSAMENTO INDICA UMA TRANSIÇÃO E SENDO ASSIM, ELA É CLASSIFICADA.
            classifatePerformance(processedData);

            getModel().fit();
        }

        printModel(processedData);
    }

    public void printModel(List<Double> resultList){
        System.out.println("OS RESULTADOS GERADOS FORAM: ");
        System.out.println(resultList.toString());
    }

    public void measureModel(FitPerformance fitPerformance){
        switch(fitPerformance) {
            case BAD:
                System.out.println("PERFORMANCE FOI RUIM");
                break;
            case REGULAR:
                System.out.println("PERFORMANCE FOI NORMAL");
                break;
            case GOOD:
                System.out.println("PERFORMANCE FOI BOA");
                break;
            case GREAT:
                System.out.println("PERFORMANCE FOI ÓTIMA");
                break;
            default:
                System.out.println("CATEGORIA INEXISTENTE");
                break;
        }
    }
}
