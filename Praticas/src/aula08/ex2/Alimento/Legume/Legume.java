package aula08.ex2.Alimento.Legume;

import aula08.ex2.Alimento.Alimento;
import aula08.ex2.Alimento.Vegetariano;

import java.util.Objects;

// Alimento vegetariano
public class Legume extends Alimento implements Vegetariano {
    private final String nome;

    public Legume(String nome, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Legume "+nome+", "+super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Legume legume)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(nome, legume.nome);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }
}
