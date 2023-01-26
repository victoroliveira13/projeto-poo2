package KVizinhos;
public class Classificado extends Objeto implements Comparable<Classificado>{
    private double x;
    private double y;
    private String tipo;
    private double distancia;

    public Classificado(double x, double y, String tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setY(double y) {
        this.y = y;       
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    @Override
    public int compareTo(Classificado o) {
        if (this.distancia > o.getDistancia()) return -1; 
        if (this.distancia < o.getDistancia()) return 1; 
        return 0; 
    }

    @Override
    public String toString() {
        return  "\n{X: " + this.x
                + "Y: " + this.y
                + ", tipo: " + this.tipo 
                + ", distancia: " + this. distancia
                + "}";
    }
}
