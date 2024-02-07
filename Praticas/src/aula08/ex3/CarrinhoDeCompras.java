package aula08.ex3;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarrinhoDeCompras implements  Compra{
    private final Map<Produto, Integer> listaProdutos = new LinkedHashMap<>();

    @Override
    public void adicionarProduto(Produto produto, int quantidade) {
        if(produto.getQuatidade() - quantidade > 0){
            produto.removerQuantidade(quantidade);
            if(listaProdutos.containsKey(produto)){
                listaProdutos.put(produto, quantidade + listaProdutos.get(produto));
            }
            else{
                listaProdutos.put(produto, quantidade);
            }
        }
    }

    @Override
    public void listarProdutos() {
        for (Map.Entry<Produto, Integer> entry : this.listaProdutos.entrySet()) {
            System.out.println("["+entry.getValue()+"] - "+entry.getKey());
            System.out.println();
        }
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for(Map.Entry<Produto, Integer> entry : this.listaProdutos.entrySet()){
            total += (entry.getValue() * entry.getKey().getPreco());
        }
        return total;
    }
}
