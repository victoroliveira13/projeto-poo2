package KVizinhos;

public class Desconhecido extends Objeto{
    private double x;
    private double y;
    String tipo; //a descobrir

    public Desconhecido(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getY() {
        return this.y;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return "\n{X: " + this.x
                + ", Y: " + this.y
                + ", tipo: " + this.tipo 
                + "}";
    }
}
