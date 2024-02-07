package aula08.ex3;

public class ProdutoGenerico implements Produto{
    private final String nome;
    private int quantidadeStock;
    private final double preco;

    public ProdutoGenerico(String nome, int quantidadeStock, double preco) {
        this.nome = nome;
        this.quantidadeStock = quantidadeStock;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome +" " + preco + "€";
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public int getQuatidade() {
        return this.quantidadeStock;
    }

    @Override
    public void adidiconarQuantidade(int quantidade) {
        this.quantidadeStock += quantidade;
    }

    @Override
    public void removerQuantidade(int quantidade) {
        this.quantidadeStock -= quantidade;
    }
}
