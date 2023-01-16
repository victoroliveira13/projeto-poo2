package KVizinhos;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teste  {
    public static void main(String[] args) {
        List<Classificado> objetoC = new ArrayList<>();
        List<Classificado> knn = new ArrayList();
        Random r = new Random();
        Integer K = 3;

        //criação de 1 objeto de tipo desconhecido
        Desconhecido objetoD = new Desconhecido(r.nextFloat(), r.nextFloat());
        System.out.println("\nObjeto desconhecido: " + objetoD);

        //criação de 3 objetos dos tipos circulo & quadrado cada
        for(int i = 0; i<3; i++){
            Classificado classificado = new Classificado(r.nextFloat(), r.nextFloat(), "circulo");
            classificado.setDistancia(Math.pow((objetoD.getX() - classificado.getX()), 2) + Math.pow((objetoD.getY() - classificado.getY()), 2));
            objetoC.add(classificado);
        }
        for(int i = 0; i<3; i++){
            Classificado classificado = new Classificado(r.nextFloat(), r.nextFloat(), "quadrado");
            classificado.setDistancia(Math.pow((objetoD.getX() - classificado.getX()), 2) + Math.pow((objetoD.getY() - classificado.getY()), 2));
            objetoC.add(classificado);
        }

        //Ordenando os objetos classificados pela distancia do desclassificado
        Collections.sort(objetoC, Collections.reverseOrder());
        System.out.println("\nObjetos conhecidos: " + objetoC);
        
        //guardando os K objetos mais proximos do objeto desconhecido
        for(int i = 0; i<K; i++) knn.add((objetoC.get(i)));
        //System.out.println(knn); //(teste) ok

        //obtendo o tipo mais compativel
        Integer quadrado = 0;
        Integer circulo = 0;
        String tipo = "";
        for(Classificado i : knn){
            if(i.getTipo() == "quadrado") quadrado++;
            if(i.getTipo() == "circulo") circulo ++;
        }
        if(quadrado > circulo) tipo = "quadrado";
        else tipo = "circulo";
        //System.out.println(tipo); //(teste) ok

        //Classificando objeto desconhecido
        objetoD.setTipo(tipo);
        System.out.println("\nObjeto desconhecido classificado: " + objetoD);
    }
}