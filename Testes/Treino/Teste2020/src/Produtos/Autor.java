package Produtos;

import java.util.Objects;

public class Autor {
    private final String nome;
    private final int anoNascimento;

    public Autor(String nome, int anoNascimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    @Override
    public String toString() {
        return nome+" ("+anoNascimento+"-)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor autor)) return false;

        if (anoNascimento != autor.anoNascimento) return false;
        return Objects.equals(nome, autor.nome);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + anoNascimento;
        return result;
    }

    // Getters

    public String getNome() {
        return this.nome;
    }

    public int getAnoNascimento() {
        return this.anoNascimento;
    }
}
