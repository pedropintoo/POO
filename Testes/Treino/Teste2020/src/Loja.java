import Produtos.*;

import java.util.*;
import java.util.stream.Collectors;

public class Loja {
    private String nome;
    private String enderecoWeb;

    private Set<Produto> listPordutos = new TreeSet<>(Comparator.comparing(Produto::getCode));

    public Loja(String nome, String enderecoWeb) {
        this.nome = nome;
        this.enderecoWeb = enderecoWeb;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Loja "+nome+"\n\n");
        str.append(String.format("%6s %-40s %8s %12s \n","Código","Produto","Em Stock","PVP"));
        listPordutos.forEach(produto -> {
            str.append(String.format("%6s %-40s %8s %12.2f \n",produto.getCode(),produto.getDescricao(),produto.getStock(),produto.precoVendaAoPublico()));
        });


        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loja loja)) return false;

        if (!Objects.equals(nome, loja.nome)) return false;
        if (!Objects.equals(enderecoWeb, loja.enderecoWeb)) return false;
        return listPordutos != null ? listPordutos.equals(loja.listPordutos) : loja.listPordutos == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (enderecoWeb != null ? enderecoWeb.hashCode() : 0);
        result = 31 * result + (listPordutos != null ? listPordutos.hashCode() : 0);
        return result;
    }

    public String electrodomesticosClasseX(String classe){
        ClasseEnergetica classeEnergetica = ClasseEnergetica.valueOf(classe);
        StringBuilder str = new StringBuilder();
        listPordutos.stream().filter(produto -> produto instanceof Electrodomestico electrodomestico
                && electrodomestico.getClasseEnergetica() == classeEnergetica)
                .forEach(produto -> str.append(String.format("%-30s %10.2f %s %s",produto.getDescricao(),produto.precoVendaAoPublico(),"Euros",((Electrodomestico) produto).getClasseEnergetica().name())).append("\n"));
        return str.toString();
    }

    public String produtosPrecoFinalSuperiorA(double precoFinalMin){
        StringBuilder str = new StringBuilder();
        listPordutos.stream()
                .filter(produto -> produto.precoVendaAoPublico() > precoFinalMin)
                .forEach(produto -> str.append(String.format("%-30s %10.2f %s",produto.getDescricao(),produto.precoVendaAoPublico(),"Euros")).append("\n"));
        return str.toString();
    }

    public void reorder(){
        Set<Produto> temp = new TreeSet<>(Comparator.comparing(Produto::getDescricao));
        temp.addAll(listPordutos);
        listPordutos = temp;
    }

    public Produto getProdutoPelaDescricao(String descricao){
        return listPordutos.stream()
                .filter(produto -> produto.getDescricao().equalsIgnoreCase(descricao))
                .findFirst()
                .orElse(null);
    }

    public void add(Produto produto){
        if(produto.getStock() == 0) produto.setStock(1);
        listPordutos.add(produto);
    }

    public int totalItems() {
        return listPordutos.stream().mapToInt(Produto::getStock).sum();
    }

    // aceder apartir de descricao

    // Getters

    public String getNome() {
        return this.nome;
    }

    public String getEnderecoWeb() {
        return this.enderecoWeb;
    }

    public Set<Produto> getListPordutos() {
        return this.listPordutos;
    }

    // Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEnderecoWeb(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
    }
}
