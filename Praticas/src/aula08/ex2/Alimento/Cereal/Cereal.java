package aula08.ex2.Alimento.Cereal;

import aula08.ex2.Alimento.Alimento;
import aula08.ex2.Alimento.Vegetariano;

import java.util.Objects;

// Alimento vegetariano
public class Cereal extends Alimento implements Vegetariano {
    private final String nome;

    public Cereal(String nome, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cereal "+nome+", "+super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cereal cereal)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(nome, cereal.nome);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }
}
