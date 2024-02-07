package aula08.ex2.Alimento.Peixe;

import aula08.ex2.Alimento.Alimento;

public class Peixe extends Alimento {
    private final TipoPeixe tipo;

    public Peixe(TipoPeixe tipo, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Peixe "+tipo.name()+", "+super.toString();
    }
}
