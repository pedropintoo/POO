package Produtos;

import java.util.*;

public class Livro extends Produto{
    private final String titulo;
    private Set<Autor> lista = new HashSet<>();

    public Livro(String title, double precoBase) {
        super(ProdutoType.LIVRO, precoBase);
        this.titulo = title;
    }

    public Livro(String title, double precoBase, List<Autor> lista) {
        this(title,precoBase);
        this.lista = new HashSet<>(lista);
    }

    @Override
    public String toString() {
        return super.toString() + " ["+super.getCode() + " " + titulo + "]";
    }

    @Override
    public String getDescricao() {
        return titulo;
    }

    @Override
    public double precoVendaAoPublico() {
        return super.getPrecoBase() + super.getPrecoBase()*0.06;
    }

    public int numeroAutores(){
        return lista.size();
    }

    public String autores(){
        return lista.toString();
    }

    public void add(Autor autor){
        lista.add(autor);
    }

    // Getters

    public String getTitulo() {
        return this.titulo;
    }

    public Set<Autor> getLista() {
        return this.lista;
    }
}
