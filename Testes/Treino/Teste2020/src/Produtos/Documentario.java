package Produtos;

import java.util.Objects;

public class Documentario extends Produto{
    private final String titulo;
    private final int ano;
    private final int duracao;

    public Documentario(String titulo, int ano, int duracao, double precoBase) {
        super(ProdutoType.DOCUMENTARIO, precoBase);
        this.titulo = titulo;
        this.ano = ano;
        this.duracao = duracao;
    }

    @Override
    public String getDescricao() {
        return titulo;
    }

    @Override
    public String toString() {
        return super.toString() + " ["+super.getCode() + " " + titulo + " " + ano + " " + duracao + " min" + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Documentario that)) return false;

        if (ano != that.ano) return false;
        if (duracao != that.duracao) return false;
        return Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        int result = titulo != null ? titulo.hashCode() : 0;
        result = 31 * result + ano;
        result = 31 * result + duracao;
        return result;
    }

    // Getters

    public String getTitulo() {
        return this.titulo;
    }

    public int getAno() {
        return this.ano;
    }

    public int getDuracao() {
        return this.duracao;
    }
}
