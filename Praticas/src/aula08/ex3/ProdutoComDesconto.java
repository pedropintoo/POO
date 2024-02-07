package aula08.ex3;

public class ProdutoComDesconto extends ProdutoGenerico{

    public ProdutoComDesconto(String nome, int quantidadeStock, double preco, double desconto) {
        super(nome, quantidadeStock, preco - preco*(desconto/100));
    }
}
