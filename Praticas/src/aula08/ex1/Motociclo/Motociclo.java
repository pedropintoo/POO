package aula08.ex1.Motociclo;

import aula08.ex1.VeiculosMotorizados;

public class Motociclo extends VeiculosMotorizados {
    private final TipoMotociclo tipo;

    public Motociclo(String matricula, String marca, String modelo, int potencia, TipoMotociclo tipo) {
        super(matricula, marca, modelo, potencia);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", tipo=" + tipo;
    }
}
