package aula08.ex2.Alimento.Carne;

import aula08.ex2.Alimento.Alimento;

public class Carne extends Alimento {
    private final VariedadeCarne variedade;

    public Carne(VariedadeCarne variedade, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.variedade = variedade;
    }

    @Override
    public String toString() {
        return "Carne "+variedade.name()+", "+super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carne carne)) return false;
        if (!super.equals(o)) return false;

        return variedade == carne.variedade;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (variedade != null ? variedade.hashCode() : 0);
        return result;
    }
}
