package aula08.ex1.Pesado;

import aula08.ex1.VeiculosMotorizados;

public class Pesado extends VeiculosMotorizados {
    private final int numeroQuadro;
    private final double peso;

    public Pesado(String matricula, String marca, String modelo, int potencia, int numeroQuadro, double peso) {
        super(matricula, marca, modelo, potencia);
        this.numeroQuadro = numeroQuadro;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return super.toString() + ", numeroQuadro=" + numeroQuadro +
                ", peso=" + peso;
    }
}
